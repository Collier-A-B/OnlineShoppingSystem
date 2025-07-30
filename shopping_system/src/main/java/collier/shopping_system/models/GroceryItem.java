package collier.shopping_system.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class GroceryItem extends InventoryItem {

    @NotBlank
    private Date sellByDate;

    @NotBlank 
    private Date expirDate;

    @NotBlank
    private String groceryCategory;

    public GroceryItem(int itemId, int inventoryStock, double itemPrice, String itemDescription, int groceryId,
            @NotBlank Date sellByDate, @NotBlank Date expirDate, @NotBlank String groceryCategory) {
        super(itemId, inventoryStock, itemPrice, itemDescription);
        this.sellByDate = sellByDate;
        this.expirDate = expirDate;
        this.groceryCategory = groceryCategory;
    }

    public Date getSellByDate() {
        return this.sellByDate;
    }

    public boolean setSellByDate(Date sellByDate) {
        try {
            this.sellByDate = sellByDate;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Date getExpirDate() {
        return this.expirDate;
    }

    public boolean setExpirDate(Date expirDate) {
        try {
            this.expirDate = expirDate;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
        
    }

    public String getGroceryCategory() {
        return this.groceryCategory;
    }

    public boolean setGroceryCategory(String groceryCategory) {
        try {
            this.groceryCategory = groceryCategory;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
        
    }

    @Override
    public String toString() {
        return super.toString() + String.format("""
                \ngrocerySellBy: %s, groceryExpir: %s, groceryCategory: %s
                """, this.sellByDate, this.expirDate, this.groceryCategory);
    }

    
    
}
