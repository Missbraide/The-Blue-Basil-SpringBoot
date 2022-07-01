package com.tbb.TheBlueBasil.models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NonNull
    @Column(name ="first_name")
    String resFirstName;

@NonNull
    @Column(name ="last_name")
    String resLastName;

@NonNull
    @Column(name ="reserved_date")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    LocalDate resDate;

    @NonNull
    @Column(name = "reserved_time")
    @DateTimeFormat(pattern = "hh:mm:ss")
    LocalTime resTime;


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
@Column(name = "additional_info")
    String addInfo;

    public Reservation(long id, @NonNull String resFirstName, @NonNull String resLastName, @NonNull LocalDate resDate, @NonNull LocalTime resTime, @NonNull String resPhone, @NonNull String resEmail, @NonNull String resNoOfGuests, @NonNull String addInfo) {
        this.id = id;
        this.resFirstName = resFirstName;
        this.resLastName = resLastName;
        this.resDate = resDate;
        this.resTime = resTime;
        this.resPhone = resPhone;
        this.resEmail = resEmail;
        this.resNoOfGuests = resNoOfGuests;
        this.addInfo = addInfo;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id && resFirstName.equals(that.resFirstName) && resLastName.equals(that.resLastName) && resDate.equals(that.resDate) && resTime.equals(that.resTime) && resPhone.equals(that.resPhone) && resEmail.equals(that.resEmail) && resNoOfGuests.equals(that.resNoOfGuests) && addInfo.equals(that.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resFirstName, resLastName, resDate, resTime, resPhone, resEmail, resNoOfGuests, addInfo);
    }


    //    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinColumn(name = "user_email")
//    User user;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Reservation that = (Reservation) o;
//        return id == that.id && resFirstName.equals(that.resFirstName) && resLastName.equals(that.resLastName) && resDate.equals(that.resDate) && resTime.equals(that.resTime) && resPhone.equals(that.resPhone) && resEmail.equals(that.resEmail) && resNoOfGuests.equals(that.resNoOfGuests) && addInfo.equals(that.addInfo) && Objects.equals(user, that.user);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, resFirstName, resLastName, resDate, resTime, resPhone, resEmail, resNoOfGuests, addInfo, user);
//    }
}
