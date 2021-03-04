package Part1;

import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public long timeStamp;
    public int nonce;

    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = caculateHash();
    }

    public String caculateHash(){
        String hash = BlockUtil.applySha256(previousHash + data
                + Integer.toString(nonce)
                + Long.toString(timeStamp));
        return hash;
    }

    public void mineBlock(int difficulty){
        //target = difficulty에 따라서 값을 자리 앞에 0을 몇개 붙일지 정함.
        String target = BlockUtil.getDifficultyString(difficulty);
        // 작성된 hash의 앞자리가 difficulty까지 0이 일치할때까지 hash를 생성해라.
        while(!hash.substring(0,difficulty).equals(target)){
            nonce++;
            hash = caculateHash();
            System.out.println("nonce:"+nonce+" "+"target:"+target+" "+"hash:"+hash);
        }
    }
}
