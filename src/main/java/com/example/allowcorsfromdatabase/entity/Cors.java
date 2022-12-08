package com.example.allowcorsfromdatabase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "cors")
public class Cors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private boolean isAllowed;
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser appUser;
}
