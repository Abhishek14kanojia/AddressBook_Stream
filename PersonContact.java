package io.javabrain;

public class PersonContact {

	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String State;
	private String Zip;
	private Long PhoneNumber;
	private String Email;
	public final String getFirstName() {
		return FirstName;
	}
	public final void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public final String getLastName() {
		return LastName;
	}
	public final void setLastName(String lastName) {
		LastName = lastName;
	}
	public final String getAddress() {
		return Address;
	}
	public final void setAddress(String address) {
		Address = address;
	}
	public final String getCity() {
		return City;
	}
	public final void setCity(String city) {
		City = city;
	}
	public final String getState() {
		return State;
	}
	public final void setState(String state) {
		State = state;
	}
	public final String getZip() {
		return Zip;
	}
	public final void setZip(String zip) {
		Zip = zip;
	}
	public final Long getPhoneNumber() {
		return PhoneNumber;
	}
	public final void setPhoneNumber(Long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public final String getEmail() {
		return Email;
	}
	public final void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "PersonContact [FirstName=" + FirstName + ", LastName=" + LastName + ", Address=" + Address + ", City="
				+ City + ", State=" + State + ", Zip=" + Zip + ", PhoneNumber=" + PhoneNumber + ", Email=" + Email
				+ "]";
	}
	
	
}
