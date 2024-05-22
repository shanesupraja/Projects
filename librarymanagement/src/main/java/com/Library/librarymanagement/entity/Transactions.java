package com.Library.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "Transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Transactions
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String transactionId;
    @ManyToOne
    @JoinColumn(name = " bookId")
    private Books book;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Members members;

    private String transactionType;
    private Date dueDate;
    private Date returnDate;


}
