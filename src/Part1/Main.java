package Part1;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Block> blockChain = new ArrayList<>();
    // Hash값의 앞 2자리가 00 으로 시작한다는 의미.
    // 숫자가 높을수록 개발환경이 열악해질 수 있음..
    public static int difficulty = 4;

    public static void main(String[] args) {
        System.out.println("Mining block 1... ");
        addBlock(new Block("first block", "0"));

        System.out.println("Mining block 2... ");
        // 여기서 previousHash값은 1번 블록의 Hash이므로 blockChain.size - 1을 이용하여 이전 값의 hash값을 가져온다.
        // addblock을 진행할때 전체 hash의 크기가 2이므로 -1을 시켜주어 1번 블록의 위치에 해당하는 hash를 가져온다.
        addBlock(new Block("second block",blockChain.get(blockChain.size()-1).hash));

        System.out.println("Mining block 3... ");
        addBlock(new Block("third block",blockChain.get(blockChain.size()-1).hash));
        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = BlockUtil.getJson(blockChain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');


        for(int i=1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);

            if(!currentBlock.hash.equals(currentBlock.caculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }

            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }

            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }

        }
        return true;
    }

    public static void addBlock(Block newBlock){
        newBlock.mineBlock(difficulty);
        blockChain.add(newBlock);
    }
}
