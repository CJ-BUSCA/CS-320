import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactTest  {

	protected String contactID, firstNameTest, lastNameTest, numberTest, addressTest;
	protected String longContactID, longFirstName, longLastName, longNumber, longAddress, shortNumber;
	
	@BeforeEach
	void setUp() {
		contactID = "0000000000";
		firstNameTest = "DEFAULT";
		lastNameTest = "DEFAULT";
		numberTest = "0000000000";
		addressTest = "DEFAULT";
		longContactID = "10101010101";
		longFirstName = "NastyMichaelangelo";
		longLastName = "FilthyLeonardo";
		longNumber = "110111010111011";
		longAddress = "2468 Long Long Name Road, City 17, Jefferson Air Force Base, North Carolina";
		shortNumber = "1";		
	}
	
	@Test
	void contactConstructorTest() {
		Contact contact = new Contact();
		assertAll("No Arguments Contstructor",
			()-> assertNotNull(contact.getContactID()),
            ()-> assertNotNull(contact.getFirstName()),
            ()-> assertNotNull(contact.getLastName()),              
            ()-> assertNotNull(contact.getNumber()),
            ()-> assertNotNull(contact.getAddress()));   				
	}
	
	@Test
	void contactIDConstructorTest() {
		Contact contact = new Contact(contactID);
		assertAll("Contact ID Constructor Test",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertNotNull(contact.getFirstName()),
	            ()-> assertNotNull(contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	@Test 
	void firstNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest);
		assertAll("firstNameConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(firstNameTest, contact.getFirstName()),
	            ()-> assertNotNull(contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	@Test
	void lastNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest, lastNameTest);
		assertAll("lastNameConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(firstNameTest, contact.getFirstName()),
	            ()-> assertEquals(lastNameTest, contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	@Test
	void numberConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest, lastNameTest, numberTest);
		assertAll("numberConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(firstNameTest, contact.getFirstName()),
	            ()-> assertEquals(lastNameTest, contact.getLastName()),              
	            ()-> assertEquals(numberTest, contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void addressConstructorTest() {
		Contact contact = new Contact(contactID,firstNameTest, lastNameTest, numberTest, addressTest  );
		assertAll("addressConstructorTest", 
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(firstNameTest, contact.getFirstName()),
	            ()-> assertEquals(lastNameTest, contact.getLastName()),              
	            ()-> assertEquals(numberTest, contact.getNumber()),
	            ()-> assertEquals(addressTest, contact.getAddress()));
	}
	
	@Test
	void setFirstNameTest() {
		Contact contact = new Contact();
		contact.setFirstName(firstNameTest);
		assertAll("firstNameTest",
			()-> assertEquals(firstNameTest, contact.getFirstName()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setFirstName(null)),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setFirstName(longFirstName)));				
	}
	
	@Test 
	void setLastNameTest() {
		Contact contact = new Contact();
		contact.setLastName(firstNameTest);
		assertAll("lastNameTest",
			()-> assertEquals(lastNameTest, contact.getFirstName()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setLastName(null)),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setLastName(longLastName)));
	}
	
	@Test
	void setNumberTest() {
		Contact contact = new Contact();
		contact.setNumber(numberTest);
		assertAll("numberTest",
			()-> assertEquals(numberTest, contact.getNumber()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber("")),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(longNumber)),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(shortNumber)),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(contactID)));
	}
	
	@Test
	void setAddressTest() {
		Contact contact = new Contact();
		contact.setAddress(addressTest);
		assertAll("addressTestest",
				()-> assertEquals(addressTest, contact.getAddress()),
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setAddress(null)),    
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setAddress(longAddress)));
	}
	
	@Test
	void setContactIDTest() {
		Contact contact = new Contact();
		contact.setContactID(contactID);
		assertAll("contactIDTest",
				()-> assertEquals(contactID, contact.getContactID()),
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setContactID(null)),    
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setContactID(longContactID)));
	}
}