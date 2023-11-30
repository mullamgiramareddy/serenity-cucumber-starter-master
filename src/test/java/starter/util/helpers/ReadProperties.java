package starter.util.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static String getProperty(String property) throws IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(getCurrentWorkingDir()+"\\src\\test\\resources\\test.properties"));
		return prop.getProperty(property).toString();
	}
	
	public static String getCurrentWorkingDir() {
	    return System.getProperty("user.dir");
	}
}
