package org.homeos.budget.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BudgetItemsNotFound extends RuntimeException {
    public BudgetItemsNotFound(long budgetId){
        super(String.format("Budget Items for budget with ID: %d not found", budgetId));
    }
}
