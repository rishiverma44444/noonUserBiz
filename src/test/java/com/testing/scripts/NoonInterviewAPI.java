package com.testing.scripts;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testing.Commons.APIUtils;
import com.testing.Commons.BaseAPI;
import com.testing.Commons.GlobalConstants;
import io.restassured.response.Response;

public class NoonInterviewAPI extends BaseAPI {
	
	static String Token;
	String InValidToken = "NPONSUJA189CZUN";
	
	@Test(priority = 1, description = "Postive : Create token with valid username and password")
	public void createToken() throws JSONException, IOException{
		String requestBody = APIUtils.jsonFileConversion(GlobalConstants.VALID_REQUEST_JSON).toString();
		Response response = postRequest(GlobalConstants.USER_VALIDATION, requestBody);
		System.out.println("Response : \n"+response.prettyPrint());
		Token = APIUtils.getParameterFromResponse(response, "data.token");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(APIUtils.getParameterFromResponse(response, "success"),"true");
		Assert.assertNotNull(Token);
	}
	
	@Test(priority = 2, description = "Negative : Create token with In-Valid username and Valid password")
	public void createTokenInvalidUser() throws JSONException, IOException{
		String requestBody = APIUtils.jsonFileConversion(GlobalConstants.INVALID_USER_JSON).toString();
		Response response = postRequest(GlobalConstants.USER_VALIDATION, requestBody);
		System.out.println("Response : \n"+response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(APIUtils.getParameterFromResponse(response, "success"), "false");
		Assert.assertEquals(APIUtils.getParameterFromResponse(response, "errorMessage"), "Invalid Credentials.");
	}
	
	@Test(priority = 3, description = "Negative : Create token with Valid password and In-Valid password")
	public void createTokenInvalidPassword() throws JSONException, IOException{
		String requestBody = APIUtils.jsonFileConversion(GlobalConstants.INVALID_PASSWORD_JSON).toString();
		Response response = postRequest(GlobalConstants.USER_VALIDATION, requestBody);
		System.out.println("Response : \n"+response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(APIUtils.getParameterFromResponse(response, "success"), "false");
		Assert.assertEquals(APIUtils.getParameterFromResponse(response, "errorMessage"), "Invalid Credentials.");
	}
	
	@Test(priority = 4 , description = "Positive : Get user history with valid token")
	public void getHistoryValidToken(){
		Response response = getRequest(GlobalConstants.USER_HISTORY, APIUtils.param("token", Token));
		System.out.println("Response : \n"+response.getBody().prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(APIUtils.getParameterFromResponse(response, "success"),"true");
		Assert.assertNotNull(APIUtils.getParameterFromResponse(response, "data"));
		
	}
	
	@Test(priority = 5 , description = "Negative : Get user history with In-valid token")
	public void getHistoryInvalidToken(){
		Response response = getRequest(GlobalConstants.USER_HISTORY, APIUtils.param("token", InValidToken));
		System.out.println("Response : \n"+response.getBody().prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(APIUtils.getParameterFromResponse(response, "success"), "false");
		Assert.assertEquals(APIUtils.getParameterFromResponse(response, "errorMessage"), "Invalid Token.");
		
	}
	
}
