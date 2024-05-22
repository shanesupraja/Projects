
package com.Library.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BookAuthors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthors
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String Id;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "bookId")
    private Books books;
    @ManyToOne(cascade =CascadeType.ALL  )
    @JoinColumn(name = "authorId")
    private Authors authors;




}
