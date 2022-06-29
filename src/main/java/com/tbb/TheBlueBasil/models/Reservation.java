package com.tbb.TheBlueBasil.models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
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

//
//@NamedNativeQuery(name = "Reservation.findReservations", query = "select r.first_name, r.last_name, r.email, r.no_of_guests, r.phone_num from reservations as r join users on u.id= ")
//

@Entity
@Table(name ="reservations")
public class Reservation {

    @Id @GeneratedValue
    long id;

    @NonNull
    @Column(name ="first_name")
    String resFirstName;

    @NonNull
    @Column(name ="last_name")
    String resLastName;

    @NonNull
    @Column(name ="reserved_date")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    Date resDate;

//    @NonNull
//    @Column(name = "reserved_time")
//    @DateTimeFormat
//

    @NonNull
    @Column(name ="phone_num")
    String resPhone;

    @NonNull
    @Column(name ="email")
    String resEmail;

    @NonNull
    @Column(name ="no_of_guests")
    String resNoOfGuests;


    @NonNull
@Column(name = "addtl_info")
    String addInfo;

    @OneToMany(mappedBy = "reservation", orphanRemoval = true)
    private Set<User> users = new LinkedHashSet<>();

    public Reservation(String ellaid, String ella, String password) {
    }
}
