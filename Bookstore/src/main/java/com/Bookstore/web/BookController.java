package com.Bookstore.web;


import com.Bookstore.model.Book;
import com.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;


@Controller
public class BookController {
	
    @Autowired
    private BookRepository bookRepository;
    
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
    
    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/savebook")
    public String save(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
    
    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }
    
    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "editbook";
        }
        return "redirect:/booklist";
    }
    
    @PostMapping("/editbook")
    public String editBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }


}