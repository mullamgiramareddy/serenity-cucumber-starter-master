package starter.util.helpers;


import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import net.thucydides.model.environment.SystemEnvironmentVariables;


public class ReadTestData {

	public static JSONObject getTestData(String jsonFileName ) throws Exception {
		String env = SystemEnvironmentVariables.currentEnvironmentVariables().getProperty("Env");
		 Object obj  = new JSONParser().parse(new FileReader(getCurrentWorkingDir()+"\\src\\test\\resources\\test-data\\"+env+"\\"+jsonFileName+".json"));
 	    JSONObject jo=(JSONObject)obj;
 	    return jo;
	}

	public static String getCurrentWorkingDir() {
	    return System.getProperty("user.dir");
	}

}