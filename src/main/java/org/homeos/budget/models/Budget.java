package org.homeos.budget.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@ToString
public class Budget {

    //member variables
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private Date startDate;
    @Getter @Setter
    private Date endDate;
    @Getter @Setter
    private ArrayList<BudgetItem> budgetItems;
    @Getter @Setter
    private ArrayList<Tag> tags;
    @Getter @Setter
    private boolean completed;
    private float totalExpenses;
    private float totalIncome;

    public Budget() {
        this.budgetItems = new ArrayList<>();
        this.tags = new ArrayList<>();
    }


    //public methods
    public void addBudgetItem(BudgetItem item) {


        this.budgetItems.add(item);


        if(item.getType() == BudgetItemType.EXPENSE)
            this.updateTotalExpense();
        else
            this.updateTotalIncome();

    }

    public boolean isOverBudget() {
        return this.totalIncome < this.totalExpenses;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }

    public boolean hasTag(Tag tag) {
        return this.tags.contains(tag);
    }



    //override methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Budget)) return false;

        Budget budget = (Budget) o;

        return id == budget.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    //private methods
    private void updateTotalExpense() {

        this.totalExpenses = this.getTotal(BudgetItemType.EXPENSE);
    }

    private void updateTotalIncome() {


        this.totalIncome = this.getTotal(BudgetItemType.INCOME);
    }

    private float getTotal(BudgetItemType type) {
        float newTotal = 0f;

        for (BudgetItem item: budgetItems) {
            if(item.getType() == type) {
                newTotal += item.getEstimatedAmount();
            }
        }

        return newTotal;
    }

}
