


package com.Library.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity


@Table(name = "Books")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Books
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String bookId;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author")

    private  Authors author;
    private String Isbn ;
    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name  = "genreId")
    private Genres genres;
    private int  publicationYear;
    private long quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisherId")
    private  Publisher publisher;
    @OneToOne(mappedBy = "books")
    //  @JoinColumn()
    private BookAuthors bookAuthors;


}

