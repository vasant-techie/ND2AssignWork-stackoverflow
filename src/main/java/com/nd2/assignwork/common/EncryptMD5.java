package com.nd2.assignwork.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptMD5 {
	
	// Convert Byte to Hex
	public static String convertByteToHex(byte[] data) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < data.length; i++) {
	      sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	  }

	// Hash text Password
	public static String getPassMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(password.getBytes());
			return convertByteToHex(messageDigest);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Hash file
	public static String getFileMD5(File file) {
	    MessageDigest md;
	    try {
	      md = MessageDigest.getInstance("MD5");
	      FileInputStream fis = new FileInputStream(file);
	      byte[] dataBytes = new byte[1024];
	      int nread = 0;
	      while ((nread = fis.read(dataBytes)) != -1) {
	        md.update(dataBytes, 0, nread);
	      }
	      byte[] byteData = md.digest();
	      fis.close();
	      return convertByteToHex(byteData);
	    } catch (NoSuchAlgorithmException | IOException e) {
	      e.printStackTrace();
	      throw new RuntimeException(e);
		}
	}
}
