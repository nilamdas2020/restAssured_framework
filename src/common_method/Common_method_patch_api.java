package common_method;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Common_method_patch_api {
	public static int responsestatuscode_extractor(String baseuri, String requestBody,String resource)
	{
		RestAssured.baseURI=baseuri;
		int response_statuscode=given().header("Content-Type","application/json").body(requestBody).when().put(resource).then().extract().statusCode();
		
		return response_statuscode;
	}
	public static String responseBody_extractor(String baseuri, String resource, String requestBody) {
		// TODO Auto-generated method stub
		RestAssured.baseURI=baseuri;
		String response_Body=given().header("Content-Type","application/json").body(requestBody).when().put(resource).then().extract().response().asString();
		return response_Body;
		
	}

}
