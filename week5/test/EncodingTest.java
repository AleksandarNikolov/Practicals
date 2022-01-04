package ss.week5.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";
        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        
        byte[] byteArray = Hex.decodeHex("4d6f64756c652032");
        String encodedString = new String(byteArray);
        System.out.println(encodedString);
        
        
        System.out.println(Base64.encodeBase64String("Hello World".getBytes()));
        
        
        byteArray = Hex.decodeHex("010203040506");
        System.out.println(Base64.encodeBase64String(byteArray));
        
        
        byteArray = Base64.decodeBase64("U29mdHdhcmUgU3lzdGVtcw==");
        String decodedBase = new String(byteArray);
        System.out.println(decodedBase);
        
        System.out.println(Base64.encodeBase64String("a".getBytes()));
        System.out.println(Base64.encodeBase64String("aa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaaaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaaaaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaaaaaaa".getBytes()));
        
        
    }
}
