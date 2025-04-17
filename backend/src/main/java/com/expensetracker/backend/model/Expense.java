package com.expensetracker.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Expense {

    private String id;
    private String userId;
    private String title;
    private Double amount;
    private String category;
    private Instant date;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public Expense(String userId, String title, Double amount, String category, Instant date) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
}
