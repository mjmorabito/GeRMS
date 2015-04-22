/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Samir
 * EncryptionDecryptionAES class encrypts and decrypts text using AES Cipher and SecretKey
 */
public class EncryptionDecryptionAES {
   
    // Cipher class used for encyrpting and decrypting
    private Cipher cipher;
    
    // String key used to store the SecretKey in the DB to later be retrieved for decrypting purposes
    private String key;

    // Blank constructor
    public EncryptionDecryptionAES() {  
    }

    // Encrypts text and saves the SecretKey as a String so it can be saved in the DB
    public String encrypt(String plainText) throws Exception {
        
        // KeyGenerator class generates a key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        
        // Sets the number of bits for the key
        keyGenerator.init(128);
        
        // Creates a new secrey key
        SecretKey secretKey = keyGenerator.generateKey();
        
        // AES cipher
        cipher = Cipher.getInstance("AES");
        
        // Stores the SecretyKey as a String so it can be saved in the DB
        key  = Base64.getEncoder().encodeToString(secretKey.getEncoded());
                       
        // Encrypts the text using the Secret Key and the cipher
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        
        // Encrypted text
        String encryptedText = encoder.encodeToString(encryptedByte);
        
        // Returns the encrypted text
        return encryptedText;
            
    }

    // Returns a decrypted text
    public String decrypt(String encryptedText, SecretKey key) throws Exception {
        
        // AES Cipher
        cipher = Cipher.getInstance("AES");
        
        // Decrypts the text using the SecreyKey and AES Cipher
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        
        // Descrypted text
        String decryptedText = new String(decryptedByte);
        
        // Returns the decrypted text
        return decryptedText;
        
    }
    
    // Returns the SecretKey as a String
    public String getKey() {
        return key;
    }
    
}