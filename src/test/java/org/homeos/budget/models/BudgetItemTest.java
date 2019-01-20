package org.homeos.budget.models;

import org.junit.After;
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

        this.testItem.setId(1);
        this.expectedTag.setTagId(1);
        this.expectedTag.setTagName("Test Tag Name");
    }

    @After
    public void tearDown() {
        this.expectedTag = null;
        this.testItem = null;
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
        this.testItem.addTag(this.expectedTag);

        this.testItem.removeTag(this.expectedTag);

        assertTrue("Tags should be empty", this.testItem.getTags().isEmpty());
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
        BudgetItem equals = new BudgetItem();
        equals.setId(1);

        assertTrue("Should be equal new item", this.testItem.equals(equals));
        

    }
}