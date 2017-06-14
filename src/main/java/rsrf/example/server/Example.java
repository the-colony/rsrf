package rsrf.example.server;

import static spark.Spark.get;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rsrf.model.Entry;
import rsrf.model.Receipt;
import rsrf.model.Seller;

public class Example {

	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	public static void main( String[] args ) {
		get( "/receipt/:id", ( request, response ) -> {
			response.type( "application/json; charset=utf-8" );

			if( request.params( ":id" ).equals( "1" ) ) {
				return GSON.toJson( receipt1thatHasNoAttachments() );
			}

			if( request.params( ":id" ).equals( "2" ) ) {
				return GSON.toJson( receipt2thatHasAttachments() );
			}

			return "What is my purpose? I serve butte… I mean receipts. And I only serve the two receipts mentioned above.";

		} );
	}

	private static Receipt receipt1thatHasNoAttachments() throws IOException {
		final Receipt receipt = new Receipt();
		receipt.id = "123-456-789";

		receipt.seller = new Seller();
		receipt.seller.governmentID = "091179-4829";
		receipt.seller.name = "the Great shop";
		receipt.seller.emailAddress = "the.great@shop.com";
		receipt.seller.id = "987-654-321";

		receipt.totalAmount = new BigDecimal( "844" );
		receipt.currency = "ISK";
		receipt.date = LocalDate.now().toString();
		receipt.time = LocalTime.now().toString();
		receipt.timeZone = "GMT";
		receipt.version = "1.0.0";
		receipt.entries = new ArrayList<>();

		Entry e1 = new Entry();
		e1.description = "Milk 1L";
		e1.unitPrice = new BigDecimal( "155" );
		e1.productCode = "5690527101004";
		e1.quantity = new BigDecimal( "1" );
		e1.vatPercentage = new BigDecimal( "0.11" );
		e1.totalAmount = new BigDecimal( 155 );
		receipt.entries.add( e1 );

		Entry e2 = new Entry();
		e2.description = "Whole grain bread, 770g";
		e2.unitPrice = new BigDecimal( "387" );
		e2.productCode = "5690568010235";
		e2.quantity = new BigDecimal( "2" );
		e2.vatPercentage = new BigDecimal( "0.11" );
		e2.discountPercentage = new BigDecimal( "0.10" );
		e2.totalAmount = new BigDecimal( 689 );
		receipt.entries.add( e2 );

		// Attachment attachment = new Attachment();
		// attachment.name = "reikningur.pdf";
		// attachment.data = java.util.Base64.getEncoder().encodeToString( IOUtils.toByteArray( Example.class.getResourceAsStream( "kittens.png" ) ) );
		// receipt.attachments.add( attachment );

		return receipt;
	}

	private static Receipt receipt2thatHasAttachments() {
		final Receipt receipt = new Receipt();
		receipt.id = "i-am-so-unique";

		receipt.seller = new Seller();
		receipt.seller.governmentID = "123456-7890";
		receipt.seller.emailAddress = "frábær@verslun.is";
		receipt.seller.id = "i-am-even-more-unique";

		return receipt;
	}
}