package edu.asu.diging.springaction.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.asu.diging.simpleusers.core.service.IUserManager;
import edu.asu.diging.springaction.core.model.impl.Book;
import edu.asu.diging.springaction.core.service.impl.BookManager;

@Controller
public class ReturnBookController {
	
	@Autowired
    private BookManager bookManager;
	
	@Autowired
    private IUserManager userManager;
	
	@RequestMapping(value = "/borrowedBooksList")
    public String borrowedBooksList(Model model, Principal principal) {
        model.addAttribute("borrowedBooks", bookManager.findByUser(userManager.findByUsername(principal.getName())));
        return "admin/borrowedBooks/borrowedBooksList";
    }
	
	@RequestMapping(value="/auth/book/{bookId}/return", method=RequestMethod.POST)
    public String borrow(@PathVariable("bookId") String bookId, Principal principal, RedirectAttributes redirectAttrs) {
        Book book = bookManager.get(Long.parseLong(bookId));
        if (book != null) {
            if (!book.isAvailable()) {
                bookManager.returnBook(userManager.findByUsername(principal.getName()), book);
                redirectAttrs.addFlashAttribute("msg", "Book succesfully returned.");
            } else  {
                redirectAttrs.addFlashAttribute("msg", "Book was never borrowed.");
            }
        }
        return "redirect:/borrowedBooksList";
    }
	
}
