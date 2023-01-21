import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<Book>();
    //private Book [] books;

    public void addBook(Book book) {
        books.add(book);
    }

    //finding obj in arrlist by property

    public void searchBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println(book.getName() +" "+ book.getAuthor() +" "+ book.getPublisher() +" "+ book.getYear() + " "+book.getIsbn());
            }
        }
    }

    public void deleteBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
            }
        }
    }
}