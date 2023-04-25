package pl.sda.micgeb.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.micgeb.springthymeleaf.model.Book;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/book")
    public String book(Model model) {
        Book book1 = new Book("Harry Potter i Kamień Filozoficzny", "J. K. Rowling");
        Book book2 = new Book("Pan Tadeusz", "Adam Mickiewicz");
        Book book3 = new Book("Ziemia obiecana", "Władysław Reymont");

        List<Book> books = Arrays.asList(book1, book2, book3);

        model.addAttribute("books", books);
        model.addAttribute("myName", "Michał");

        return "books";
    }
}
