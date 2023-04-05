package request_repository;

import java.io.IOException;

import java.util.ArrayList;

import common_method.getData;

public class Post_Request_Repository {
	public static String baseuri()
	{
		String baseuri ="https://reqres.in/";
		return baseuri;
	}
	public static String resource()
	{
		String resource="api/users";
		return resource;
	}

	public static String post_request_tc1() throws IOException
	{
		ArrayList<String> data=getData.getDataExcel("post_data", "tc1");
		String Name=data.get(2);
		String Job=data.get(3);
		
		String requestBody = "{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		return requestBody;
		
	}
	/*public static String post_request_tc2() throws IOException
	{
		ArrayList<String> data=getData.getDataExcel("post_data", "tc2");
		String Name=data.get(2);
		String Job=data.get(3);
		
		
		String requestBody = "{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		return requestBody;
		
	}
	public static String post_request_tc3() throws IOException
	{
		ArrayList<String> data=getData.getDataExcel("post_data", "tc3");
		String Name=data.get(2);
		String Job=data.get(3);
		
		
		String requestBody = "{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		return requestBody;
		
	}
	public static String post_request_tc4() throws IOException
	{
		ArrayList<String> data=getData.getDataExcel("post_data", "tc4");
		String Name=data.get(2);
		String Job=data.get(3);
		
		
		String requestBody = "{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		return requestBody;
		
	}*/
}
