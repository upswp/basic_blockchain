package Part2;

import java.security.PublicKey;

public class TransactionOutput {
    public String id;
    //받는사람
    public PublicKey reciepient;
    //금액
    public float value;
    //거래에 대한 Tx ID
    public String parentTransactionId;

    /**
     * TransactionOutput 생성자
     * @param reciepient 받는사람
     * @param value 금액
     * @param parentTransactionId 거래에 대한 TX ID
     */
    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = BlockUtil.applySha256(BlockUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
    }

    //

    /**
     * 받는 사람의 주소가 그사람의 계좌주소와 같은지 확인
     * 받는 사람 주소가 == 그 사람의 공계키와 같다면 동일인
     * @param publicKey
     * @return
     */
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == reciepient);
    }
}
