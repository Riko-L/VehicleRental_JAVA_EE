package com.campusnumerique.vehiclerental.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;


public class HashPassword {

	public static String securePassword(String passwordToHash )throws NoSuchAlgorithmException, NoSuchProviderException {
		
		return getSecurePassword(passwordToHash);
	}

	private static String getSecurePassword(String passwordToHash) {
		
	        String generatedPassword = null;
	        try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(passwordToHash.getBytes());
	            //Get the hash's bytes
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            generatedPassword = sb.toString();
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }
		return generatedPassword;
	}

//	// Add salt
//	private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
//		// Always use a SecureRandom generator
//		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
//		// Create array for salt
//		byte[] salt = new byte[16];
//		// Get a random salt
//		sr.nextBytes(salt);
//		// return salt
//		return salt;
//	}

}
