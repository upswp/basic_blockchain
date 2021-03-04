package Part2;

import javax.naming.CompositeName;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Transaction {
    // 송신자의 공개키
    public String transactionId;
    // 보내는 사람 주소
    public PublicKey sender;
    // 받는 사람의 주소
    public PublicKey reciepient;
    // 보내는 금액
    public float value;
    // 서명
    public byte[] signature;

    public ArrayList<TransactionInput> inputs = new ArrayList<>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<>();

    public static int sequence = 0;

    /**
     * Transaction 생성
     *
     * @param from   보내는 사람
     * @param to     받는사람
     * @param value  금액
     * @param inputs 이전 트랜잭션에 대한 input
     */
    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.inputs = inputs;
    }

    /**
     * Tx 검증해주기, 중간에 에러가 발생하면 정지
     *
     * @return Tx 검증이 올바르면 true
     */
    public boolean processTransaction() {
        // 1. 서명 검증
        if (!verifySignature()) return false;

        // 2. 메인합수에 임시 저장된 TxOutId로 UTXO(사용되지 않은게 맞는지 확인)
        /**
         * 여기서의 TransactionInput은 이전 genesis or 이전 TX의 Out에 해당한다.
         * 그러므로 여기서 해당 Input이 전달되어 넘어온 값을 value값을 체크하고 송금이 가능한지 체크한다.
         */
        // wallet에서 만들어진 inputs를 가져온다.
        for (TransactionInput i : inputs) {
            // main에서 관리하고있는 TXoutPut을 가져오고 가져온 값을 현재의 UTXO에 넣어준다.
            i.UTXO = Main.UTXOs.get(i.transactionOutputId);

        }
        // 3. 최소단위 0.1f 를 넘는지 체크
        if (getInputValue() < Main.minimumTransaction) return false;

        // 4. TxOutPut 100 value : 40,60
        transactionId = calculateHash();
        float leftOver = getInputValue() - value;
            // 40코인 전송
        outputs.add(new TransactionOutput(this.reciepient, value, transactionId));
            // 60 코인 저장
        outputs.add(new TransactionOutput(this.sender, leftOver, transactionId));

        // 5. output to Unspent list(output들을 main함수 쪽으로 연결시켜주기)
        for (TransactionOutput o : outputs){
            Main.UTXOs.put(o.id, o);
        }
        // 6. remove Txinput(기존의 main에 설정되있던 TXout을 삭제하기)
        for (TransactionInput i : inputs){
            if (i.UTXO.id == null)  continue;
            Main.UTXOs.remove(i.UTXO.id);
        }

        return true;
    }

    public String calculateHash() {
        sequence++;
        return BlockUtil.applySha256(BlockUtil.getStringFromKey(sender) +
                BlockUtil.getStringFromKey(reciepient) +
                Float.toString(value) + sequence);
    }

    private float getInputValue() {
        float total = 0;
        for (TransactionInput i : inputs) {
            if (i.UTXO == null) continue;
            total += i.UTXO.value;
        }
        return total;
    }


    /**
     * sender와 reciepient와 value를 넣어줘서 String으로 선언한 변수 data에 넣어줌
     *
     * @return BlockUtil.verifyECDSASig로 전송
     */
    public boolean verifySignature() {
        String data = BlockUtil.getStringFromKey(sender) + BlockUtil.getStringFromKey(reciepient) + Float.toString(value);
        return BlockUtil.verifyECDSASig(sender, data, signature);
    }

    /**
     * 서명 생성
     * 서명의 조건은
     * 1. 보내는사람, 받는사람, 금액 data로 저장
     * 2. 본인의 PrivateKey가 들어감.
     *
     * @param privateKey
     */
    public void generateSignature(PrivateKey privateKey) {
        String data = BlockUtil.getStringFromKey(sender) + BlockUtil.getStringFromKey(reciepient) + Float.toString(value);
        signature = BlockUtil.applyECDSASig(privateKey, data);
    }


}
