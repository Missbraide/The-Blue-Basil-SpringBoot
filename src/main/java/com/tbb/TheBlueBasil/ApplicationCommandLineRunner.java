package com.tbb.TheBlueBasil;

import com.tbb.TheBlueBasil.data.*;
import com.tbb.TheBlueBasil.models.*;
import com.tbb.TheBlueBasil.services.ReservationService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    ItemRepository itemRepository;

    public ApplicationCommandLineRunner(ReservationRepository reservationRepository, AuthGroupRepository authGroupRepository, UserRepository userRepository, MenuRepository menuRepository, ItemRepository itemRepository) {
        this.reservationRepository = reservationRepository;
        this.authGroupRepository = authGroupRepository;
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
        this.itemRepository = itemRepository;
    }

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
    static String PASSWORD = encoder.encode("password");


    static final  String ELLAID = "ella@gmail.com";
    static final  String BROOKEID ="brooke@gmail.com";
    static final  String LOLAID ="lola@gmail.com";
    static final  String JAXID = "jax@gmail.com";
    static final  String ARITID = "arit@gmail.com";
    static final  String JOYID = "joy@gmail.com";
    static final  String ROLE_ADMIN = "ROLE_ADMIN";
    static final  String ROLE_USER = "ROLE_USER";


    @PostConstruct
    public void postConstruct(){
        log.warn("============ Application CommandLine Runner ============");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.of(00, 00, 00);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User("Ella", "Braide",ELLAID, PASSWORD ));
        userRepository.save(new User("Brooke", "Davis", BROOKEID, PASSWORD));
        userRepository.save(new User("Lola",  "Oredola",LOLAID, PASSWORD ));
        userRepository.save(new User("Jax", "Teller", JAXID, PASSWORD ));
        userRepository.save(new User("Arit", "Jack", ARITID, PASSWORD ));
        userRepository.save(new User("Joy", "Rex", JOYID, PASSWORD ));

        authGroupRepository.save(new AuthGroup(ELLAID, ROLE_ADMIN));
        authGroupRepository.save(new AuthGroup(ELLAID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(BROOKEID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(LOLAID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(JAXID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(ARITID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(JOYID, ROLE_USER));




        reservationRepository.save(new Reservation("Ella","Braide", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "ella@gmail.com", "4", "Table by the window"));
        reservationRepository.save(new Reservation("Lola","Oredola", LocalDate.now(), LocalTime.of(15,00,00), "1234567890", "lola@gmail.com", "2", "Need high chair for baby"));
        reservationRepository.save(new Reservation("Arit","Jack", LocalDate.now(), LocalTime.of(11,30,00),"1234567890", "arit@gmail.com", "6", "Table by the window"));
        reservationRepository.save(new Reservation("Jax","Teller", LocalDate.now(),LocalTime.of(20,00,00), "1234567890", "jax@gmail.com", "2", "By the bar"));
        reservationRepository.save(new Reservation("Joy","Rex", LocalDate.now(),LocalTime.of(14,15,00), "1234567890", "joy@gmail.com", "2", "Candles"));

        menuRepository.save(new Menu("Breakfast", "Avocado Cranberry Toast"));
        menuRepository.save(new Menu("Breakfast", "Smoked Salmon"));
        menuRepository.save(new Menu("Breakfast", "Lavender Maple Pancakes"));
        menuRepository.save(new Menu("Breakfast", "Steak & Eggs"));
        menuRepository.save(new Menu("Lunch", "Chopped Salad"));
        menuRepository.save(new Menu("Lunch", "Fried Chicken"));
        menuRepository.save(new Menu("Lunch", "House Special Burger"));
        menuRepository.save(new Menu("Lunch", "Warm Grain Bowl"));
        menuRepository.save(new Menu("Dinner", "Pan Roasted Alaskan Halibut"));
        menuRepository.save(new Menu("Dinner", "Grilled Mishima Ranch Beef Bavette"));
        menuRepository.save(new Menu("Dinner", "Ratatouille"));
        menuRepository.save(new Menu("Dinner", "Seafood Pasta"));
        menuRepository.save(new Menu("Dinner", "Pan Roasted Chicken"));
        menuRepository.save(new Menu("Dessert", "Coconut Tapioca"));
        menuRepository.save(new Menu("Dessert", "House Ricotta Cheese"));
        menuRepository.save(new Menu("Dessert", "Spiced Carrot Pistachio Cake"));
        menuRepository.save(new Menu("Dessert", "Cherry Pie a la Mode"));
        menuRepository.save(new Menu("Cocktail", "Espresso Martini"));
        menuRepository.save(new Menu("Cocktail", "Vesper"));
        menuRepository.save(new Menu("Cocktail", "Uptown Manhattan"));
        menuRepository.save(new Menu("Cocktail", "Pina Colada"));



        itemRepository.save(new Item("Avocado Cranberry Toast", "Whole Grain Toast, Avocado, Cranberry Sauce, Choice of Bacon, Breakfast Sausage or Chicken Sausage", 10.99, true));
        itemRepository.save(new Item("Smoked Salmon", "Acme Smoked Salmon, Spring Onion Crème Fraîche, Sesame Seeds, Poppy Seeds, Pickled Red Onion", 35.00, true));
        itemRepository.save(new Item("Lavender Maple Pancakes", "Whole Grain Pancake, Lavender Chutney, Maple Syrup", 10.99, true));
        itemRepository.save(new Item("Steak & Eggs", "7oz Hanger Steak, Gremolata, Scrambled Eggs, Cheddar, Long Island Home Fries, Toast", 36.50, true));
        itemRepository.save(new Item("Chopped Salad", "Grilled Spring Veggies, Narragansett Feta, 6 Minute Egg, Crouton, Green Goddess", 13.99, true));
        itemRepository.save(new Item("Fried Chicken", "7oz Hanger Steak, Gremolata, Scrambled Eggs, Cheddar, Long Island Home Fries, Toast", 15.99, false));
        itemRepository.save(new Item("House Special Burger", "Two Patties, Cheddar Cheese, Special Sauce, B&B Pickles, Sesame “Big Marties” Bun", 18.99, true));
        itemRepository.save(new Item("Warm Grain Bowl", "Brown & Wild Rice, Grilled Snap Peas, Spring Radishes, Cucumbers, Pepita Romesco, Choice of Smoked Salmon or Roast Turkey", 19.99, true));
        itemRepository.save(new Item("Pan Roasted Alaskan Halibut", "Chowder Sauce, Manila Clams, Potato Parisienne, Applewood smoked bacon", 25.99, false));
        itemRepository.save(new Item("Grilled Mishima Ranch Beef Bavette", "Bone Marrow Potato Gratin, Local Asparagus, Herbed Bordelaise Vinaigrette", 12.99, true));
        itemRepository.save(new Item("Ratatouille", "Eggplant, Summer squash, Tomato conserva", 15.99, false));
        itemRepository.save(new Item("Seafood Pasta", "Freshly made Spaghetti, Clams, scallop, shrimp, *bacon, garlic, mama lil's peppers, parsley, white wine, butter *can be prepared without bacon", 22.99, false));
        itemRepository.save(new Item("Pan Roasted Chicken", "Asparagus, roasted Yukon gold potatoes, sauce Robert", 15.99, true));
        itemRepository.save(new Item("Coconut Tapioca", "Erum glazed pineapple, makrut lime ice cream", 11.99, false));
        itemRepository.save(new Item("House Ricotta Cheese", "stone fruit relish, hazelnut, eckholm farm honey", 13.99, true));
        itemRepository.save(new Item("Spiced Carrot Pistachio Cake", "Rose cream cheese, carrot cake, aged dried fruit", 11.99, false));
        itemRepository.save(new Item("Cherry Pie a la Mode", "Freshly made cherry pie, Vanilla bean ice cream", 8.99, true));
        itemRepository.save(new Item("Espresso Martini", "Espresso, creme de cacao, vodka, coffee liqueur, dash of cream and house made chocolate sauce", 11.99, true));
        itemRepository.save(new Item("Vesper", "Vodka, London dry gin, lillet blanc, lemon twist", 11.99, true));
        itemRepository.save(new Item("Uptown Manhattan", "Bourbon, Antica formula, orange bitters, brandied cherry juice, orange peel", 15.99, true));
        itemRepository.save(new Item("Pina Colada", "Rum, Freshly made pineapple juice & coconut cream", 12.99, true));

    }


}
