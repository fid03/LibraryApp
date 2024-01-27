package Entities;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> books;
    public int bookCount;

    public Library() {
        books = new ArrayList<>();
        this.bookCount = 0;
    }

    public void addBook(Book newBook) {
        boolean isBookExists = books.stream()
                .filter(book -> book.Name.equalsIgnoreCase(newBook.Name)).findFirst().isPresent();
        if (isBookExists) {
            books.stream().filter(book -> book.Name.equalsIgnoreCase(newBook.Name)).findFirst().ifPresent(book -> book.Count += newBook.Count);
        } else {
            books.add(newBook);
        }

    }


    public void updateBook(Book updatedBook, String newLanguage, double newPrice) {
        books.stream()
                .filter(book -> book == updatedBook)
                .findFirst().ifPresent(book -> {
                    book.Language = newLanguage;
                    book.Price = newPrice;
                });
    }

    public void deleteBook(int Id) {
        boolean isRemoved = books.removeIf(book -> book.getId() == Id);
        if (isRemoved) {
            System.out.println("Book with ID " + Id + " deleted successfully!");
        } else {
            System.out.println("Book with ID " + Id + " not found.");
        }

    }

    public Book findBookByName(String Name) {
        for (Book book : books) {
            if (book.Name.equalsIgnoreCase(Name)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookById(int Id) {
        for (Book book : books) {
            if (book.getId() == Id) {
                return book;
            }
        }
        return null;
    }

    public void showBooks() {
        books.forEach(Book::fullInfo);
    }

}
