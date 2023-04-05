package common_method;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class CommonMethodUtilities {
	public static void evidenceFileCreator(String FileName , String request ,String response) throws IOException
	{
		File newTextFile = new File("D:\\restAssuredEvidence\\" + FileName + ".txt");
		if(newTextFile.createNewFile())
		{
			
			
		FileWriter datawriter = new FileWriter(newTextFile);
		datawriter.write("requestBody is :\n" + request +"\n" );
		datawriter.write("responseBody is :\n" + response + "\n");
		datawriter.close();
		System.out.println("request and response body data saved is :" +newTextFile.getName());
		}
		else
		{
			System.out.println(newTextFile.getName() + "Already exist please take a back of it :");
		}
		
	}

	/*public static void evidenceFileCreator(String fileName, String requestBody, int responseBody) throws IOException {
		
		// TODO Auto-generated method stub
		File newTextFile = new File("E:\\putrestrepository\\" + fileName + ".txt");
		if(newTextFile.createNewFile())
		{
		
		FileWriter datawriter = new FileWriter(newTextFile);
		datawriter.write("requestBody is :\n" + requestBody +"\n" );
		datawriter.write("responseBody is :\n" + responseBody + "\n");
		datawriter.close();
		System.out.println("request and response body data saved is :" +newTextFile.getName());
		}
		else
		{
			System.out.println(newTextFile.getName() + "Already exist please take a back of it :");
		}
		
		
	}*/
	
}
