package dev.amit.ProductService;

import dev.amit.ProductService.inheritanceDemo.joinedTable.MentorRepository;
import dev.amit.ProductService.inheritanceDemo.joinedTable.UserRepository;
import dev.amit.ProductService.models.Category;
import dev.amit.ProductService.models.CategoryRepository;
import dev.amit.ProductService.models.Product;
import dev.amit.ProductService.repository.CatogryRepository;
import dev.amit.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {


	private final MentorRepository mentorRepository;

	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductServiceApplication(
			@Qualifier("jt_mr") MentorRepository mentorRepository,
			@Qualifier("jt_ur") UserRepository userRepository,
			ProductRepository productRepository,
			CategoryRepository categoryRepository) {
		this.mentorRepository = mentorRepository;
		this.userRepository = userRepository;

		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("* Jay Shri Ram *");
	}

	@Override
	public void run(String... args) throws Exception {

//		Mentor mentor = new Mentor();
//
//		mentor.setEmail("ami@gmail.com");
//		mentor.setName("amit");
//		mentor.setAverageRating(4.65);
//		mentorRepository.save(mentor);
//
//		User user = new User();
//		user.setName("Amit lkumar");
//		user.setEmail("A123@gmail.com");
//		userRepository.save(user);
//
//		List<User> users = userRepository.findAll();
//		for (User user1 : users) {
//			System.out.println(user1);
//		}
		Category category =new Category();
		category.setName("Apple devices");
		Category saveCatogary=	categoryRepository.save(category);

		Product product = new Product();
		product.setPrice(1200);
		product.setTitle("Iphone 16 Pro");

		product.setDescription("best product ever");

		product.setCategory(saveCatogary);

		productRepository.save(product);

//	Category category1=	categoryRepository.findById(UUID.fromString("\u0001c�\u000F\u0017�I\\�DF-�\u000FjC")).get();  // this string is encrepted that's why creating problem
//
//		System.out.println("category name is : "+category1.getName());
//		System.out.println("printing all product in the category");
//
//		Thread.sleep(1000);
//
//		category1.getProduct().forEach(
//				product1 -> System.out.println(product1.getTitle())
//		);


//		for(Product product1: category1.getProduct()){
//			try{
//				System.out.println(product1.getTitle());
//			}
//			catch (Exception e){
//				System.out.println(e.getMessage());
//			}
//
//		}


	}
}
