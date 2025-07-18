package collier.shopping_system.models;

import collier.shopping_system.custom_exceptions.InvalidPriceException;
import collier.shopping_system.custom_exceptions.NegativeStockException;

public abstract class InventoryItem {
    private final int itemId;
    private String itemIdString;
    private int itemStock;
    private double itemPrice;
    private String itemDescription;
    
    protected InventoryItem(int itemId, String itemIdString, int inventoryStock, double itemPrice, String itemDescription) {
        this.itemId = itemId;
        this.itemIdString = itemIdString;
        this.itemStock = inventoryStock;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemIdString() {
        return itemIdString;
    }

    public void setItemIdString(String itemIdString) {
        this.itemIdString = itemIdString;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int inventoryStock) {
        try {
            if(inventoryStock < 0) {
                throw new NegativeStockException();
            }
            this.itemStock = inventoryStock;
        } catch (NegativeStockException e) {
            System.err.println(e.getMessage());
        }
        
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        try {
            if(itemPrice <= 0) {
                throw new InvalidPriceException();
            }
            this.itemPrice = itemPrice;
        } catch (InvalidPriceException e) {
            System.err.println(e.getMessage());
        }
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    
}
