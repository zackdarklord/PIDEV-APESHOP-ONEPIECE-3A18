import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MD5Tool {
    //Vector (with both vector and key to decrypt), this vector must be 8byte, and any error is reported
    private final byte[] DESIV = new byte[] { 0x22, 0x54, 0x36, 110, 0x40, (byte) 0xac, (byte) 0xad, (byte) 0xdf };// vector     
    private AlgorithmParameterSpec iv = null;// Parameter interface of encryption algorithm
    private Key key = null;
    private String charset = "utf-8";
    
    public static void main(String[] args) {
        try {
            String value = "caililiang Cai Li Liang_WeChat: caililiangcaililiang；Email: 785553790@qq.com";
            String key = "qwrwrww More than 10";// The number of user-defined keys cannot be too short, too short for error reporting, too long. By default, it only takes the first n bits (for the specific value of N, please find the information separately)
            MD5Tool mt= new MD5Tool(key, "utf-8");
            System.out.println("Characters before encryption:" + value);
            System.out.println("Encrypted characters:" + mt.encode(value));
            System.out.println("Decrypted characters:" + mt.decode(mt.encode(value)));
            System.out.println("String MD5 Value:"+getMD5Value(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Constructor
     * @param deSkey
     * @param charset
     * @throws Exception
     */
    public MD5Tool(String deSkey, String charset) throws Exception {
        if (StringUtils.isNotBlank(charset)) {
            this.charset = charset;
        }
        DESKeySpec keySpec = new DESKeySpec(deSkey.getBytes(this.charset));// Set key parameters
        iv = new IvParameterSpec(DESIV);// Set vector
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// Get key factory
        key = keyFactory.generateSecret(keySpec);// Get key object
    }
    
    /**
     * encryption
     * @param data
     * @return
     * @throws Exception
     */
    public String encode(String data) throws Exception {
        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// Get Cipher
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// Set the working mode to encryption mode, and give the key and vector
        byte[] pasByte = enCipher.doFinal(data.getBytes(this.charset));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(pasByte);
    }
    
    /**
     * Decrypt
     * @param data
     * @return
     * @throws Exception
     */
    public String decode(String data) throws Exception {
        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //Note here that the number of bits of the parameter of doFinal() must be a multiple of 8, otherwise an error will be reported (the number of bits of the parameter of doFinal() here is not a multiple of 8, because the number of bits of the parameter of final() is not a multiple of 8, because the number of bits of the parameter can be read by encode encrypted string is 8, but it can be read by writing the file and read again)
        //base64Decoder must be used here, if data is used. getBytes(), the number of bytes array of the string obtained is probably not a multiple of 8, and does not correspond to the BASE64Encoder above (even if the decryption does not report an error, it will not get the correct result)
        byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));
        return new String(pasByte, this.charset);
    }
    
    /**
     * Get the value of MD5, which can be used for comparison and verification
     * @param sourceStr
     * @return
     */
    private static String getMD5Value(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return result;
    }
}