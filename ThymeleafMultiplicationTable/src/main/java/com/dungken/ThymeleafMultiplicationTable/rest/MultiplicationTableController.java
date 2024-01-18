package com.dungken.ThymeleafMultiplicationTable.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MultiplicationTableController {
    @GetMapping("/display/{x}")
    public String display(@PathVariable int x, Model model) {
        model.addAttribute("number", x);
        // Return file name thymeleaf
        return "multiplication-table";
    }
}
