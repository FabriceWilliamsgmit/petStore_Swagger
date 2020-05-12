package swaggerPetStore;

import java.util.ArrayList;
import java.util.List;

public class SwaggerResponse { 
	private long id;
	private String name; 
	private ArrayList<String> photoUrls; 
	private List<Tag> tags; 
	private String status;
	private Category category; 
	private long findbyId;
	private String findbyIdName;
	


public String getPetname () {
	return name;
}
public long getId () {
	return id;
}

public String getStatus () {
	return status;
}

public Category getCategory () {
	return category;
}

public List<Tag> getTags () {
	return tags;
}

public ArrayList<String> getPhotoUrls() {
	return photoUrls;
}

public long getfindbyId () {
	return findbyId;
}

public String getfindbyIdName () {
	return findbyIdName;
}
}