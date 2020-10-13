package org.homeos.budget.controllers;

import lombok.extern.slf4j.Slf4j;
import org.homeos.budget.exceptions.BudgetItemsNotFound;
import org.homeos.budget.exceptions.BudgetNotFoundException;
import org.homeos.budget.models.Budget;
import org.homeos.budget.models.BudgetItem;
import org.homeos.budget.services.BudgetService;
import org.homeos.budget.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@Slf4j
@RequestMapping("api")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("budgets")
    public ArrayList<Budget> getBudgets() {
        return this.budgetService.getBudgets();
    }

    @GetMapping("budgets/{budgetId}")
    public Budget getBudget(@PathVariable long budgetId) {

        Budget budget = budgetService.getBudget(budgetId);

        if(budget == null) {
            throw new BudgetNotFoundException(budgetId);
        }

        return this.budgetService.getBudget(budgetId);
    }

    @PutMapping("budgets/{budgetId}")
    public Budget updateBudget(@RequestBody Budget budget) {
        this.budgetService.updateBudget(budget);

        return this.budgetService.getBudget(budget.getId());
    }

    @PostMapping("budgets")
    public Budget addBudget(@RequestBody Budget budget) {
        log.info("Adding Budget");
        log.info("Budget to add {}", budget);
        return this.budgetService.addBudget(budget);
    }

    @GetMapping("budgets/{budgetId}/items")
    public ArrayList<BudgetItem> getBudgetItems(@PathVariable long  budgetId) {
        Budget budget = this.budgetService.getBudget(budgetId);

        if(budget == null) {
            throw new BudgetNotFoundException(budgetId);
        }

        if(budget.getBudgetItems() == null){
            throw new BudgetItemsNotFound(budgetId);
        }

        return budget.getBudgetItems();
    }

    @PostMapping("budgets/{budgetId}/items")
    public BudgetItem addBudgetItem(@RequestBody BudgetItem item, @PathVariable long budgetId) {
        this.log.info("Attempting to add: {}", item);
        return this.budgetService.addBudgetItem(item, budgetId);
    }

}
