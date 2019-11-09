package com.myproject.configManager;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.testng.Reporter;

public class PropertiesManager {

	private static HashMap<String, String> data = new HashMap<String, String>();
	
	private PropertiesManager() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 
	 */
	public static void addBundle() {
		getValues();
	}

	/**
	 * This method is used to return the value from the hashmap according to the key we enter 
	 * @return
	 */
	public static String get(String key) {
		return data.get(key);

	}
	
	/**
	 * This method is used to get a list of values from the properties file
	 * @param key
	 * @return
	 */
	public static String[] getList(String key, String delimitter) {
		String[] stringArray = data.get(key).split(delimitter);
		return stringArray;
	}

	/**
	 * @return
	 */
	private static HashMap<String, String> getValues() {
		data.putAll(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getAllParameters());
		data.putAll(getPropertiesFile());
		return data;
	}

	/**
	 * @return
	 */
	private static HashMap<String, String> getPropertiesFile() {
		try {
			Parameters params = new Parameters();
			
			FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
			    new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
			    .configure(params.properties()
			        .setFileName("application.properties").setBasePath(getPath()));
			
			FileBasedConfiguration config = builder.getConfiguration();
			Iterator<String> keys = config.getKeys();
			while(keys.hasNext()) {
				String key = keys.next();
				data.put(key, config.getString(key));
			}

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return data;

	}
	
	/**
	 * This method will return the path of the resources file
	 * @return
	 */
	private static String getPath() {
		String path = System.getProperty("user.dir");
		if(data.get("env.resources")!=null && !data.get("env.resources").isEmpty()) {
			path += "\\"+data.get("env.resources")+"\\";
		}
		else {
			path +="\\resources\\";
		}
		return path;
	}
	
}
