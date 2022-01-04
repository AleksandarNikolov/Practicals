package ss.week6.dictionaryattack;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Hex;



public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws FileNotFoundException 
	 */
	public void readPasswords(String filename) throws FileNotFoundException {
		File myObj = new File(filename);
		Scanner myReader = new Scanner(myObj);
		this.passwordMap = new HashMap<String, String>();
		while (myReader.hasNext()) {
			String line = myReader.nextLine();
			String username = line.split(": ")[0];
			String password = line.split(": ")[1];
			passwordMap.put(username, password);
		}
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public String getPasswordHash(String password) {
		byte[] hash;
		MessageDigest encode;
		try {
			encode = MessageDigest.getInstance("MD5");
			hash = encode.digest(password.getBytes());
			return Hex.encodeHexString(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        String hashedPassword = getPasswordHash(password);
        return passwordMap.get(user).equals(hashedPassword);
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    public void addToHashDictionary(String filename) {
    	this.hashDictionary = new HashMap<String, String>();
    	File commonPasswordsFile = new File(filename);
    	Scanner myReader;
    	try {
    		myReader = new Scanner(commonPasswordsFile);
    		while (myReader.hasNextLine()) {
    			String password = myReader.nextLine();
    			String hashedPassword = getPasswordHash(password);
    			hashDictionary.put(hashedPassword, password);
    		}
    		myReader.close();
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    }


	public void doDictionaryAttack() {
		String path = "./src/ss/week6/";
		try {
			readPasswords(path + "test/LeakedPasswords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		addToHashDictionary("./src/ss/week6/dictionaryattack/commonPasswords.txt");
		for (String username: passwordMap.keySet()) {
			if (hashDictionary.containsKey(passwordMap.get(username))) {
				System.out.println("Username: " + username + " Password: "
						+ hashDictionary.get(passwordMap.get(username)));
			}
		}
	}
	
	public static void main(String[] args) {
		DictionaryAttack test = new DictionaryAttack();
		test.doDictionaryAttack();
	}
}



