package Part2;

import java.util.ArrayList;
import java.util.Date;

public class Block {
    //"0000157", 인간의 지문(고유한키값)
    public String hash;
    // 123 이전 인간에 대한 지문값
    public String previousHash;
    //값을 담는 부분 전송내역...
    public String data;
    //12.2
    public long timeStamp;
    //1000,1221 random
    public int nonce;
    public String merkleRoot;

    public ArrayList<Transaction> transactionList = new ArrayList<>();

    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        //20190210121212
        this.timeStamp = new Date().getTime();
        this.hash = caculateHash();
    }

    public String caculateHash(){
        String hash = BlockUtil.applySha256(previousHash + data
                + Integer.toString(nonce)
                + Long.toString(timeStamp)
                + merkleRoot);
        return hash;
    }

    public void mineBlock(int difficulty){
        merkleRoot = BlockUtil.getMerkleRoot(transactionList);
        //target = difficulty에 따라서 값을 자리 앞에 0을 몇개 붙일지 정함.
        String target = BlockUtil.getDifficultyString(difficulty);
        // 작성된 hash의 앞자리가 difficulty까지 0이 일치할때까지 hash를 생성해라.
        while(!hash.substring(0,difficulty).equals(target)){
            nonce++;
            hash = caculateHash();
            System.out.println("nonce:"+nonce+" "+"target:"+target+" "+"hash:"+hash);
        }
        System.out.println("$$Mined hash$$: "+hash+" nonce: "+nonce);
        System.out.println("===Block Mined!!! : " + hash);
    }

    public boolean addTransaction(Transaction tx) {
        if(tx == null) return false;
        if((!"0".equals(previousHash))) {
            if(tx.processTransaction() != true) {
                return false;
            }
        }
        transactionList.add(tx);
        System.out.println("===Transaction added to Block");
        return true;
    }
}
