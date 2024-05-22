package com.Library.librarymanagement.entity;

import lombok.Data;

@Data

public class TransactionCreation
{
    private String  memberId;
    private String  bookId;



    private String transactionType;
}
