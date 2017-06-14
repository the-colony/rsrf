package rsrf.model;

public class Seller {

	/**
	 * Globally unique seller identifier. Don't have an ID but want one? Call us.
	 */
	public String id;

	/**
	 * Government ID number (kennitala) of the seller.
	 */
	public String governmentID;

	/**
	 * Name of the seller
	 */
	public String name;

	/**
	 * E-mail address of the seller
	 */
	public String emailAddress;

	/**
	 * Location of the shop as specified by ISO-6709
	 */
	public String geoLocation;

}