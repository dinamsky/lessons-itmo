package blockchain;

import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    public Block(String data,String previousHash) {
        this.hash = calculateHash();
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
    }
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash + Long.toString(timeStamp) + data
        );
        System.out.println("this hash: "+calculatedhash);
        return calculatedhash;
    }
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
