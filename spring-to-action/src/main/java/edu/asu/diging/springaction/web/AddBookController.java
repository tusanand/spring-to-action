package edu.asu.diging.springaction.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.asu.diging.springaction.core.model.impl.BookImpl;
import edu.asu.diging.springaction.core.service.impl.BookManager;

@Controller
public class AddBookController {

    @Autowired
    private BookManager bookManager;
    
    @RequestMapping(value="admin/book/add", method=RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("book", new BookImpl());
        return "admin/books/add";
    }
    
    @RequestMapping(value="admin/book/add", method=RequestMethod.POST)
    public String add(@ModelAttribute("book") BookImpl book) {
        bookManager.store(book.getAuthor(), book.getTitle());
        return "redirect:/admin/book/add";
    }
}