package dev.amit.ProductService;

import dev.amit.ProductService.inheritanceDemo.joinedTable.Mentor;
import dev.amit.ProductService.inheritanceDemo.joinedTable.MentorRepository;
import dev.amit.ProductService.inheritanceDemo.joinedTable.User;
import dev.amit.ProductService.inheritanceDemo.joinedTable.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {


	private final MentorRepository mentorRepository;

	private final UserRepository userRepository;

	public ProductServiceApplication(
			@Qualifier("jt_mr") MentorRepository mentorRepository,
			@Qualifier("jt_ur") UserRepository userRepository) {
		this.mentorRepository = mentorRepository;
		this.userRepository = userRepository;

	}
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("* Jay Shri Ram *");
	}

	@Override
	public void run(String... args) throws Exception {
		Mentor mentor = new Mentor();

		mentor.setEmail("ami@gmail.com");
		mentor.setName("amit");
		mentor.setAverageRating(4.65);
		mentorRepository.save(mentor);

		User user = new User();
		user.setName("Amit lkumar");
		user.setEmail("A123@gmail.com");
		userRepository.save(user);

		List<User> users = userRepository.findAll();
		for (User user1 : users) {
			System.out.println(user1);
		}
	}
}
