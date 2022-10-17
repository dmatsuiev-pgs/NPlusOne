package com.denmats.nplusone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private List<Address> address;
}
