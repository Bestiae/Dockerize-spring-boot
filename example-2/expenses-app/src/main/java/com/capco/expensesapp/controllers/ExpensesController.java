package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.ExpensesDTO;
import com.capco.expensesapp.services.ExpensesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("expenses")
public class ExpensesController {

    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExpensesDTO>> getAllExpenses() {
        log.info("List of all expenses -> expensesService.getAllExpenses();");
        return ResponseEntity.ok().body(expensesService.getAllExpenses());
    }

    @GetMapping("/find-payer/{id}")
    public ResponseEntity<List<ExpensesDTO>> findExpensesByPayerId(@PathVariable(value = "id") Long id) {
        log.info("expensesService.findExpensesByPayerId({});", id);
        return ResponseEntity.ok().body(expensesService.findExpensesByPayerId(id));
    }

    @GetMapping("/find-category/{category}")
    public ResponseEntity<List<ExpensesDTO>> findExpensesByCategory(@PathVariable(value = "category") String category) {
        log.info("expensesService.findExpensesByCategory({}});", category);
        return ResponseEntity.ok().body(expensesService.findExpensesByCategory(category));
    }

    @GetMapping("/find-split-type/{split-type}")
    public ResponseEntity<List<ExpensesDTO>> findExpensesBySplitType(@PathVariable(value = "split-type") String splitType) {
        log.info("expensesService.findExpensesBySplitType({}});", splitType);
        return ResponseEntity.ok().body(expensesService.findExpensesBySplitType(splitType));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExpensesById(@PathVariable(value = "id") Long id) {
        log.info("expensesService.deleteExpensesById({});", id);
        try {
            expensesService.deleteExpensesById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ExpensesDTO> addExpenses(@RequestBody @Valid ExpensesDTO expenses) {
        log.info("expensesService.addExpenses({});", expenses);
        return ResponseEntity.ok().body(expensesService.addExpenses(expenses));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpensesDTO> updateExpenses(@RequestBody ExpensesDTO expenses, @PathVariable("id") Long id) {
        log.info("expensesService.updateExpensesById(id, expenses);");
        return ResponseEntity.ok().body(expensesService.updateExpensesById(id, expenses));
    }
}