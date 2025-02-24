package api.test;



import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.LocalDate;

import org.apache.http.HttpRequest;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.response.Response;
import api.endpoints.UserEndPoints;
import api.payload.BookingDates;
import api.payload.BookingRequest;
import api.payload.BookingResponseGetRequest;
import api.payload.User;

 

public class UserTests
{
	
	User userPayload=new User();
	BookingDates dates=new BookingDates();
	
	//@BeforeClass
	public void SetUpData() 
	{
		userPayload.setfirstname("testFirstName");
		userPayload.setlastname("testlastname");
		userPayload.settotalprice(10.11);
		userPayload.setdepositepaid(true);
		dates.setCheckin("2022-01-01");
		dates.setCheckout("2024-01-01");
		userPayload.setbookingdates(dates);
		//userPayload.setadditionalneeds("testAdd");
		//userPayload.toString();
	}
	 String jsonRequest;
	// @BeforeClass
	public void setUp() {
		ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());  

        // Example of how to populate the POJO manually
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setFirstname("testFirstName");
        bookingRequest.setLastname("lastName");
        bookingRequest.setTotalprice(10.11);
        bookingRequest.setDepositpaid(true);

        // Set BookingDates object
        BookingRequest.BookingDates bookingDates = new BookingRequest.BookingDates();
        bookingDates.setCheckin(LocalDate.parse("2022-01-01"));
        bookingDates.setCheckout(LocalDate.parse("2024-01-01"));
        bookingRequest.setBookingdates(bookingDates);

        // Set additional needs
        bookingRequest.setAdditionalneeds("testAdd");

        // If you need to convert this POJO to JSON
        try {
            // Convert POJO to JSON
           jsonRequest = objectMapper.writeValueAsString(bookingRequest);
            System.out.println("JSON Request: " + jsonRequest);

            // Convert JSON back to POJO
            BookingRequest deserializedRequest = objectMapper.readValue(jsonRequest, BookingRequest.class);
            System.out.println("First Name: " + deserializedRequest.getFirstname());
            System.out.println("Check-in Date: " + deserializedRequest.getBookingdates().getCheckin());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
	}
	
	public void getdata() throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.registerModule(new JavaTimeModule()); 
		 
		 try 
		 {
			 BookingRequest  response = objectMapper.readValue(jsonRequest,  BookingRequest.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 BookingRequest response = objectMapper.readValue(jsonRequest, BookingRequest.class);
		 
		 System.out.println("Additional Properties: " + response.getAdditionalneeds());
		 
		 
	}
	@Test(priority=1)
	public void testPostUser()throws JsonMappingException, JsonProcessingException
	{
		setUp();
		Response response = UserEndPoints.createUser(jsonRequest);
		response.then().log().all().statusCode(200);
		Response getResponse = UserEndPoints.readUser(String.valueOf(response.jsonPath().getInt("bookingid")));
		System.out.println(getResponse.asPrettyString());
	}
	@Test(priority=2)
	public void testGetUser() throws JsonMappingException, JsonProcessingException
	{
		getdata();
		Response response = UserEndPoints.readUser(jsonRequest);
		Response getResponse = UserEndPoints.readUser(String.valueOf(response.jsonPath().getInt("bookingid")));
		response.then().log().all().statusCode(200);
		System.out.println(getResponse.asPrettyString());
	}

}
