package ru.korovin.springExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    public String calc(Model model,
                       @RequestParam("var1") Long var1,
                       @RequestParam("var2") Long var2,
                       @RequestParam("op") String op) {

        switch (op) {
            case "sum":
                model.addAttribute("result",var1 + var2);
                break;
            default:
                model.addAttribute("result","Ошибка");
        }
        return "/calculator/index";
    }

    @GetMapping("/{id}")
    public String calculatorPage(@PathVariable("id") Long id) {
        System.out.printf("Запросили калькулятор версии %d%n", id);
        return "/calculator/index";
    }

}
