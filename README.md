# Really Simple Receipt Format (RSRF)

*`Please note that this is a draft spec and represents work in progress. We celebrate questions, comments and every attempt to assist us during the definition period.`*

RSRF is a proposal for an easy to use format for electronic receipts. It was created to encourage and facilitate the creation and exchange of electronic receipts.

The principal design goal for the format is simplicity. We're scratching our own itch and we do *not* want to create an all-encompassing format allowing for every edge-case that might occur when communicating data between sellers and customers. For that we already have the intricate and complex standards for wlectronic invoices.

An RSRF-receipt will allow it's recipient to answer the following questions:
* Where did I shop
* When did I shop
* What did I purchase
* What quantity of each product did I purchase
* At what price did I purchase the products

Each field has some rationale behind it that works towards these goals.

## Example receipt

```
{
  "version": "1",
  "receiptID": "123-456-789",
  "sellerID": "987-654-321",
  "sellerGovernmentID": "091179-4829",
  "sellerName": "the Great shop",
  "sellerEmailAddress": "the.great@shop.com",
  "date": "2017-06-05",
  "time": "18:08:45.641",
  "timeZone": "GMT",
  "currencyCode": "ISK",
  "totalAmount": 844,
  "entries": [
    {
      "text": "Soylent Industries Green no. 3",
      "productCode": "5690527101004",
      "quantity": 1,
      "unitPrice": 155,
      "totalAmount": 155,
      "vatPercentage": 0.11
    },
    {
      "text": "Gurble Farms Whole Grain Bread",
      "productCode": "5690568010235",
      "quantity": 2,
      "unitPrice": 387,
      "discountPercentage": 0.10,
      "totalAmount": 689,
      "vatPercentage": 0.11
    }
  ]
}
```

## The spec

The spec defines three types of objects. A `receipt` is the base object. `receipt` contains `entry` objects that are lines that describe each purchased item. `receipt` objects can also contain `attachment` objects that are just blobs of data. An attachment could for example contain a rendered image or PDF-version of the receipt.

## Receipt

### version
Required. Version of the spec used by the receipt.

### receiptID
Required. String. This is the unique ID of your receipt within your store.

### sellerName
Required. String. Name of the seller.

### sellerID
Optional. String. A globally unique ID of the shop. Currently, only we (Strimillinn) assign these identifiers so please contact us to get one. If you're in Iceland, you probably already have one. We'd like to make this an open process in the future.

### sellerGovernmentID
Optional. String. The national ID number of the seller (in Iceland, this would be the "kennitala").

### sellerName
Optional. String. E-mail address of the seller.

### sellerGeoLocation
Optional. String. Location of the shop as specified by ISO-6709.

### timeZone
Required. Timezone of seller. String, formatted as specified by ISO-8601.

### date
Required. Date of purchase. String formatted as specified by ISO-8601.

### time
Optional. Time of purchase. String, formatted as specified by ISO-8601.

### currencyCode
Required. String. Code of the currency, as specified by ISO-4217.

### totalAmount
Required. Total amount paid.

### entries
Optional. List of `Entry` objects denoting what was purcased.

### attachments
Optional. List of `Attachment` objects containing, for example, a rendered image or PDF of the receipt, the shop logo etc.

## Entry

### text
Required. Description of the purchased product.

### quantity
Required. Quantity purchased, either number of units, weight etc.

### unitPrice;
Required. Price of each unit of the purchased product.

### totalAmount
Required. Total amount paid.

### productCode
Optional. Product number (UPC) of the purchased product.

### discountPercentage
Optional. Discount percentage, if applicable. Formatted as a decimal (0.10 for 10%).
Only one of discountAmount or discountPercentage can be specified.

### discountAmount
Optional. Discount amount, if applicable.
Only one of discountAmount or discountPercentage can be specified.

### vatPercentage
Optional. Percentage of VAT paid. Formatted as a decimal (0.24 for 24%).

## Attachment

### name
Required. Human readable document name. Displayed to the user. A document extension is required for the system to identify the document type when serving it to the user.

### data
Required. Base64 encoded data of the document.
