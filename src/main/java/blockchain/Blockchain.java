package blockchain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;

    public static void main(String[] args) {

        blockchain.add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 1... ");
        String str="Hi im the first block"+"0"+new Date().getTime();
        System.out.println(StringUtil.applySha256(str));
       blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Yo im the second block",str));
        System.out.println("Trying to Mine block 2... ");
        str=str+"Yo im the second block"+new Date().getTime();
        System.out.println(StringUtil.applySha256(str));
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Hey im the third block",str));
        System.out.println("Trying to Mine block 3... ");
        str=str+"Hey im the third block"+new Date().getTime();
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
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
}