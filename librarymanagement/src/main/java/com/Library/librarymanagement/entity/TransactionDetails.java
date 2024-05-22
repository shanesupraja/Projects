
package com.Library.librarymanagement.entity;

import lombok.Data;

import java.util.Date;

@Data

public class TransactionDetails
{
    private String  bookId;
    private String memberId;
    private String  transactionId;
    private String transactionType;
    private Date dueDate;
    private Date returnDate;


}

