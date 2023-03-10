package com.yan.dynamotest.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@DynamoDBDocument
@DynamoDBTable(tableName = "product")
@Accessors(chain = true)
public class Product {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String userUid;
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private int price;
    @DynamoDBAttribute
    private int stock;
    @DynamoDBAttribute
    private Address address;

}
