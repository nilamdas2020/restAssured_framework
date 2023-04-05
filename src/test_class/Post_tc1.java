package test_class;

import java.time.LocalDate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.CommonMethodUtilities;
import common_method.Common_method_api;
import io.restassured.path.json.JsonPath;

import request_repository.Post_Request_Repository;

public class Post_tc1 {
	@Test
	public static void orchestrator() throws IOException {
		// requirement parameter
		String responseBody = "";
		int responseStatuscode = 0;
		String baseuri = Post_Request_Repository.baseuri();
		String resource = Post_Request_Repository.resource();
		String requestBody = Post_Request_Repository.post_request_tc1();

		for (int i = 0; i < 5; i++) {

			responseStatuscode = Common_method_api.responsestatuscode_extractor(baseuri, resource, requestBody);
			if (responseStatuscode == 201) {
				responseBody = Common_method_api.responsebody_extractor(baseuri, resource, requestBody);
				responseBodyValidator(responseBody);
				break;

			} else {
				System.out.println("correct status code is not found in the iteration" + i);
			}
		}
		CommonMethodUtilities.evidenceFileCreator("Post_tc1", requestBody, responseBody);
		Assert.assertEquals(responseStatuscode, 201);

	}

	/*
	 * private static String resource() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * 
	 * 
	 * private static String baseuri() { // TODO Auto-generated method stub return
	 * null; }
	 */

	public static void responseBodyValidator(String responseBody) {
		// TODO Auto-generated method stub
		//create jsonpath object to extract responsebody parameter
		JsonPath jsp = new JsonPath(responseBody);

		//extract responsebody parameter
		String res_name = jsp.getString("name");
		String res_job = jsp.getString("job");
		String res_id = jsp.getString("id");
		String res_createdAt = jsp.getString("createdAt");

		/*System.out.println(
				"name :" + res_name + "\n job :" + res_job + "\n id :" + res_id + "\n createdAt :" + res_createdAt);*/
		
		//validate responsebody  parameter
		Assert.assertEquals(res_name, "Nilam");
		Assert.assertEquals(res_job, "QA");
		Assert.assertNotNull(res_id, "assertion error ,id parameter is null");

		String actual_date = res_createdAt.substring(0, 10);
		String current_date = LocalDate.now().toString();
		Assert.assertEquals(actual_date, current_date);
		//System.out.println("Actual Date :" + actual_date + "\n Current Date :" + current_date);

	}

}
