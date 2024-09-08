package com.example.CipherGame;

import com.example.CipherGame.Entity.CryptoText;
import com.example.CipherGame.Entity.Keys;
import com.example.CipherGame.Repo.CryptoRepo;
import com.example.CipherGame.Service.CryptoService;
import com.example.CipherGame.Service.KeysService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@SpringBootApplication
public class CipherGameApplication {

	public static void main(String[] args) {SpringApplication.run(CipherGameApplication.class, args);

		boolean isTrue = true;

		CryptoService cryptoService = new CryptoService();
		KeysService keysService = new KeysService();
		while (isTrue){
			Scanner scanner = new Scanner(System.in);
			System.out.println("What you want to do?");
			System.out.println("1 Insert Text ");
			System.out.println("2 Get back text");
			System.out.println("3 Show all cryptoText");

			try {
				int num = scanner.nextInt();
				if (num == 1){

					KeyGenerator keyGen = KeyGenerator.getInstance("AES");
					keyGen.init(128);
					SecretKey secretKey = keyGen.generateKey();

					Cipher cipher = Cipher.getInstance("AES");
					Scanner scanner1 = new Scanner(System.in);

					System.out.println("Text: ");
					String str = scanner1.nextLine();

					cipher.init(Cipher.ENCRYPT_MODE, secretKey);
					byte[] encryptedData = cipher.doFinal(str.getBytes());
					System.out.println("Encrypted text: " + new String(encryptedData));

					Keys key = new Keys();
					key.setKey(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
					keysService.saveKey(key);

					CryptoText cryptoText = new CryptoText();
					cryptoText.setSuperKey(key.getId());
					cryptoText.setText(Base64.getEncoder().encodeToString(encryptedData));
					cryptoService.saveEntity(cryptoText);
				} else if (num == 2) {
					System.out.println("Enter key ID:");
					int keyId = scanner.nextInt();
					Keys key = keysService.getKeyById(keyId);

					System.out.println("Enter text ID:");
					int textId = scanner.nextInt();
					CryptoText cryptoText = cryptoService.findAll().get(textId);

					byte[] decodedKey = Base64.getDecoder().decode(key.getKey());
					SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

					Cipher cipher = Cipher.getInstance("AES");
					cipher.init(Cipher.DECRYPT_MODE, originalKey);
					byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(cryptoText.getText()));

					System.out.println("Decrypted text: " + new String(decryptedData));

				} else if (num == 3) {
					System.out.println("All encrypted texts:");
					List<CryptoText> texts = cryptoService.findAll();
					for (CryptoText text : texts) {
						System.out.println("ID: " + text.getId() + ", Text: " + text.getText());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
