package org.homeos.budget.services;

import org.homeos.budget.models.Budget;
import org.homeos.budget.models.BudgetItem;
import org.homeos.budget.models.Tag;

public interface BudgetService {

    void createBudget(Budget budget);
    void addBudget(Budget budget);
    Budget getBudget();
    void addBudgetItem(BudgetItem item);
    void addTag(Tag tag);
    void removeTag(Tag tag);
    boolean hasTag(Tag tag);


}
