package org.homeos.budget.services;

import org.homeos.budget.models.Budget;
import org.homeos.budget.models.BudgetItem;
import org.homeos.budget.models.Tag;

import java.util.ArrayList;

public interface BudgetService {

    Budget createBudget();
    Budget addBudget(Budget budget);
    Budget getBudget(long budgetId);
    ArrayList<Budget> getBudgets();
    BudgetItem addBudgetItem(BudgetItem item, long budgetId);
    void addTag(Tag tag, long budgetId);
    void removeTag(Tag tag, long budgetId);
    boolean hasTag(Tag tag, long budgetId);


}
