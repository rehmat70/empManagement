package com.employees.managment;


import com.employees.managment.secureConfigration.UserSecurity;
import com.employees.managment.secureRepositoryConfigration.userSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.employees.managment.Entities", "com.employees.managment.secureConfigration", "com.employees.managment.rController"})
public class ManagmentApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ManagmentApplication.class, args);
	}
@Autowired
	private userSecurityRepository userSecurityRepository;

	@Override
	public void run(String... args) throws Exception {

//		UserSecurity userSecurity1=new UserSecurity();
//		userSecurity1.setUserName("ishaq");
//		userSecurity1.setPassword("$2a$12$uXle/3TrjanGNiqk0hPUAuGROaHA2she4snddM1liZ3XOOl8FzBIK");
//		userSecurity1.setRole("depUser");
//
//        		UserSecurity userSecurity2=new UserSecurity();
//		userSecurity2.setUserName("irfan");
//		userSecurity2.setPassword("$2a$12$4aQb6mfRiEA2pYd6Jd1noOxQOJdkIQwtNKRHqVddXkJJVodtFrsXi");
//		userSecurity2.setRole("empUser");
//
//        		UserSecurity userSecurity3=new UserSecurity();
//		userSecurity3.setUserName("rehMat");
//		userSecurity3.setPassword("$2a$12$i9zpirlWLTTG9nanGGfBO.WZDJsvPyE4EfeKErqy0qwr8zL4JPdaq");
//		userSecurity3.setRole("payrollUser");
//
//		  userSecurityRepository.save(userSecurity1);
//        userSecurityRepository.save(userSecurity2);
//        userSecurityRepository.save(userSecurity3);
	}
}
