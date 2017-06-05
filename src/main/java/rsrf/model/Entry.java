package rsrf.model;

import java.math.BigDecimal;

public class Entry {

	/**
	 * Description of the product purchased
	 */
	public String text;

	/**
	 * Product number (UPC) of the purchased product.
	 */
	public String productCode;

	/**
	 * Quantity purchased, either number of units, weight etc.
	 */
	public BigDecimal quantity;

	/**
	 * Price of each unit
	 */
	public BigDecimal unitPrice;

	/**
	 * Discount as a percentage
	 */
	public BigDecimal discountPercentage;

	/**
	 * Discount as an amount
	 */
	public BigDecimal discountAmount;

	/**
	 * Total price of the entry.
	 */
	public BigDecimal total;

	/**
	 * VAT percentage applied as a decimal (0.24 for 24%)
	 */
	public BigDecimal vatPercentage;
}