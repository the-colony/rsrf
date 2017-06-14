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
	 * Information about the seller.
	 */
	public Seller seller;

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
	 * Discount as a percentage
	 */
	public BigDecimal discountPercentage;

	/**
	 * Discount as an amount
	 */
	public BigDecimal discountAmount;

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