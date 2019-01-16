package org.homeos.budget.controllers;

import org.homeos.budget.models.Budget;
import org.homeos.budget.models.BudgetItem;
import org.homeos.budget.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("")
    public Budget getBudget() {
        return this.budgetService.getBudget();
    }

    @PostMapping("")
    public void addBudget(@RequestBody Budget budget) {
        this.budgetService.createBudget(budget);
    }

    @GetMapping("items")
    public ArrayList<BudgetItem> getBudgetItems() {
        return this.budgetService.getBudget().getBudgetItems();
    }

    @PostMapping("add/item")
    public String addExpense(@RequestBody BudgetItem item) {
        this.budgetService.addBudgetItem(item);
        return "item added";
    }
}
