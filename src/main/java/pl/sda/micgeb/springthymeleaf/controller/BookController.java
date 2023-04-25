package pl.sda.micgeb.springthymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.micgeb.springthymeleaf.model.Book;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
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
        model.addAttribute("newBook", new Book());
        return "showBooks";
    }

    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("newBook") Book book, Errors errors, ModelMap model) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(x -> System.out.println(x));

            model.addAttribute("books", books);
            return "showBooks";
        }
        System.out.println(book);
        books.add(book);

        return "redirect:/book";
    }

    @PostMapping("/removeBook")
    public String removeBook(@RequestParam String title) {
        books.removeIf(book -> book.getTitle().equals(title));
        return "redirect:/book";
    }

}
