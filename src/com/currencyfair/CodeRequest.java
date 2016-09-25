package com.currencyfair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class CodeRequest {

	public static void main(String[] args){

		//"http://localhost:8080/Code_Challenge/rest/CurrencyService/rawdata"
		try {
			HttpClient httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost("http://localhost:8080/Code_Challenge/rest/CurrencyService/rawdata");

			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new FileReader("Input.txt"));

			String line;
			while ((line = br.readLine()) != null)
				sb.append(line);

			String input = sb.toString();

			StringEntity params =new StringEntity(input);

			httppost.setEntity(params);
			httppost.addHeader("Content-Type", "application/json");
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				InputStream instream = entity.getContent();
				try {
					System.out.println("Hello");
				} finally {
					instream.close();
				}
			}
			br.close();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}finally{
			System.out.println("Hello");
		}
	}        
}
