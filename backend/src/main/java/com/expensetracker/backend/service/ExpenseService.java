package com.expensetracker.backend.service;

import com.expensetracker.backend.model.Expense;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Service
public class ExpenseService {

    private final DynamoDbTable<Expense> expenseTable;

    public ExpenseService(DynamoDbEnhancedClient enhancedClient) {
        this.expenseTable = enhancedClient.table("Expenses", TableSchema.fromBean(Expense.class));
    }

    public void saveExpense(Expense expense) {
        expenseTable.putItem(expense);
    }
}
