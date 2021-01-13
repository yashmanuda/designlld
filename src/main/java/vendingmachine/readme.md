# Vending machine

## Requirements
1. User can buy an item with defined quantity
2. Needs to track the inventory
3. Can accept cash / card
4. Return change
5. Should deny the service if insufficient cash or item
6. Admin view to add inventory
7. User can cancel the transaction before payment


## Actors
1. Scanner (card / cash)
2. User
3. Dispenser


## States
1. Ready
2. Waiting for cash
3. Dispensing item
4. Dispensing change
5. Cancelled

## Actions by the user
1. Select item and quantity
2. Insert card / cash


## Actions by the admin (functionality)
1. Add items
2. Change price of the items