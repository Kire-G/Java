public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setName("Bogat tatko");
        book1.setAuthor("Velikiqt Getsbi");
        book1.setYear("1925");
        book1.setPublisher("Fransis Fitsdjerald");
        book1.setIsbn("153412246");
        Book book2 = new Book("White wizard" , "Pavel", "Ussr", "1985", "1643234T");
        Book book3 = new Book("Babylon-17" , "Samuel", "Usa", "1966", "7837373782882");


        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.searchBook("153412246");
        library.deleteBook("333255");
        library.searchBook("23556ww6");
    }
}