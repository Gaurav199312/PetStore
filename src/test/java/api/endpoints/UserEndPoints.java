package api.endpoints;

import org.testng.annotations.Test;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class UserEndPoints {
	
	
	//Create User -- POST method
	
	public static Response createUser(User payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return res;
	}
	
	
	//GET user -- GET method
	
	public static Response readUser(String username)
	{
		Response res=given()
				.pathParam("username", username)
	
		.when()
			.get(Routes.get_url);
		
		return res;
	}
	
	// Update user -- PUT method
	
	public static Response updateUser(String username, User payload)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", username)
	
		.when()
			.put(Routes.put_url);
		
		return res;
		
	
	}
	
	//Delete user -- DELETE
	public static Response deleteUser(String username)
	{
		Response res=given()
				.pathParam("username", username)
	
		.when()
			.delete(Routes.delete_url);
		
		return res;
	}
	
	
	
	

}
