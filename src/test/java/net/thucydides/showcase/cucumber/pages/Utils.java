package net.thucydides.showcase.cucumber.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utils {

	private static FileReader reader;
	private static String adminUsername;
	@SuppressWarnings("unused")
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
	
	// incident user
	public static String incident_Username() {
		readCredentials();

		adminUsername = p.getProperty("incidentUser");
		return adminUsername;
	}

	public static String incident_Password() {
		readCredentials();
		return adminPassword = p.getProperty("incidentPassword");
	}

	//ESS User
	public static String ESS_Username() {
		readCredentials();

		adminUsername = p.getProperty("ESSUser");
		return adminUsername;
	}

	public static String ess_Password() {
		readCredentials();
		return adminPassword = p.getProperty("essPassword");
	}


}
