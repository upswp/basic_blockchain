package Part2;

import Part1.BlockUtil;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static ArrayList<Block> blockChain = new ArrayList<>();
    public static int difficulty = 2;
    //지감 선언 A
    public static Wallet walletA;
    //지갑 선언 B
    public static Wallet walletB;

    //최초의 Transaction genesisTransaction 선언
    public static Transaction genesisTransaction;
    // Transaction을 담을 HashMap형태의 UTXOs를 선언
    public static HashMap<String, TransactionOutput> UTXOs = new HashMap<String, TransactionOutput>();
    // 최소단위로 이체할 금액.
    public static float minimumTransaction = 0.1f;


    public static void main(String[] args) {

        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        /*
         * 1. 지감 생성
         */
        walletA = new Wallet();
        walletB = new Wallet();
        // 코인을 주는 wallet , 채굴이 일어났을때 코인을 주는 wallet
        Wallet coinbase = new Wallet();

        /*
         * 2. genesis transaction을 생성
         */
        // coinbase, 받는사람, 보내는 금액, TransacionInput은 genesis여서 null처리.
        genesisTransaction = new Transaction(coinbase.publicKey, walletA.publicKey, 100f, null);
        //genesis TX에서 서명을 생성한다.
        genesisTransaction.generateSignature(coinbase.privateKey);
        //genesis TX에서 transactionId를 0으로 생성
        genesisTransaction.transactionId = "0";
        //genesis TX에서 transaction output리스트를 생성한다.
        genesisTransaction.outputs.add(
                new TransactionOutput(genesisTransaction.reciepient, genesisTransaction.value, genesisTransaction.transactionId));
        /*
         * 3. Main 함수내 UTXO에 저장한다.
         */
        UTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0));
        /*
         *  4. genesisBlock 생성
         */
        Block genesisBlock = new Block("Genesis block", "0");
        genesisBlock.addTransaction(genesisTransaction);
        addBlock(genesisBlock);
        System.out.println("");
        /*
         * 5. Block 1 생성
         */
        Block block1 = new Block("First block", genesisBlock.hash);
        System.out.println("1. walletA.getBalance(): " + walletA.getBalance());
        System.out.println("2. block1 add 전 " + walletA.getBalance());
        // Wallet A에서 B로 전송
        block1.addTransaction(walletA.sendFunds(walletB.publicKey, 40f));
        addBlock(block1);
        System.out.println("3. walletA.getBalance(): " + walletA.getBalance());
        System.out.println("4. walletB.getBalance(): " + walletB.getBalance());


        String blockchainJson = BlockUtil.getJson(blockChain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    public static void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        blockChain.add(newBlock);
    }
}
