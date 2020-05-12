package swaggerPetStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import swaggerPetStore.Pet;
import swaggerPetStore.Category;
import swaggerPetStore.Tag;

public class PetStoreApp {

	public static String myPetName;
	public static  long myPetId;
	public static Map<Object, Object> petMap1;
	public static String jsonInString1;
	
public static Map<Object, Object> createPet() {
			
	//Here we create the Pet object which will be then converted to JSON later
	//we add new instances of Pet, Category and PetList classes
	Pet pet=new Pet();
	Category category= new Category ();
	PetList petlist=new PetList();
	Tag tag= new Tag();
		
			//Pet values
	pet.setName("Sammy");
	pet.setCategory(category);
	pet.setStatus("pending");
	pet.setId(123456);
			
			//values of new pet
	petlist.setName("Maximilian");
	petlist.setId(3333);
	petlist.setStatus("pending");
	petlist.withStatus("pending");
	petlist.setCategory(category);
			
	 List<String> photourlz = new ArrayList<String>();
	 photourlz.add(new String("http://www.gettyimages.com"));
	 photourlz.add(new String("http://www.imgur.com"));
			
	petlist.setPhotoUrls(photourlz);
		
			//tag to register pets under
	tag.setId(555);
	tag.setName("DoggieIsMyDog");
			
			//category to register pet under
	category.setId(444);
	category.setName("Dogz");
	category.withName("Dogs");
		
			//retrieve data
	String petName= pet.getName();
	String petStatus=pet.getStatus();
	int petId=(int)pet.getId();
	Category categoryPet=pet.getCategory();
	String petTag=tag.toString();
	List<String> petPhotourl=petlist.getPhotoUrls();

			//create a map of objects to then turn into a json string
						
	Map<Object, Object> petMap = new HashMap<>();
	petMap.put("Id",petId);
	petMap.put("Category", categoryPet);
	petMap.put("PhotoUrl", petPhotourl);
	petMap.put("name", petName);
	petMap.put ("Tag", petTag);
	petMap.put("Status", petStatus);
	petMap1=petMap;
		return petMap;
}

			//Here we convert the String petList into a JSON format
public static String convertToJson() {
				//createPet();
	Gson gson = new Gson();
	String jsonInString = gson.toJson(petMap1);
	jsonInString1=jsonInString;
		return jsonInString1;
			}
			
			//Here we create the Post request to create a new Pet
public static long sendPostRequest () {
	//String testString=jsonInString1;
	//System.out.println(testString);
	OkHttpClient client = new OkHttpClient().newBuilder()
			.build();
	MediaType mediaType = MediaType.parse("application/json");
	RequestBody body = RequestBody.create(mediaType,jsonInString1);
			
	Request request = new Request.Builder()
			  .url("https://petstore.swagger.io/v2/pet")
			  .method("POST", body)
			  .addHeader("Content-Type", "application/json")
			  .build();
			try {
				@SuppressWarnings("unused")
				Response response = client.newCall(request).execute();
				String jsonresponse=response.body().string();
				Gson gson = new Gson();
				SwaggerResponse swaggerresponse= gson.fromJson(jsonresponse, SwaggerResponse.class);
				System.out.println(swaggerresponse);
				//now we put response values in separate types so that they return in the console as variables
				long responseId=swaggerresponse.getId();
				String responsePetname=swaggerresponse.getPetname();
				String responsePetStatus=swaggerresponse.getStatus();
				Category responseCategory=swaggerresponse.getCategory();
				List<Tag> responseTag=swaggerresponse.getTags();
				ArrayList<String> responsePhotoUrls=swaggerresponse.getPhotoUrls();
				System.out.println(responseId+"\n"+responsePetname+"\n"+responsePetStatus+ "\n"+responseCategory+"\n"+responseTag+"\n"+responsePhotoUrls);
				myPetId=responseId;	
				myPetName=responsePetname;
			} catch (IOException e) {
				e.printStackTrace();
			}

				return myPetId;
			}

			
public static void findPetById (){
	System.out.println(myPetId);
	OkHttpClient client = new OkHttpClient().newBuilder()
			  .build();
			Request request = new Request.Builder()
			  .url("https://petstore.swagger.io/v2/pet/"+myPetId)
			  .method("GET", null)
			  .build();
			try {
				@SuppressWarnings("unused")
				Response response = client.newCall(request).execute();
				String findIdjsonresponse=response.body().string();
				Gson gson = new Gson();
				SwaggerResponse swaggerresponse= gson.fromJson(findIdjsonresponse, SwaggerResponse.class);
				long findresponseId=swaggerresponse.getfindbyId();
				String findByName=swaggerresponse.getfindbyIdName();
				System.out.println(findresponseId+findByName);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
}

public static void updatePet() throws IOException {
	
	OkHttpClient client = new OkHttpClient().newBuilder()
			  .build();
			@SuppressWarnings("unused")
			MediaType mediaType = MediaType.parse("text/plain");
			RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
			  .addFormDataPart("name", "Elizio")
			  .addFormDataPart("status", "Pending")
			  .build();
			Request request = new Request.Builder()
			  .url("https://petstore.swagger.io/v2/pet/"+myPetId)
			  .method("POST", body)
			  .build();
			Response response = client.newCall(request).execute();
			String updateResponse=response.body().toString();
			/*
			String jsonresponse=response.body().toString();
			Gson gson = new Gson();
			SwaggerResponse swaggerresponse= gson.fromJson(jsonresponse, SwaggerResponse.class);
			System.out.println(swaggerresponse);
			long responseId=swaggerresponse.getId();
			String responsePetname=swaggerresponse.getPetname();
			String responsePetStatus=swaggerresponse.getStatus();
			System.out.println(responseId+"\n"+responsePetname+"\n"+responsePetStatus);
*/
}

public static void deletePet () throws IOException {
	
	OkHttpClient client = new OkHttpClient().newBuilder()
			  .build();
			MediaType mediaType = MediaType.parse("text/plain");
			RequestBody body = RequestBody.create(mediaType, "");
			Request request = new Request.Builder()
			  .url("https://petstore.swagger.io/v2/pet/"+myPetId)
			  .method("DELETE", body)
			  .build();
			Response response = client.newCall(request).execute();
			String deleteresponse=response.body().string();
			System.out.println(deleteresponse);
}

		public static void main(String[] args) throws IOException {
		createPet();
		convertToJson();
		sendPostRequest();
		findPetById ();
		updatePet();
		deletePet ();
		findPetById ();
		deletePet ();
	}
	}
