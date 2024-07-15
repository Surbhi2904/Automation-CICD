package rahulsshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.lang.Object;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	//write n number of utility to read json data
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//reading json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\rahulsshettyacademy\\data\\PurchaseOrder.json"), 
				StandardCharsets.UTF_8);
	   
		
		
		//convert string to hashmap we will use jackson databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String , String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String , String>>>(){
	    
			
			
		});
	        return data;
	}

}
