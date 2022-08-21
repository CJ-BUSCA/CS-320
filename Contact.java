class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	private static final String INITIALIZER = "DEFAULT";
	private static final String INITIALIZER_INT = "0000000000";
	
	Contact(){
		this.contactID = INITIALIZER_INT;
		this.firstName = INITIALIZER;
		this.lastName = INITIALIZER;
		this.number = INITIALIZER_INT;
		this.address = INITIALIZER;
	}
	
	
	Contact(String contactID){
		setContactID(contactID);
		this.firstName = INITIALIZER;
		this.lastName = INITIALIZER;
		this.number = INITIALIZER_INT;
		this.address = INITIALIZER;
	}
	
	Contact(String contactID, String firstName){
		setContactID(contactID);
		setFirstName(firstName);
		this.lastName = INITIALIZER;
		this.number = INITIALIZER_INT;
		this.address = INITIALIZER;
	}
	
	Contact(String contactID, String firstName, String lastName){
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		this.number = INITIALIZER_INT;
		this.address = INITIALIZER;
	}
	
	Contact(String contactID, String firstName, String lastName, String number){
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		this.address = INITIALIZER;
	}
	
	Contact(String contactID,String firstName,String lastName, String number, String address){
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
		setContactID(contactID);
	}
	
	protected final String getContactID() {
		return contactID;
	}
	
	protected final String getFirstName() {
		return firstName;
	}
	
	protected final String getLastName() {
		return lastName;
	}
	
	protected final String getNumber() {
		return number;
	}
	
	protected final String getAddress() {
		return address;
	}
	
	protected void setFirstName(String firstName) {
		if(firstName == null) {
			throw new IllegalArgumentException("First name cannot be empty.");
		}
		else if (firstName.length()>10) {
			throw new IllegalArgumentException("First name exceeds 9 characters.");
		}
		else {
		this.firstName = firstName;
		}
	}
	
	protected void setLastName(String lastName) {
		if(lastName == null) {
			throw new IllegalArgumentException("Last name cannot be empty.");
		}
		else if(lastName.length()>10) {
			throw new IllegalArgumentException("Last name exceeds 9 characters.");
		}
		else {
			this.lastName = lastName;
		}
		
		
	}
	protected void setNumber(String number) {
		String regexTest = "[0-9]+";
		if(number == null){
			throw new IllegalArgumentException("Phone number cannot be null.");
		}
		else if(!(number.length()==10)) {
			throw new IllegalArgumentException("Phone number does not meet the length of 10 digits.");
		}
		else if(!(number.matches(regexTest))) {
			throw new IllegalArgumentException("Invalid characters in phone number.");
		}
		else{
			this.number = number;
		}
	}
	
	public void setAddress(String address) {
		if(address == null){
			throw new IllegalArgumentException("Address must not be empty.");
		}
		else if(address.length()>30) {
			throw new IllegalArgumentException("Address cannot exceed 30 characters in length.");
		}
		else {
			this.address = address;
		}
	}
	public void setContactID(String contactID) {
		if(contactID == null) {
			throw new IllegalArgumentException("ContactID invalid. Must not be empty.");
		}
		else if (contactID.length()>10) {
			throw new IllegalArgumentException("ContactID may not exceed 9 digits.");
		}
		
		else{
			this.contactID = contactID;
		}
	}
	
	
	
}