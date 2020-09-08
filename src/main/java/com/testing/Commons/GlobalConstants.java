package com.testing.Commons;

public class GlobalConstants {

	public static final String TEST_RESOURCES = System.getProperty("user.dir")+ "\\src\\main\\java\\com\\testing\\Resources";
	public static final String CONFIG = TEST_RESOURCES + "\\Config.properties";
	public static final String API_URI = APIUtils.getValue("API_HOST");
	public static final String USER_VALIDATION = API_URI+"validate";
	public static final String USER_HISTORY = API_URI+"txn/history";
	public static final String JSON_PATH = TEST_RESOURCES + "\\JsonsMocks";
	public static final String VALID_REQUEST_JSON = JSON_PATH + "\\userDetails.json";
	public static final String INVALID_USER_JSON = JSON_PATH + "\\invaliduserDetails.json";
	public static final String INVALID_PASSWORD_JSON = JSON_PATH + "\\invalidPasswordDetails.json";

}