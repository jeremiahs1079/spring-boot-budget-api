# Description
This spring boot application is designed to be a micro service for the Home OS application network. This service handles
the creation and management of a house hold budget. It allows users to create times budgets (start and end dates). 


# Endpoints
```
GET /budget
POST /budget
```

# Data Structures
#### Budget
###### Description
This data structure holds the information associated with a budget.
###### Fields:
* id - the unique identifier of the budget
* name - the display name of the budget
* startDate - the start date of the budget
* endDate - the end date of the budget
* budgetItems - list of ```BudgetItem``` that are included on the budget
* tags - lost of ```Tag``` that are include on the budget
* completed - boolean value that says if the budget is complete
* overBudget - boolean value that says if the budget id over (sum of expenses is greate then sum of incomes)
###### Example:
```json
{
  "id": 1,
  "name": "Budget Name",
  "startDate": "01-01-2019",
  "endDate": "01-31-2019",
  "budgetItems": [],
  "tags": [],
  "completed": false,
  "overBudget": false
}
```
#### Budget Item
###### Description
This data structure holds the information associated with a budget item. Budget items are the income and expense items associated with a budget.
###### Fields
* id - the unique identifier of the budget item
* name - the display name of the 
* estimatedAmount - the estimated amount of the budget item. This item is the amount that is initially set 
fot the budget item and is an estimate.
* actualAmount - the actual amount of the budget item. This item is the amount that the budget item actually costs and is verified
* verified - weather the budget item amount is verified as acurate
* tags - list of ```Tag``` that are associated with the budget item
* type - the type of budget item. ```EXPENSE``` or ```INCOME```
###### Example
```json
{
    "id": 1,
    "name": "Budget Expense Name",
    "estimatedAmount": 25.00,
    "actualAmount": 0,
    "verified": false,
    "tags": [],
    "type": "EXPENSE"
}
```

#### Tag
###### Description
This data structure holds the information associated with a tag. Tags are used to tag budgets or budget items with searchable terms.
###### Fields
  * id - the unique identifier of of the tag
  * name - the display name of the tag
###### Example
```json
{
  "id": 1,
  "name": "Tag Name"
}
```