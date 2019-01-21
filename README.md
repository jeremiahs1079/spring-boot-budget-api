# Description
This spring boot application is desiged to be a micro service for the Home OS application network


# Endpoints
```
GET /budget
POST /budget
```

# Examples
#### Budget
A budget consists of a name, start date, end date, list of budget items, list of tags

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
A budget item consists of a 
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