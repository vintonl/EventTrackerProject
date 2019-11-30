# EventTrackerProject



### Routes

| Return Type    | Route                 | Functionality            |
|----------------|-----------------------|--------------------------|
| `List<Beverage>` |`GET api/beverages`| Gets all beverages   |
| `Beverage`       |`GET api/beverages/{id}`| Gets one beverage by id |
| `Beverage`       |`PUT api/beverages/{id}`| Update a beverage by id|
| `Void`       |`DELETE api/beverages/{id}`| Deletes a beverage by id|
| `List<Beverage>` |`GET api/beverages/caffeinated`| Gets all beverages   |
| `List<Beverage>` |`GET api/beverages/name/{keyword}`| Gets all beverages by keyword search of name   |
| `List<Beverage>` |`GET api/beverages/date/{date}`| Gets all beverages by date (yyyy-MM-dd)   |
