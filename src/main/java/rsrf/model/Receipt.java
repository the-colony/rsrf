package rsrf.model;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

	/**
	 * The version of the receipt spec, as specified by semantic versioning.
	 */
	public String version;

	/**
	 * Globally unique receipt identifier
	 */
	public String id;

	/**
	 * Globally unique seller identifier. Don't have an ID but want one? Call us.
	 */
	public String sellerID;

	/**
	 * National ID number (kennitala) of the seller.
	 */
	public String sellerSSN;

	/**
	 * Name of the seller
	 */
	public String sellerName;

	/**
	 * E-mail address of the seller
	 */
	public String sellerEmailAddress;

	/**
	 * Location of the shop as specified by ISO-6709
	 */
	public String geoLocation;

	/**
	 * Date of receipt. Format as specified by ISO-8601
	 */
	public String date;

	/**
	 * Time of receipt. Format as specified by ISO-8601
	 */
	public String time;

	/**
	 * Time zone of receipt. Format as specified by ISO-8601
	 */
	public String timeZone;

	/**
	 * Code of the currency, as specified by ISO-4217
	 */
	public String currency;

	/**
	 * Total paid amount
	 */
	public BigDecimal totalAmount;

	/**
	 * The entries contained by the receipt
	 */
	public List<Entry> entries;

	/**
	 * Attachments that can be sent with the receipt
	 */
	public List<Attachment> attachments;

}