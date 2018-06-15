import java.util.Scanner;

public class CaesarCode {
	
	private String alphabet;
	private int[] alphabetInt = new int[26];
	private Scanner myScanner = new Scanner(System.in);
	
	public CaesarCode(){
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		}
	
	public void startEnc() {
		System.out.println("Please give the plaintext (in capitals)");
		String plaintext = myScanner.next();
		System.out.println("Give the key shift");
		int key = myScanner.nextInt();
		encryptionC(plaintext, key);
	}
	
	public void encryptionC(String plaintext, int key) {
		//Convert plaintext to numbers 
		String shift = " ";
		String ciphertext = "";
		for (int i = 0; i < plaintext.length(); i ++) {
			
			alphabetInt[i] =  alphabet.indexOf(plaintext.charAt(i));
			
			//Apply encryption
			alphabetInt[i] = (alphabetInt[i] + key) % 26;
			shift += " " + alphabetInt[i];
			
			//Convert back into letters		
			char replace = alphabet.charAt(alphabetInt[i]);		
			ciphertext += replace;
		}
		System.out.println("Cipher Shift in Numbers:" + shift);
		System.out.println("Ciphertext:" + ciphertext);
		
		decryptionC(ciphertext, key);
	}
	
	public void decryptionC(String ciphertext, int key){
		
		String numbers = " ";
		String plaintext = " ";
		
		for (int i = 0; i < ciphertext.length(); i ++) {
			//Convert ciphertext to numbers 
			alphabetInt[i] =  alphabet.indexOf(ciphertext.charAt(i));
			//Apply decryption - use floorMod in case of negative numbers
			alphabetInt[i] = Math.floorMod((alphabetInt[i] - key), 26);
			numbers += " " + alphabetInt[i];
			System.out.println();
			
			
			//Retrieve letters from the index 
			char replace = alphabet.charAt(alphabetInt[i]);	
			plaintext += replace;
			
		}
		
		System.out.println("Cipher Shift in Numbers:" + numbers);
		System.out.println("Plaintext:" + plaintext);
		
	}
	
	public static void main (String [] args) {
		CaesarCode c = new CaesarCode();
		
		c.startEnc();
	}
	
}
	
	
	
