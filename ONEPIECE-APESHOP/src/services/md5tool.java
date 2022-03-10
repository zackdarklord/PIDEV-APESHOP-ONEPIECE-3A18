/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author zakar
 */
public class md5tool {
    private final byte[] DESIV = new byte[] { 0x22, 0x54, 0x36, 110, 0x40, (byte) 0xac, (byte) 0xad, (byte) 0xdf };// vector     
    private AlgorithmParameterSpec iv = null;// Parameter interface of encryption algorithm
    private Key key = null;
    private String charset = "utf-8";
    
     public md5tool(String deSkey, String charset) throws Exception {
        if (StringUtils.isNotBlank(charset)) {
            this.charset = charset;
        }
        DESKeySpec keySpec = new DESKeySpec(deSkey.getBytes(this.charset));// Set key parameters
        iv = new IvParameterSpec(DESIV);// Set vector
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// Get key factory
        key = keyFactory.generateSecret(keySpec);// Get key object
    }
      public String encode(String data) throws Exception {
        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// Get Cipher
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// Set the working mode to encryption mode, and give the key and vector
        byte[] pasByte = enCipher.doFinal(data.getBytes(this.charset));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(pasByte);
    }
       public String decode(String data) throws Exception {
        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //Note here that the number of bits of the parameter of doFinal() must be a multiple of 8, otherwise an error will be reported (the number of bits of the parameter of doFinal() here is not a multiple of 8, because the number of bits of the parameter of final() is not a multiple of 8, because the number of bits of the parameter can be read by encode encrypted string is 8, but it can be read by writing the file and read again)
        //base64Decoder must be used here, if data is used. getBytes(), the number of bytes array of the string obtained is probably not a multiple of 8, and does not correspond to the BASE64Encoder above (even if the decryption does not report an error, it will not get the correct result)
        byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));
        return new String(pasByte, this.charset);
    }
}
