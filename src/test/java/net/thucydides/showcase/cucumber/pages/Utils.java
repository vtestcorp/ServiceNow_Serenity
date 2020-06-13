package net.thucydides.showcase.cucumber.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.auth.UsernamePasswordCredentials;

public class Utils {

	private static FileReader reader;
	private static String adminUsername;
	private static String adminPassword;
	private static Properties p;

	/**
	 * @author Tanveer
	 * 
	 * @since 6/13/2020
	 */
	public static void readCredentials() {
		try {
			reader = new FileReader("serenity.properties");
			p = new Properties();
			p.load(reader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String admin_Username() {
		readCredentials();

		adminUsername = p.getProperty("adminUser");
		return adminUsername;
	}

	public static String admin_Password() {
		readCredentials();
		return adminPassword = p.getProperty("adminPassword");
	}

}
