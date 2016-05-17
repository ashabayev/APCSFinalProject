
/**
 * @author Anna and Aadit
 *sets address, city, state, zip
 */
public class Address {
	private String street;//The street number and street name
	private String city;//The city in which the address is located
	private String state;	//The state in which the address is located
	private String zip;//The zip code associated with that city and street

	/**
	 * Constructor creates an address using four parameters
	 * 
	 * @param road
	 *            describes the street number and name
	 * @param town
	 *            describes the city
	 * @param st
	 *            describes the state
	 * @param zipCode
	 *            describes the zip code
	 */
	public Address(String road, String town, String st, String zipCode) {
		street = road;
		city = town;
		state = st;
		zip = zipCode;
	}

	/**constructor
	 * @param a
	 */
	public Address(Address a) {
		this.street = a.street;
		this.city = a.city;
		this.state = a.state;
		this.zip = a.zip;
	}

	/**
	 * toString method returns information about the address
	 * 
	 * @return all imformation about the address
	 */
	public String toString() {
		return (street + ", " + city + ", " + state + " " + zip);
	}

	/**check if addresses are equal 
	 * @param a
	 * @return
	 */
	public boolean equal(Address a) {
		if (this.street.equals(a.street) && this.city.equals(a.city) && this.state.equals(a.state)
				&& this.zip.equals(a.zip)) {
			return true;
		} else {
			return false;
		}
	}

}


