public class Book {
    private String name;
    private String author;
    private String publisher;
    private String year;
    private String isbn;

    public Book(String name, String author, String publisher, String year, String isbn) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
    }

    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equals(null)){
            throw new IllegalArgumentException("NO DATA");
        }
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.equals(null)){
            throw new IllegalArgumentException("NO DATA");
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if(publisher.equals(null)){
            throw new IllegalArgumentException("NO DATA");
        }
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if(year.equals(null)){
            throw new IllegalArgumentException("NO DATA");
        }
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if(isbn.length() != 10){
            throw new IllegalArgumentException("Wrong isbn");
        }
        else this.isbn = isbn;
    }

    /*public Book(String name, String author, String publisher, String year, String isbn) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
    }
    */
}