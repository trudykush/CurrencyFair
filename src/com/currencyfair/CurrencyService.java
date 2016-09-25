package com.currencyfair;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.core.Request;

import com.currencyfair.CurrencyData;

import oracle.sql.DATE;

@Path("/CurrencyService")
public class CurrencyService {

	@POST
	@Path("/rawdata")
	@Produces(MediaType.APPLICATION_JSON)
	public String extractRawData(String message) throws JSONException, SQLException {
		//System.out.println(message);
		
		StringBuffer buffer = new StringBuffer();
		String messageString = message.toString();
		//JSONObject obj = new JSONObject(messageString);
		JSONArray jsonArray = new JSONArray(messageString);
		CurrencyData[] currData = new CurrencyData[jsonArray.length()];
		for(int i = 0; i<jsonArray.length();i++){
			JSONObject jsonObj = new JSONObject(jsonArray.get(i).toString());
			currData[i] = new CurrencyData();
			currData[i].setUserId(jsonObj.get("userId").toString());
			currData[i].setCurrencyFrom(jsonObj.get("currencyFrom").toString());
			currData[i].setCurrencyTo(jsonObj.get("currencyTo").toString());
			currData[i].setAmountBuy(Double.parseDouble(jsonObj.get("amountBuy").toString()));
			currData[i].setAmountSell(Double.parseDouble(jsonObj.get("amountSell").toString()));
			currData[i].setOriginatingCountry(jsonObj.get("originatingCountry").toString());
			currData[i].setRate(Double.parseDouble(jsonObj.get("rate").toString()));
			Date dt = new Date(jsonObj.get("timePlaced").toString());
			currData[i].setTimePlaced(dt);
			
			
		}
		CurrencyDAO currDAO = new CurrencyDAO();
		currDAO.insertData(currData);
		//System.out.println(jsonObj.get("userId"));
		
	      return message;
		
	}
	
	@GET
	@Path("/rawdata2")
	@Produces(MediaType.APPLICATION_XML)
	public CurrencyData extractRawData2() throws SQLException{
		return null;
	}
}
