package com.mutuus;


import com.mutuus.auth.AuthenticationService;
import com.mutuus.auth.RegisterRequest;
import com.mutuus.model.Company;
import com.mutuus.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
			AuthenticationService service, CompanyRepository companyRepository
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
