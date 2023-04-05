package common_method;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Common_method_api {
	public static int responsestatuscode_extractor(String baseuri ,String resource , String req_body)
	{
		RestAssured.baseURI = baseuri;
		int response_statuscode = given().headers("Content-Type","application/json").body(req_body)
				.when().post(resource).then().extract().statusCode();
		return response_statuscode;
	}
	public static String responsebody_extractor(String baseuri ,String resource , String req_body)
	{
		RestAssured.baseURI = baseuri;
		String responsebody = given().headers("Content-Type","application/json").body(req_body)
				.when().post(resource).then().extract().response().asString();
		return responsebody;
	}


}
