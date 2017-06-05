# Really Simple Receipt Format (RSRF)

*`Please note that this is a draft. This will not be titled a final spec until the first user is in action.`*

RSRF is an easy to use format for electronic receipts. It was crated to encourage and facilitate the creation of electronic receipts.

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

## the spec
