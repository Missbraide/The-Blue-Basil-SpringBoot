package com.tbb.TheBlueBasil.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name ="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NonNull
    @Column(name = "username")
    String username;

    @NonNull
    @Column(name = "email")
    String email;

    @NonNull
    @Column(name = "password")
    String password;

    @NonNull
    @Column(name = "role")
    boolean isManager;

    @NonNull
    boolean isCustomer;
    @NonNull
    boolean isEmployee;

    public User(long id, @NonNull String username, @NonNull String email, @NonNull String password, @NonNull boolean isManager, @NonNull boolean isCustomer, @NonNull boolean isEmployee, Reservation reservation, Set<AuthGroup> authGroups, Menu menu) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isManager = isManager;
        this.isCustomer = isCustomer;
        this.isEmployee = isEmployee;
        this.reservation = reservation;
//        this.authGroups = authGroups;
        this.menu = menu;
    }
    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

//    @NonNull
//    @ManyToMany
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_null"),
//            inverseJoinColumns = @JoinColumn(name = "roles_null"))
//    private Set<AuthGroup> authGroups = new LinkedHashSet<>();
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "menu_id")
    private Menu menu;


    //Helper Method


}
