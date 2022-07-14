package ru.alon.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.alon.entity.Counterparty;
import ru.alon.service.CounterpartyService;

import java.util.List;

@Controller
@RequestMapping("/counterparties")
public class CounterpartyController {

    private final CounterpartyService counterpartyService;

    @Autowired
    public CounterpartyController(CounterpartyService counterpartyService) {
        this.counterpartyService = counterpartyService;
    }

    @GetMapping()
    public String findAll(Model model) {
        List<Counterparty> counterparties = counterpartyService.findAll();
        model.addAttribute("counterparties", counterparties);
        return "counterparties/directory";
    }

    @GetMapping("/new")
    public String createCounterpartyForm(@ModelAttribute("counterparty") Counterparty counterparty) {
        return "counterparties/new";
    }

    @PostMapping("/new")
    public String createCounterparty(@Validated @ModelAttribute("counterparty") Counterparty counterparty, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "counterparties/new";
        }
        counterpartyService.saveCounterparty(counterparty);
        return "redirect:/counterparties";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("counterparty", counterpartyService.findById(id));
        return "counterparties/edit";
    }

    @PostMapping("/{id}")
    public String update(@Validated @ModelAttribute("counterparty") Counterparty counterparty, BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "counterparties/edit";
        }
        counterpartyService.saveCounterparty(counterparty);
        return "redirect:/counterparties";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        counterpartyService.deleteCounterparty(counterpartyService.findById(id));
        return "redirect:/counterparties";
    }


}

