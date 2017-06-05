# Really Simple Receipt Format (RSRF)

*`Please note that this is a draft. This will not be titled a final spec until the first user is in action.`*

RSRF is an easy to use format for electronic receipts. It was created to encourage and facilitate the creation of electronic receipts.

## Example receipt

```
{
  "version": "1",
  "receiptID": "123-456-789",
  "sellerID": "987-654-321",
  "sellerSSN": "091179-4829",
  "sellerName": "the Great shop",
  "sellerEmailAddress": "the.great@shop.com",
  "date": "2017-06-05",
  "time": "18:08:45.641",
  "timeZone": "GMT",
  "currency": "ISK",
  "totalAmount": 844,
  "entries": [
    {
      "text": "Milk 1L",
      "productCode": "5690527101004",
      "quantity": 1,
      "unitPrice": 155,
      "totalAmount": 155,
      "vatPercentage": 0.11
    },
    {
      "text": "Whole grain bread, 770g",
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

The spec defines three types of objects. A `receipt` is the base object. `receipt` contains `entry` objects that are lines that describe each purchased item. `receipt` objects can also contain `attachment` objects that are blobs of data submitted by the seller. Thie could for example contain a rendered version of the receipt.

## Receipt

### receiptID
Required. String. This is the globally unique ID of your receipt.

### sellerName
Required. String. Name of the seller.

### sellerID
Optional. String. A globally unique ID of the shop. Currently, only we (Strimillinn) assign these identifiers so please contact us to get one. If you're in Iceland, you probably already have one. We'd like to make this a more open process in the future.

### sellerSSN
Optional. String. optional. The national ID number of the seller (in Iceland, this would be the "kennitala").

### sellerName
Optional. String. E-mail address of the seller.

### sellerGeoLocation
Optional. String. Location of the shop as specified by ISO-6709.

## timeZone
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
Required. Total amount paid

### productCode
Optional. Product number (UPC) of the purchased product.

### discountPercentage
Optional. Discount percentage, if applicable. Formatted as a decimal (0.10 for 10%)
Only one of discountAmount or discountPercentage can be specified.

### discountAmount
Optional. Discount amount, if applicable.
Only one of discountAmount or discountPercentage can be specified.

### vatPercentage
Optional. Percentage of VAT paid.

## Attachment

### name
Required. Human readable document name. Displayed to the user. A document extension is required for the system to identify the document type when serving it to the user.

### data
Required. Base64 encoded data of the document
