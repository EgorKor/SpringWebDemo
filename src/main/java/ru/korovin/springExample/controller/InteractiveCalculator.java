package ru.korovin.springExample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.korovin.springExample.model.CalcModel;
import ru.korovin.springExample.model.CalcOperation;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/interactive/calculator")
public class InteractiveCalculator {
    private List<CalcOperation> calcOperations = new ArrayList<>();

    {
        calcOperations.add(new CalcOperation("Сложение", "add"));
        calcOperations.add(new CalcOperation("Вычитание", "sub"));
        calcOperations.add(new CalcOperation("Умножение","mult"));
    }


    @GetMapping
    public String calcPage(Model model) {
        model.addAttribute("calcModel", new CalcModel(0, 0, ""));
        model.addAttribute("calcOperations", calcOperations);
        model.addAttribute("hasResult",false);
        return "/calculator/interactive";
    }

    @PostMapping
    public String calcPageResult(Model model,
                                 @RequestBody
                                 @ModelAttribute("calcModel")
                                 CalcModel calcModel
    ) {
        System.out.println(calcModel);
        model.addAttribute("calcOperations", calcOperations);
        int result = 0;
        switch (calcModel.getOperation()){
            case "add":
                result = calcModel.getNum1() + calcModel.getNum2();
                break;
            case "sub":
                result = calcModel.getNum1() - calcModel.getNum2();
                break;
            case "mult":
                result = calcModel.getNum1() * calcModel.getNum2();
                break;
        }
        model.addAttribute("result",result);
        model.addAttribute("hasResult",true);

        return "/calculator/interactive";
    }

}
