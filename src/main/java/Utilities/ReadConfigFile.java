package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {
	Properties prop;
	
	public ReadConfigFile() {
		File file=new File("./Configurations/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}
	
		public String getappurl() {
			String url=prop.getProperty("Url");
			return url;
			
		}
		
		public String getusernamel() {
			String userName=prop.getProperty("userName");
			return userName;
			
		}
		
		public String getPwd() {
			String Pwd=prop.getProperty("Password");
			return Pwd;
			
		}
		
		public String getMenu() {
			String menu=prop.getProperty("Menu");
			return menu;
			
		}
		
		public String getstore() {
			String store=prop.getProperty("store");
			return store;
			
		}
		
		public String getprod() {
			String prod=prop.getProperty("Product");
			return prod;
			
		}
		
		public String getcity() {
			String cityName=prop.getProperty("city");
			return cityName;
		}
		
		public String getzip() {
			String zipcode=prop.getProperty("zipCode");
			return zipcode;
		}
		
		public String getstreetadd() {
			String streetadd=prop.getProperty("streetAddress");
			return streetadd;
		}
		
		public String getmail() {
			String mail=prop.getProperty("Mail");
			return mail;
		}
		
		public String getAccessKey() {
			String accessid=prop.getProperty("accessId");
			return accessid;	
			}
		
		public String getSecreKey() {
			String secretKey=prop.getProperty("secretKey");
			return secretKey;
		}
}
