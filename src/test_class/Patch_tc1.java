package test_class;

import java.io.IOException;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.CommonMethodUtilities;
import common_method.Common_method_patch_api;
import io.restassured.path.json.JsonPath;
import request_repository.Patch_Request_Repository;


public class Patch_tc1 {
	@Test
	public static void orchestrator() throws IOException
	{
	
		String responseBody="";
		int responseStatuscode =0;
		String baseuri=Patch_Request_Repository.baseuri();
		String resource= Patch_Request_Repository.resource();
		String requestBody=Patch_Request_Repository.patch_request_tc1();
		for(int i =0;i<5;i++)
		{
			 responseStatuscode =Common_method_patch_api.responsestatuscode_extractor(baseuri, requestBody, resource);
			 if (responseStatuscode == 200)
				{
				 responseBody=Common_method_patch_api.responseBody_extractor(baseuri, resource, requestBody);
					responseBodyValidator(responseBody);
					break;
					
				}
				else
				{
					System.out.println("correct status code is not found in the iteration" + i);
				}
		}
			CommonMethodUtilities.evidenceFileCreator("Patch_tc1",requestBody,responseBody);
			Assert.assertEquals(responseStatuscode, 200);
			 
	}

	private static void responseBodyValidator(String responseBody) {
		// TODO Auto-generated method stub
		JsonPath jsp = new JsonPath(responseBody);
		
		String res_name = jsp.getString("name");
		String res_job = jsp.getString("job");
		String res_updatedAt=jsp.getString("updatedAt");
		
		//System.out.println("name :" +res_name+"\n job :"+res_job+"\n id :" +res_id+"\n updatedAt :" +res_updatedAt );
		 Assert.assertEquals(res_name, "morpheus");
		 Assert.assertEquals(res_job, "zion resident");
		// Assert.assertNotNull(res_id,"assertion error ,id parameter is null");
		 
		 
		  String actual_date=res_updatedAt.substring(0,10);
		 String current_date=LocalDate.now().toString();
		 Assert.assertEquals(actual_date, current_date);
		 //System.out.println("Actual Date :" +actual_date+"\n Current Date :" +current_date);
		
	}
		

}
