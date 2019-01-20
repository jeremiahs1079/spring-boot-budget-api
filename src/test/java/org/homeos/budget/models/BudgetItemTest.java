package org.homeos.budget.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BudgetItemTest {

    private Tag expectedTag;
    private BudgetItem testItem;


    @Before
    public void setUp() {
        this.expectedTag = new Tag();
        this.testItem = new BudgetItem();

        this.expectedTag.setTagId(1);
        this.expectedTag.setTagName("Test Tag Name");
    }

    @Test
    public void addTag() {


        Tag tagToAdd = new Tag();
        tagToAdd.setTagName("Test Tag Name");
        tagToAdd.setTagId(1);

        this.testItem.addTag(tagToAdd);

        assertTrue(!testItem.getTags().isEmpty());
    }

    @Test
    public void removeTag() {
    }

    @Test
    public void hasTag() {


        Tag tagToAdd = new Tag();
        tagToAdd.setTagName("Test Tag Name");
        tagToAdd.setTagId(1);

        this.testItem.addTag(tagToAdd);

        assertTrue("test item has test tag",testItem.getTags().contains(tagToAdd));
    }

    @Test
    public void equals() {

        

    }
}