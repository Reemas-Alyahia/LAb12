package com.example.lab12.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    @NotEmpty
    private String title;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    @NotEmpty
    private String body;

    @ManyToOne
    @JsonIgnore
    private MyUser user;
}
