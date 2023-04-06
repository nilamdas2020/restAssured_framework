package common_method;

import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;

public class Common_method_get_api {
	
		
	public static int responsestatuscode_extractor(String baseuri, String resource) {
		// TODO Auto-generated method stub
		RestAssured.baseURI=baseuri;
		int response_statuscode=given().header("Content-Type","application/json").when().get(resource).then().extract().statusCode();
		return response_statuscode;
	}
	public static String responseBody_extractor(String baseuri, String resource) {
		// TODO Auto-generated method stub
		RestAssured.baseURI=baseuri;
		String response_Body=given().header("Content-Type","application/json").when().get(resource).then().extract().response().asString();
		return response_Body;
	}

		
	

}
