package com.tbb.TheBlueBasil;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component @Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner  implements CommandLineRunner {
//    ReservationService reservationService;
//    static final String PASSWORD
//

    @Override
    public void run(String... args) throws Exception {

    }
}
