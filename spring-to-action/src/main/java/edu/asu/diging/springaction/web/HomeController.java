package edu.asu.diging.springaction.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.springaction.core.service.impl.BookManager;

@Controller
public class HomeController {
	
	@Autowired
    private BookManager bookManager;

	@RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("books", bookManager.all());
        return "home";
    }
}