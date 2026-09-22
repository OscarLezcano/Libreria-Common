package com.bigobooks.entities.books;

import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.auth.UserAccount;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookCollection extends BaseEntity {

    private String name;

    private String description;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    @OneToMany(mappedBy = "collection")
    private List<BookCollectionDetail> details;
}
