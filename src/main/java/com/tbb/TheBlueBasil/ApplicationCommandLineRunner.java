package com.tbb.TheBlueBasil;

import com.tbb.TheBlueBasil.data.*;
import com.tbb.TheBlueBasil.models.Item;
import com.tbb.TheBlueBasil.models.Menu;
import com.tbb.TheBlueBasil.models.Reservation;
import com.tbb.TheBlueBasil.models.User;
import com.tbb.TheBlueBasil.services.MenuService;
import com.tbb.TheBlueBasil.services.ReservationService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import static java.util.Calendar.AM_PM;
import static java.util.Calendar.PM;

@Component @Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner  implements CommandLineRunner {

    ReservationRepository reservationRepository;
    AuthGroupRepository authGroupRepository;
    UserRepository   userRepository;
    MenuRepository menuRepository;
    MenuService menuService;
    ItemRepository itemRepository;

    public ApplicationCommandLineRunner(ReservationRepository reservationRepository, AuthGroupRepository authGroupRepository, UserRepository userRepository, MenuRepository menuRepository, MenuService menuService, ItemRepository itemRepository) {
        this.reservationRepository = reservationRepository;
        this.authGroupRepository = authGroupRepository;
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
        this.menuService = menuService;
        this.itemRepository = itemRepository;
    }

    //    static final  String PASSWORD = "password";
//    static final  String ELLAID = "ella@gmail.com";
//    static final  String BROOKEID ="brooke@gmail.com";
//    static final  String JAXID = "jax@gmail.com";
//    static final  String ROLE_ADMIN = "ROLE_ADMIN";
//    static final  String ROLE_USER = "ROLE_USER";


    @PostConstruct
    public void postConstruct(){
        log.warn("============ Application CommandLine Runner ============");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.of(00, 00, 00);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User("Ella", "Braide","ella@gmail.com", "password" ));
        userRepository.save(new User("Lola",  "Oredola","lola@gmail.com", "password" ));
        userRepository.save(new User("Jax", "Teller", "jax@gmail.com", "password"));
        userRepository.save(new User("Arit", "Jack", "arit@gmail.com", "password"));
        userRepository.save(new User("Joy", "Rex", "joy@gmail.com", "password"));


        reservationRepository.save(new Reservation(1L,"Ella","Braide", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "ella@gmail.com", "4", "Table by the window"));
        reservationRepository.save(new Reservation("Lola","Oredola", LocalDate.now(), LocalTime.of(15,00,00), "1234567890", "lola@gmail.com", "2", "Need high chair for baby"));
        reservationRepository.save(new Reservation("Arit","Jack", LocalDate.now(), LocalTime.of(11,30,00),"1234567890", "arit@gmail.com", "6", "Table by the window"));
        reservationRepository.save(new Reservation("Jax","Teller", LocalDate.now(),LocalTime.of(20,00,00), "1234567890", "jax@gmail.com", "2", "By the bar"));
        reservationRepository.save(new Reservation("Joy","Rex", LocalDate.now(),LocalTime.of(14,15,00), "1234567890", "joy@gmail.com", "2", "Candles"));
        reservationRepository.save(new Reservation("Mary","Joe", LocalDate.now(), LocalTime.of(12,00,00), "123457890", "mary@gmail.com", "4", "table"));



        menuRepository.save(new Menu("breakfast", "bread"));

        itemRepository.save(new Item("Avocado salad", "avocado", 6.99, true));
//        menuService.addItemToMenu(1,1);

    }
}
