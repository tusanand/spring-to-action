package edu.asu.diging.springaction.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.asu.diging.simpleusers.core.service.IUserManager;
import edu.asu.diging.springaction.core.model.impl.Book;
import edu.asu.diging.springaction.core.service.impl.BookManager;

@Controller
public class BorrowBookController {

    @Autowired
    private BookManager bookManager;
    
    @Autowired
    private IUserManager userManager;
    
    @RequestMapping(value="/auth/book/{bookId}/borrow", method=RequestMethod.POST)
    public String borrow(@PathVariable("bookId") String bookId, Principal principal, RedirectAttributes redirectAttrs) {
        Book book = bookManager.get(Long.parseLong(bookId));
        if (book != null) {
            if (book.isAvailable()) {
                bookManager.borrow(userManager.findByUsername(principal.getName()), book);
                redirectAttrs.addFlashAttribute("msg", "Book succesfully borrowed.");
            } else  {
                redirectAttrs.addFlashAttribute("msg", "Book has already been borrowed.");
            }
        }
        return "redirect:/";
    }
}