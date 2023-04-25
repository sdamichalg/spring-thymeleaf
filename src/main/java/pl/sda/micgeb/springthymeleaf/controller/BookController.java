package pl.sda.micgeb.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.micgeb.springthymeleaf.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private final List<Book> books;

    public BookController() {
        Book book1 = new Book("Harry Potter i Kamień Filozoficzny", "J. K. Rowling");
        Book book2 = new Book("Pan Tadeusz", "Adam Mickiewicz");
        Book book3 = new Book("Ziemia obiecana", "Władysław Reymont");
        this.books = new ArrayList<>();

        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    @GetMapping("/book")
    public String book(Model model) {
        model.addAttribute("books", books);

        return "books";
    }
}
