package org.homeos.budget.services;

import org.homeos.budget.models.Budget;
import org.homeos.budget.models.BudgetItem;
import org.homeos.budget.models.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BudgetServiceIMPL implements BudgetService {

    private Budget budget;
    private ArrayList<Budget> budgets;

    public BudgetServiceIMPL() {
        this.budget = new Budget();
        this.budgets = new ArrayList<>();
    }

    @Override
    public void createBudget(Budget budget) {
        this.budget = budget;
    }

    @Override
    public Budget getBudget() {
        return this.budget;
    }

    @Override
    public void addBudgetItem(BudgetItem item) {
        this.budget.addBudgetItem(item);
    }

    @Override
    public void addTag(Tag tag) {
        this.budget.addTag(tag);
    }

    @Override
    public void removeTag(Tag tag) {
        this.budget.removeTag(tag);
    }

    @Override
    public boolean hasTag(Tag tag) {
        return this.budget.hasTag(tag);
    }

    @Override
    public void addBudget(Budget budget) {
        this.budgets.add(budget);
    }
}
