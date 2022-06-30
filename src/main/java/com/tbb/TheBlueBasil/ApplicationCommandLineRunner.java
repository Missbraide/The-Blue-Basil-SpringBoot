package com.tbb.TheBlueBasil;

import com.tbb.TheBlueBasil.data.AuthGroupRepository;
import com.tbb.TheBlueBasil.data.MenuRepository;
import com.tbb.TheBlueBasil.data.UserRepository;
import com.tbb.TheBlueBasil.models.AuthGroup;
import com.tbb.TheBlueBasil.models.Menu;
import com.tbb.TheBlueBasil.models.Reservation;
import com.tbb.TheBlueBasil.models.User;
import com.tbb.TheBlueBasil.services.ReservationService;
import com.tbb.TheBlueBasil.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component @Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner  implements CommandLineRunner {
    ReservationService reservationService;
    AuthGroupRepository authGroupRepository;
    UserRepository   userRepository;
    MenuRepository menuRepository;

    public ApplicationCommandLineRunner(ReservationService reservationService, AuthGroupRepository authGroupRepository, UserRepository userRepository, MenuRepository menuRepository) {
        this.reservationService = reservationService;
        this.authGroupRepository = authGroupRepository;
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
    }

    static final  String PASSWORD = "password";
    static final  String ELLAID = "ella@gmail.com";
    static final  String BROOKEID ="brooke@gmail.com";
    static final  String JAXID = "jax@gmail.com";
    static final  String ROLE_ADMIN = "ROLE_ADMIN";
    static final  String ROLE_USER = "ROLE_USER";

    @PostConstruct
    public void postConstruct(){
        log.warn("============ Application CommandLine Runner ============");
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User("username", "abc@aol.com", "password", true, true, true));
        userRepository.save(new User("username", "lola@gmail.com", "password", true, true, true));


    }
}
