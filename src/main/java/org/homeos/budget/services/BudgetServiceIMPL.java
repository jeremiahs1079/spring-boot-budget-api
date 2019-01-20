package org.homeos.budget.services;

import lombok.extern.slf4j.Slf4j;
import org.homeos.budget.exceptions.BudgetNotFoundException;
import org.homeos.budget.models.Budget;
import org.homeos.budget.models.BudgetItem;
import org.homeos.budget.models.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class BudgetServiceIMPL implements BudgetService {

    private long currentBudgetId;
    private long currentBudgetItemId;
    private ArrayList<Budget> budgets;

    public BudgetServiceIMPL() {
        this.currentBudgetId = 0;
        this.currentBudgetItemId = 0;
        this.budgets = new ArrayList<>();
    }

    @Override
    public Budget createBudget() {
        Budget budget = this.createNewBudget();
        this.budgets.add(budget);
        return budget;
    }

    @Override
    public Budget getBudget(long budgetId) {
        for(Budget budget: budgets) {
            if(budget.getId() == budgetId){
                return budget;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Budget> getBudgets() {
        return this.budgets;
    }

    @Override
    public BudgetItem addBudgetItem(BudgetItem item, long budgetId) {
        log.info("Budget Service adding new item: {} to budget id: {}", item, budgetId);

        Budget budget = this.getBudget((budgetId));

        if(budget == null){
            throw new BudgetNotFoundException(budgetId);
        }


        //check if budget has null items
        //if no budget items currently create new ArrayList for budget item
        if(budget.getBudgetItems() == null) {
            budget.setBudgetItems(new ArrayList<>());
        }

        this.currentBudgetItemId++;
        item.setId(this.currentBudgetItemId);
        budget.addBudgetItem(item);

        return item;
    }

    @Override
    public void addTag(Tag tag, long budgetId) {
        Budget budget = this.getBudget(budgetId);

        if(budget == null) {
            throw new BudgetNotFoundException(budgetId);
        }

        budget.addTag(tag);

    }

    @Override
    public void removeTag(Tag tag, long budgetId) {

        Budget budget = this.getBudget(budgetId);

        if(budget == null) {
            throw new BudgetNotFoundException(budgetId);
        }

        budget.removeTag(tag);

    }

    @Override
    public boolean hasTag(Tag tag, long budgetId) {
        Budget budget = this.getBudget(budgetId);

        if(budget == null) {
            throw new BudgetNotFoundException(budgetId);
        }

        return budget.hasTag(tag);
    }

    @Override
    public Budget addBudget(Budget budget) {
        this.currentBudgetId++;
        budget.setId(this.currentBudgetId);
        this.budgets.add(budget);

        return budget;
    }

    //private methods
    private Budget createNewBudget() {
        Budget budget  = new Budget();
        this.currentBudgetId++;

        //TODO Remove this functionality once Database is setup
        budget.setId(this.currentBudgetId);
        budget.setBudgetItems(new ArrayList<>());
        budget.setTags(new ArrayList<>());

        return budget;
    }
}
