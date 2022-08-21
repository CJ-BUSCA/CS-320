import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	protected String contactID, firstNameTest, lastNameTest, numberTest, addressTest, longContactID, 
					 longFirstName, longLastName, longNumber, longAddress, shortNumber;
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
	void newContactTest() {
		ContactService service = new ContactService();	
		service.newContact();
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(0).getContactID()),	            
		        () -> assertEquals("DEFAULT", service.getContactList().get(0).getFirstName()),
		        ()-> assertEquals("DEFAULT", service.getContactList().get(0).getLastName()), 
		        ()-> assertEquals("0000000000",service.getContactList().get(0).getNumber()),                   
		        ()-> assertEquals("DEFAULT", service.getContactList().get(0).getAddress()));
		service.newContact(firstNameTest);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(1).getContactID()),	            
		        () -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
		        ()-> assertEquals("DEFAULT", service.getContactList().get(1).getLastName()), 
		        ()-> assertEquals("0000000000",service.getContactList().get(1).getNumber()),                   
		        ()-> assertEquals("DEFAULT", service.getContactList().get(1).getAddress()));
		service.newContact(firstNameTest, lastNameTest);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(2).getContactID()),	            
		        () -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
		        ()-> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()), 
		        ()-> assertEquals("0000000000",service.getContactList().get(2).getNumber()),                   
		        ()-> assertEquals("DEFAULT", service.getContactList().get(2).getAddress()));
		service.newContact(firstNameTest, lastNameTest, numberTest);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(3).getContactID()),	            
		        () -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
		        ()-> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()), 
		        ()-> assertEquals(numberTest,service.getContactList().get(3).getNumber()),                   
		        ()-> assertEquals("DEFAULT", service.getContactList().get(3).getAddress()));
		service.newContact(firstNameTest, lastNameTest, numberTest, addressTest);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(4).getContactID()),	            
		        () -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
		        ()-> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()), 
		        ()-> assertEquals(numberTest,service.getContactList().get(4).getNumber()),                   
		        ()-> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
	}
	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertThrows(Exception.class, ()->service.deleteContact(contactID));
		assertAll(()->service.deleteContact(service.getContactList().get(0).getContactID()));
	}
	@Test
	  void updatefirstNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setFirstName(service.getContactList().get(0).getContactID(),
	                            firstNameTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setFirstName(
	                         service.getContactList().get(0).getContactID(),
	                         longFirstName));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setFirstName(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setFirstName(contactID, firstNameTest));
	 }
	 @Test
	  void updatelastNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setLastName(service.getContactList().get(0).getContactID(),
	                           lastNameTest);
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setLastName(
	                         service.getContactList().get(0).getContactID(),
	                         longLastName));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setLastName(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setLastName(contactID, lastNameTest));
	  }
	  @Test
	  void updatePhoneNumberTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setNumber(service.getContactList().get(0).getContactID(), numberTest);
	                              
	    assertEquals(numberTest,
	                 service.getContactList().get(0).getNumber());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setNumber(
	                         service.getContactList().get(0).getContactID(),
	                         longNumber));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setNumber(
	                         service.getContactList().get(0).getContactID(),
	                         shortNumber));
	    assertThrows(
	        IllegalArgumentException.class,
	        ()
	            -> service.setNumber(
	                service.getContactList().get(0).getContactID(), "5493044"));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setNumber(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setNumber(contactID, lastNameTest));
	  }
	  @Test
	  void updateAddressTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setAddress(service.getContactList().get(0).getContactID(),
	                          addressTest);
	    assertEquals(addressTest, service.getContactList().get(0).getAddress());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setAddress(
	                         service.getContactList().get(0).getContactID(),
	                         longAddress));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setAddress(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setAddress(contactID, addressTest));
	  }

}