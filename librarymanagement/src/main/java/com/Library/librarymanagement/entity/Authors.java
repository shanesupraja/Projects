
        package com.Library.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "Authors")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Authors
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private String authorId;
    private String authorName;


}

