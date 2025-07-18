package collier.shopping_system.models;

import collier.shopping_system.custom_exceptions.item_exceptions.EmptyDescriptionException;
import collier.shopping_system.custom_exceptions.item_exceptions.InvalidPriceException;
import collier.shopping_system.custom_exceptions.item_exceptions.NegativeStockException;

public abstract class InventoryItem {
    private final int itemId; // PK of this value in DB
    private int itemStock; // total number of a given item in stock (>=0)
    private double itemPrice; // price of an item per unit
    private String itemDescription; // description of the item

    protected InventoryItem(int itemId, int inventoryStock, double itemPrice,
            String itemDescription) {
        this.itemId = itemId;
        this.itemStock = inventoryStock;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    public int getItemId() {
        return itemId;
    }

    public int getItemStock() {
        return itemStock;
    }

    public boolean setItemStock(int inventoryStock) {
        try {
            if (inventoryStock < 0) {
                throw new NegativeStockException();
            }
            this.itemStock = inventoryStock;
        } catch (NegativeStockException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public boolean setItemPrice(double itemPrice) {
        try {
            if (itemPrice <= 0) {
                throw new InvalidPriceException();
            }
            this.itemPrice = itemPrice;
        } catch (InvalidPriceException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public boolean setItemDescription(String itemDescription) {
        try {
            if (itemDescription.isEmpty())
                throw new EmptyDescriptionException();
            this.itemDescription = itemDescription;
        } catch (EmptyDescriptionException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String retString = String.format("""
                Id: %s, Avaliable Stock: $d, Price per Unit: %d
                Description: "%s"
                """, this.itemId, this.itemStock, this.itemPrice, this.itemDescription);
        return retString;
    }

}
