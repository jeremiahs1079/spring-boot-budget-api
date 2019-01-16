package org.homeos.budget.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class BudgetItem {

    //member variables
    private long id;
    private String name;
    private float estimatedAmount;
    private float actualAmount;
    private boolean verified;
    private ArrayList<Tag> tags;
    private BudgetItemType type;

    //public methods

    /**
     * Method to add a tag to the budget item
     * @param tagToAdd Tag to add to the budget items
     */
    public void addTag(Tag tagToAdd) {
        this.tags.add(tagToAdd);
    }

    /**
     * Method to remove a tag from  the budget item
     * @param tagToRemove
     */
    public void removeTag(Tag tagToRemove) {
        this.tags.remove(tagToRemove);
    }

    /**
     * Method to check if this budget item has the tag
     * @param tag tag to check
     * @return true if tag exists on budget item false otherwise
     */
    public boolean hasTag(Tag tag) {
        return this.tags.contains(tag);
    }

}
