package collier.shopping_system.models;

import collier.shopping_system.custom_exceptions.InvalidIsbnException;

public class BookItem extends InventoryItem{
    private final int bookId;
    private String bookIsbn;
    private String bookTitle;
    private String bookAuthor;
    public BookItem(int itemId, String itemIdString, int inventoryStock, double itemPrice, String itemDescription,
            int bookId, String bookIsbn, String bookTitle, String bookAuthor) {
        super(itemId, itemIdString, inventoryStock, itemPrice, itemDescription);
        this.bookId = bookId;
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }
    public int getBookId() {
        return bookId;
    }
    public String getBookIsbn() {
        return bookIsbn;
    }
    public void setBookIsbn(String bookIsbn) {
        try {
            if(!validateIsbn(bookIsbn))
                throw new InvalidIsbnException();
        } catch (InvalidIsbnException e) {
            System.err.println(e.getMessage());
        }
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    private boolean validateIsbn(String isbn) {
        return isbn.length() == 13 && isbn.matches("\\d{13}");
    }
}
