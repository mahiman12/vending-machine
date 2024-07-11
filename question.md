Vending machine (beverage)
1) There are items in the vending machine like coke, soda, pepsi each with a particular price.
2) A user should be able to get prices of all the items in the machine.
3) A user should be able to select any item and insert cash to buy it.
4) The machine only performs one activity at a time. For eg If the machine is in process of dispensing an item, the user can't try to buy a new item or insert cash.
5) The machine should display appropriate error messages in every situation. For eg in above condition it can throw "already dispensing item can't select a new item".
6) The vending machine should also return the remaining change after dispensing the item if any.

Assumptions
A single slot in the vending machine
User can only buy one item of any type.


Schema:

1. Items
   1. id
   2. name
   3. vending_machine_id
   4. price
   5. quantity
   6. meta-data


2. Transaction
   1. id
   2. item_id
   3. price - 30
   4. payment_method - ENUM -> CASH, CREDIT
   5. credit_amount - 50
   6. debit_amount - 20
   7. status - CAPTURED, CREATED, FAILED
   8. reason


3. VendingMachine
   1. id
   2. name
   3. meta-data


4. Denominations
   1. id
   2. vending_machine_id
   3. denomination
   4. quantity

-> APIs
POST -> /item/add/{vending_machine_id}
{
    'name',
    price
}

GET /item/all/{vending_machine_id} -> Table: Items
{
    id
    items: [{}, {},....]
}
GET /item/{item_id} -> Table: Items
{
    id:
    .
    .
}

POST /buy/
{
    item_id
    cash
}
Status code: 200 OK
status code: 403 Forbidden request