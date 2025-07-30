package collier.shopping_system.models;

import collier.shopping_system.custom_exceptions.item_exceptions.EmptyDescriptionException;
import collier.shopping_system.custom_exceptions.item_exceptions.InvalidPriceException;
import collier.shopping_system.custom_exceptions.item_exceptions.NegativeStockException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InventoryItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final int itemId; // PK of this value in DB

    @Min(value = 0)
    private int itemStock; // total number of a given item in stock (>=0)

    @Min(value = 0)
    private double itemPrice; // price of an item per unit

    @NotBlank
    private String itemDescription; // description of the item

    protected InventoryItem(int itemId, int inventoryStock, double itemPrice,
            String itemDescription) {
        this.itemId = itemId;
        this.itemStock = inventoryStock;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    public int getItemId() {
        return this.itemId;
    }

    public int getItemStock() {
        return this.itemStock;
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
        return this.itemPrice;
    }

    public boolean setItemPrice(double itemPrice) {
        try {
            if (itemPrice < 0) {
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
        return this.itemDescription;
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
                Id: %s, Avaliable Stock: $d, Price per Unit: %d, Description: "%s"
                """, this.itemId, this.itemStock, this.itemPrice, this.itemDescription);
        return retString;
    }

}
