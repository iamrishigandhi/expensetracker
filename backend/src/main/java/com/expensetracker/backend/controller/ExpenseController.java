package com.expensetracker.backend.controller;

import com.expensetracker.backend.model.Expense;
import com.expensetracker.backend.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<String> createExpense(@RequestBody Expense request) {
        Expense expense = new Expense(
                request.getUserId(),
                request.getTitle(),
                request.getAmount(),
                request.getCategory(),
                request.getDate() != null ? request.getDate() : LocalDateTime.now()
        );
        expenseService.saveExpense(expense);
        return ResponseEntity.ok("Expense saved!");
    }
}
