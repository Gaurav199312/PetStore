package api.endpoints;


/*
 * Base URL: petstore.swagger.io/v2
 * 
 * Post: create user: https://petstore.swagger.io/v2/user
 * Get : Get user: https://petstore.swagger.io/v2/user/{username}
 * Put : Update User : https://petstore.swagger.io/v2/user/{username}
 * Delete : Delete user: https://petstore.swagger.io/v2/user/{username}
 * 
 */
public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module:
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	
	//Store module
	
	
	//Pet module

}
