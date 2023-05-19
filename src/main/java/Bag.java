/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {

    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;


    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[0];
    }


    public String getColor() {return this.color;}
    public int getNumberOfContents() {return this.numberOfContents;}
    public int getCapacity() {return this.capacity;}




    /*
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */
    public void setColor(String color) {
        this.color = color;
    }




    /*       This method should return true if the item was added
     *       and false otherwise.
     */
    public boolean addItem(String item) {
        if (this.numberOfContents >= this.capacity)
            return false;
        String[] newItems = new String[this.numberOfContents + 1];
        if (this.numberOfContents >= 0)
            System.arraycopy(this.contents, 0, newItems, 0, this.numberOfContents);
        newItems[this.numberOfContents++] = item;
        this.contents = newItems;
        return true;
    }



    /**
     * If there are no items in this Bag, return null.
     *
     * @return the last item in the bag. If there is no items in the bag, return null.
     */
    public String popItem() {
        if (this.numberOfContents == 0)
            return null;
        String[] newItems = new String[this.numberOfContents-1];
        System.arraycopy(this.contents, 0, newItems, 0, this.numberOfContents-1);
        String toReturn = this.contents[--this.numberOfContents];
        this.contents = newItems;
        return toReturn;
    }


    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        this.capacity += n;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return a string represents the details of the bag
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}