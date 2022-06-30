package com.tbb.TheBlueBasil.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
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



    @NonNull
    @Column(name = "username")
    String username;
    @Id
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations = new LinkedHashSet<>();

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinTable(name = "users_reservations",
//            joinColumns = @JoinColumn(name = "user_null"),
//            inverseJoinColumns = @JoinColumn(name = "reservations_null"))
//    private Set<Reservation> reservations = new LinkedHashSet<>();

    public User( @NonNull String username, @NonNull String email, @NonNull String password, @NonNull boolean isManager, @NonNull boolean isCustomer, @NonNull boolean isEmployee, Reservation reservation, Set<AuthGroup> authGroups, Menu menu) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.isManager = isManager;
        this.isCustomer = isCustomer;
        this.isEmployee = isEmployee;
//        this.reservation = reservation;
//        this.authGroups = authGroups;
        this.menu = menu;
    }
//    @NonNull
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "reservation_id")
//    private Reservation reservation;

//    @NonNull
//    @ManyToMany
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_null"),
//            inverseJoinColumns = @JoinColumn(name = "roles_null"))
//    private Set<AuthGroup> authGroups = new LinkedHashSet<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "menu_id")
    private Menu menu;


    //Helper Method

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setUser(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isManager == user.isManager && isCustomer == user.isCustomer && isEmployee == user.isEmployee && username.equals(user.username) && email.equals(user.email) && password.equals(user.password) && Objects.equals(reservations, user.reservations) && menu.equals(user.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password, isManager, isCustomer, isEmployee, reservations, menu);
    }
}
