package com.mutuus;


import com.mutuus.auth.AuthenticationService;
import com.mutuus.auth.RegisterRequest;
import com.mutuus.model.Car;
import com.mutuus.model.Company;
import com.mutuus.model.Location;
import com.mutuus.model.Travel;
import com.mutuus.repository.*;
import java.time.LocalDateTime;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static com.mutuus.enums.Role.ADMIN;
import static com.mutuus.enums.Role.MANAGER;


@SpringBootApplication
public class MutuusApplication {

  public static void main(String[] args) {
    SpringApplication.run(MutuusApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public CommandLineRunner commandLineRunner(
      AuthenticationService service,
      CompanyRepository companyRepository,
      CarRepository carRepository,
      LocationRepository locationRepository,
      TravelRepository travelRepository,
      TravelRepository travelRepository2,
      UserRepository userRepository
  ) {
    return args -> {

      var company = new Company();
      company.setName("Mutuus .CO");

      var companyObj = companyRepository.save(company);

      var admin = RegisterRequest.builder()
          .firstname("Admin")
          .lastname("Admin")
          .email("admin@mail.com")
          .password("password")
          .role(ADMIN)
          .company(companyObj)
          .build();

      System.out.println("Admin token: " + service.register(admin).getAccessToken());

      var user = userRepository.findByEmail(admin.getEmail()).get();

      var users = userRepository.findAll();

      var car = new Car();
      car.setPilot(user);
      car.setPassengers(users);
      car.setPlate("MKJ12345");
      car.setModel("Sentra");
      car.setPassengersLimit(3L);

      var car1 = carRepository.save(car);
      System.out.println("Car plate: " + car1.getPlate());

      var origin = new Location();
      origin.setLatitude(Double.valueOf("-27.430223"));
      origin.setLongitude(Double.valueOf("-48.425593"));
      origin.setAltitude(0L);
      origin.setAccuracy(20L);
      origin.setHeading(0L);
      origin.setSpeed(0L);
      origin.setAltitudeAccuracy(0L);

      var destiny = new Location();
      destiny.setLatitude(Double.valueOf("-27.548249"));
      destiny.setLongitude(Double.valueOf("-48.499096"));
      destiny.setAltitude(0L);
      destiny.setAccuracy(20L);
      destiny.setHeading(0L);
      destiny.setSpeed(0L);
      destiny.setAltitudeAccuracy(0L);

      var origin1 = locationRepository.save(origin);

      var destiny1 = locationRepository.save(destiny);

      var travel = new Travel();

      travel.setCar(car1);
      travel.setDestiny(destiny1);
      travel.setOrigin(origin1);
      travel.setDateTime(LocalDateTime.now());

      var travel1 = travelRepository.save(travel);
      var travel2 = travelRepository2.save(travel);

      System.out.println("Travel: " + travel1.getId());
      System.out.println("Travel: " + travel2.getId());

      var manager = RegisterRequest.builder()
          .firstname("Admin")
          .lastname("Admin")
          .email("manager@mail.com")
          .password("password")
          .role(MANAGER)
          .company(companyObj)
          .build();
      System.out.println("Manager token: " + service.register(manager).getAccessToken());

    };
  }
}
