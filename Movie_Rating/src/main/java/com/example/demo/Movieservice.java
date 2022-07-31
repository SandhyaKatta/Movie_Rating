package com.example.demo;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;


@Service
public class Movieservice {
	     
	
	     public List<String> movierating() {
	     List<String> movieDetails = new ArrayList<String>();
	    	 
	     HttpURLConnection connection = null;
	     final String myKey = "k_x47rkpaa";
		  {
	    try
	    {
	   URL url = new URL(
	   		 "https://imdb-api.com/en/API/Ratings/"+myKey+"/tt1375666");
	   connection = (HttpURLConnection)url.openConnection();
	   connection.setRequestMethod("GET");
	   connection.setDoInput(true);
	   
	   InputStream stream = connection.getInputStream();
	   BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
	   StringBuilder responce = new StringBuilder();
	   String line=null;
	   while((line=reader.readLine())!=null)
	   {
	    responce.append(line);
	    responce.append("\r");
	   }
	   reader.close();
	   String result = responce.toString();
	   System.out.print(result);
	   
	   JSONObject object = new JSONObject(result);
	   
	   String id = object.getString("imDbId");
	   String title = object.getString("title");
	   String realeseYear = object.getString("year");
	   String ratings = object.getString("imDb");
	   movieDetails.add(id);
	   movieDetails.add(title);
	   movieDetails.add(realeseYear);
	   movieDetails.add(ratings);

	   System.out.println("Movie id "+id);
	   System.out.println("Movie title "+title);
	   System.out.println("Movie year "+realeseYear);
	   System.out.println("Movie Ratings "+ratings);
	   
		   
	   
	  }
	  
	  catch (Exception e) {
	   e.printStackTrace();
	  }
	 }
		return movieDetails;
	 
	}
	     

}




