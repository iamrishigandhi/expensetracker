package com.expensetracker.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@DynamoDbBean
public class Expense {

    private String id;
    private String userId;
    private String title;
    private Double amount;
    private String category;
    private LocalDateTime date;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public Expense(String userId, String title, Double amount, String category, LocalDateTime date) {
        this.id = UUID.randomUUID().toString(); // ID is auto-generated
        this.userId = userId;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
}
