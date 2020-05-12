package swaggerPetStore.swaggerPetStoreTests;


import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swaggerPetStore.PetStoreApp;

class deletePetTest {

	@BeforeEach
	void setUp() throws Exception {
		@SuppressWarnings("unused")
		PetStoreApp petStoreApp=new PetStoreApp();
		PetStoreApp.createPet();
		PetStoreApp.convertToJson();
		PetStoreApp.sendPostRequest();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDeletePet() throws IOException {
		
		PetStoreApp.findPetById();
		PetStoreApp.deletePet();
		PetStoreApp.deletePet();
		//need to implement test to cover 404 error return in response using JSONASSERT library
		long result=PetStoreApp.myPetId;
		assertNotSame(PetStoreApp.myPetId, result);
		
	}

}
