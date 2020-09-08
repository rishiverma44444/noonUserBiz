package com.testing.Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIUtils {

	/** This method will value from JSON Object
	 * 
	 * @param response  Input<Response>
	 * @param key Field<String>
	 * @return Value<String> w.r.t Key
	 */
	public static String getParameterFromResponse(Response response, String key) {

		JsonPath jsonPathEvaluator = response.jsonPath();
		String value = jsonPathEvaluator.get(key).toString();
		return value;
	}

	/** This method will convert into file into JSON Object
	 * 
	 * @param filePath File path<String>
	 * @return File into JSONObject
	 * @throws JSONException
	 * @throws IOException
	 */
	public static JSONObject jsonFileConversion(String filePath) throws JSONException, IOException {
		FileInputStream file = new FileInputStream(filePath);
		return new JSONObject(IOUtils.toString(file, "UTF-8"));
	}

	/** This method will fetch values from property file.
	 * 
	 * @param Key the key<String> against which value need to get fetched
	 * @return value<String> against Key
	 */
	public static String getValue(String Key) {
		File file = new File(GlobalConstants.CONFIG);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(Key);
	}
	
	/** This method will return map 
	 * 
	 * @param key  Parameter Key<String>
	 * @param value Parameter Value<String>
	 * @return Key,Value Map
	 */
	public static Map<String, String> param(String key, String value){
		Map<String, String> map = new HashMap<String, String>();
		map.put(key, value);
		return map;
	}
}