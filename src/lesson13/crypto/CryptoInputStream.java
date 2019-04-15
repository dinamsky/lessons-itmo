package lesson13.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {
    private byte[] key;
    private int currentKeyPosition;

    protected CryptoInputStream(InputStream in, byte[] key){
        super(in);
        this.key = key;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }
}
