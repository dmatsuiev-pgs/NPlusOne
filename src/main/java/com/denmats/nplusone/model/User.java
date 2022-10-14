package com.denmats.nplusone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String username;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Address> address;
}
