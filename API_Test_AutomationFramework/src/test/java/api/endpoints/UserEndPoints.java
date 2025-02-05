package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.*;

/*UserEndPoints.java
 * created to perform CRUD Operations
 */

public class UserEndPoints {
	
		public static Response createUser(String payload)
		{
			System.out.println("Post Url"+ Routes.post_url);
			System.out.println("payload"+ payload);
String body = "{\r\n"
		+ "    \"firstname\": \"testFirstName\",\r\n"
		+ "    \"lastname\": \"lastName\",\r\n"
		+ "    \"totalprice\": 10.11,\r\n"
		+ "    \"depositpaid\": true,\r\n"
		+ "    \"bookingdates\": {\r\n"
		+ "        \"checkin\": \"2022-01-01\",\r\n"
		+ "        \"checkout\": \"2024-01-01\"\r\n"
		+ "    },\r\n"
		+ "    \"additionalneeds\": \"testAdd\"\r\n"
		+ "}";
			Response response=given()
				  .contentType("application/json")
				  //.accept(ContentType.JSON)
				  .body(payload)
			.when()
			.post(Routes.post_url);
			return response;
				
		}
		public static Response readUser(String bookingid)
		{
			Response response=given()
					.pathParam("bookingid", bookingid)
				  
			.when()
			.get(Routes.get_url);
			return response;
		}
				

}
