package org.homeos.budget.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class BudgetNotFoundException extends RuntimeException {
    public BudgetNotFoundException(long id) {
        super(String.format("Budget with id: %d not found", id));
    }
}
