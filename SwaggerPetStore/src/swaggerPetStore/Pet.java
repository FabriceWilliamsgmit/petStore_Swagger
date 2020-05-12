package swaggerPetStore;

import java.util.ArrayList;

public class Pet {
	
		 private float id;
		 Category CategoryObject;
		 private String name;
		 ArrayList < Object > photoUrls = new ArrayList < Object > ();
		 ArrayList < Object > tags = new ArrayList < Object > ();
		 private String status;


		 // Getter Methods 

		 public float getId() {
		  return id;
		 }

		 public Category getCategory() {
		  return CategoryObject;
		 }

		 public String getName() {
		  return name;
		 }

		 public String getStatus() {
		  return status;
		 }

		 // Setter Methods 

		 public void setId(float id) {
		  this.id = id;
		 }

		 public void setCategory(Category categoryObject) {
		  this.CategoryObject = categoryObject;
		 }

		 public void setName(String name) {
		  this.name = name;
		 }

		 public void setStatus(String status) {
		  this.status = status;
		 }
		}

