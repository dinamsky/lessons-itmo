package lesson13.crypto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {
  private byte[] key;
  private int currentKeyPosition;


    public CryptoOutputStream() {
        super(nullOutputStream());


    }


    @Override
    public void write(int b) throws IOException {
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }

    public static void main(String[] args) {


    }
}
