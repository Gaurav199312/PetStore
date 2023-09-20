package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker f1;
	User payload;
	
	public Logger logger; // for logs
	
	
	@BeforeClass
	void setupData()
	{
		f1=new Faker();
		payload=new User();
		
		payload.setId(f1.idNumber().hashCode());
		payload.setUsername(f1.name().username());
		payload.setFirstname(f1.name().firstName());
		payload.setLastname(f1.name().lastName());
		payload.setPassword(f1.internet().password());
		payload.setEmail(f1.internet().emailAddress());
		payload.setPhone(f1.phoneNumber().cellPhone());
		
		//logs
		logger= LogManager.getLogger(this.getClass());
				
		logger.debug("debugging.....");
				
	}
	
	@Test(priority=1)
	public void testPostUser() 
	{
		logger.info("********** Creating user  ***************");
		Response response=UserEndPoints.createUser(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**********User is created  ***************");
	}
	
	@Test(priority=2)
	public void testGETUserByName() 
	{
		logger.info("********** Reading User Info ***************");
		Response response=UserEndPoints.readUser(this.payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**********User info  is displayed ***************");
		
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() 
	{
		logger.info("********** Updating User ***************");
		
		//update data:
		payload.setUsername(f1.name().username());
		payload.setLastname(f1.name().lastName());
		payload.setEmail(f1.internet().safeEmailAddress());
		
		
		Response response=UserEndPoints.updateUser(this.payload.getUsername(), payload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		
		//Checking data after updation -- Copy and paste the get request code
		Response responseAfterUpdate=UserEndPoints.readUser(this.payload.getUsername());
		responseAfterUpdate.then().log().body();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
			
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() 
	{
		Response response=UserEndPoints.deleteUser(this.payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	

}
