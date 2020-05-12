package swaggerPetStore.swaggerPetStoreTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import swaggerPetStore.PetStoreApp;

class UpdatePetTest {

	@BeforeEach
	void setUp() throws Exception {
		@SuppressWarnings("unused")
		PetStoreApp petStoreApp=new PetStoreApp();
		PetStoreApp.createPet();
		PetStoreApp.convertToJson();
		PetStoreApp.sendPostRequest();
		PetStoreApp.updatePet();
	}

	@AfterEach
	void tearDown() throws Exception {
		PetStoreApp.deletePet();
	}

	@Test
	void testUpdatePet() {
		String result="Elizio";
		assertEquals(PetStoreApp.myPetName, result);
	}

}
