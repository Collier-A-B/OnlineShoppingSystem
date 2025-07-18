package collier.shopping_system.models;

import collier.shopping_system.custom_exceptions.book_exceptions.EmptyAuthorException;
import collier.shopping_system.custom_exceptions.book_exceptions.EmptyTitleException;
import collier.shopping_system.custom_exceptions.book_exceptions.InvalidIsbnException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class BookItem extends InventoryItem{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final int bookId;

    @NotBlank
    @Size(min=13, max=13)
    private String bookIsbn;

    @NotBlank
    private String bookTitle;

    @NotBlank
    private String bookAuthor;

    public BookItem(int itemId, int inventoryStock, double itemPrice, String itemDescription,
            int bookId, String bookIsbn, String bookTitle, String bookAuthor) {
        super(itemId, inventoryStock, itemPrice, itemDescription);
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
    public boolean setBookIsbn(String bookIsbn) {
        try {
            if(!validateIsbn(bookIsbn))
                throw new InvalidIsbnException();
            this.bookIsbn = bookIsbn;
        } catch (InvalidIsbnException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public boolean setBookTitle(String bookTitle) {
        try {
            if (bookTitle.isEmpty())
                throw new EmptyTitleException();
            this.bookTitle = bookTitle;
        } catch (EmptyTitleException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public boolean setBookAuthor(String bookAuthor) {
        try {
            if (bookAuthor.isEmpty())
                throw new EmptyAuthorException();
            this.bookAuthor = bookAuthor;
        } catch (EmptyAuthorException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean validateIsbn(String isbn) {
        return isbn.length() == 13 && isbn.matches("\\d{13}");
    }

    @Override
    public String toString() {
        String retString = super.toString() + String.format("""
            \nbookIsbn: %s, bookTitle: %s, bookAuthor: %s
            """, this.bookIsbn, this.bookTitle, this.bookAuthor);
        return retString;
    }
}
