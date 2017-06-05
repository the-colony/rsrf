package rsrf.model;

/**
 * An attachment that can be sent with a receipt. For example a rendered image or PDF.
 */
public class Attachment {

	/**
	 * Human friendly document name. Displayed to the user. A document extension is required for the system to accept the document.
	 */
	public String name;

	/**
	 * Base64 encoded data of the document
	 */
	public String data;
}