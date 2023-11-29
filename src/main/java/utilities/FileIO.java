package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileIO {

	 public static String FileInputOutput(String key) throws IOException   {
	    	
	    	 
	    	// these codes are to read property files
	        
	    	Properties prop = new Properties();
	    	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\develop.properties";  
	    	FileInputStream file = new FileInputStream(filepath);
	    	prop.load(file);
	    	System.out.println(prop.getProperty("browserType")); 	
	    	
	    String value = prop.getProperty(key);
	    return value;
	    	
	    	 }
	}
