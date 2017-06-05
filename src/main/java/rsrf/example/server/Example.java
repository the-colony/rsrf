package rsrf.example.server;

import static spark.Spark.get;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rsrf.model.Attachment;
import rsrf.model.Receipt;
import spark.utils.IOUtils;

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
		receipt.receiptUniqueID = "1";
		receipt.sellerSSN = "123456-7890";
		receipt.sellerName = "Frábær verslun";
		receipt.sellerEmailAddress = "frábær@verslun.is";
		receipt.sellerUniqueID = "i-am-so-unique";
		receipt.attachments = new ArrayList<>();

		Attachment attachment = new Attachment();
		attachment.name = "reikningur.pdf";
		attachment.data = java.util.Base64.getEncoder().encodeToString( IOUtils.toByteArray( Example.class.getResourceAsStream( "kittens.png" ) ) );
		receipt.attachments.add( attachment );

		return receipt;
	}

	private static Receipt receipt2thatHasAttachments() {
		final Receipt receipt = new Receipt();
		receipt.sellerSSN = "123456-7890";
		receipt.sellerEmailAddress = "frábær@verslun.is";
		receipt.sellerUniqueID = "i-am-even-more-unique";
		receipt.receiptUniqueID = "i-am-so-unique";

		return receipt;
	}
}