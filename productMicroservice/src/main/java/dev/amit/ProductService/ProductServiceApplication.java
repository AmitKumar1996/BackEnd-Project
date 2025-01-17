package dev.amit.ProductService;

import dev.amit.ProductService.inheritanceDemo.joinedTable.MentorRepository;
import dev.amit.ProductService.inheritanceDemo.joinedTable.UserRepository;
import dev.amit.ProductService.models.Category;
import dev.amit.ProductService.models.Price;
import dev.amit.ProductService.models.Product;
import dev.amit.ProductService.repository.CategoryRepository;
import dev.amit.ProductService.repository.PriceRepository;
import dev.amit.ProductService.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "dev.amit.ProductService.repositories")
@EnableAutoConfiguration
public class ProductServiceApplication  implements CommandLineRunner {


	private final MentorRepository mentorRepository;

	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private  final PriceRepository priceRepository;


	public ProductServiceApplication(
            @Qualifier("jt_mr") MentorRepository mentorRepository,
            @Qualifier("jt_ur") UserRepository userRepository,
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
             PriceRepository priceRepository) {
		this.mentorRepository = mentorRepository;
		this.userRepository = userRepository;

		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }


	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("* Jay Shri Ram *");
	}

	@Transactional
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

//


		Category category =new Category();
		category.setName("Apple devices");
		 Category saveCatogary=	categoryRepository.save(category);

	Price price = new Price("Rupee", 10);
		Price savedPriceDb = priceRepository.save(price);

		Product product = new Product();

		product.setTitle("Iphone 16 Pro");


		//	productRepository.deleteById(UUID.fromString(""));


		product.setDescription("best product ever");

		product.setCategory(saveCatogary);
		product.setPrice(savedPriceDb);

		productRepository.save(product);



//		// Save Category
//		Category category = new Category();
//		category.setName("Apple devices");
//		Category savedCategory = categoryRepository.save(category);
//	//	LOGGER.info("Saved Category: {}", savedCategory);
//
//		// Save Price
//		Price price = new Price("Rupee", 10);
//		Price savedPrice = priceRepository.save(price);
//	//	LOGGER.info("Saved Price: {}", savedPrice);
//
//		// Save Product
//		Product product = new Product();
//		product.setTitle("iPhone 16 Pro");
//		product.setDescription("Best product ever");
//		product.setCategory(savedCategory);
//		product.setPrice(savedPrice);
//		Product savedProduct = productRepository.save(product);
//	//	LOGGER.info("Saved Product: {}", savedProduct);




/*
		// Create and save the Category
		Category category = new Category();
		category.setName("Apple devices");
		Category savedCategory = categoryRepository.save(category); // Save the Category to make it a managed entity

// Create and save the Price
		Price price = new Price("Rupee", 10);
		Price savedPrice = priceRepository.save(price); // Save the Price to make it a managed entity

// Create the Product and associate saved Category and Price
		Product product = new Product();
		product.setTitle("iPhone 16 Pro");
		product.setDescription("Best product ever");

// Associate the managed entities
		product.setCategory(savedCategory); // Use the saved Category instance
		product.setPrice(savedPrice);       // Use the saved Price instance

// Save the Product
		Product savedProduct = productRepository.save(product); // Save the Product

// Log or verify the result (optional)
		System.out.println("Product saved successfully: " + savedProduct);

*/





//// Save the Category and retain the saved reference
//		Category category = new Category();
//		category.setName("Apple devices");
//		Category savedCategory = categoryRepository.save(category);
//
//// Save the Price and retain the saved reference
//		Price price = new Price("Rupee", 10);
//		Price savedPrice = priceRepository.save(price);
//
//// Create the Product and associate the saved Category and Price
//		Product product = new Product();
//		product.setTitle("iPhone 16 Pro");
//		product.setDescription("Best product ever");
//		product.setCategory(savedCategory); // Use the saved Category instance
//		product.setPrice(savedPrice);       // Use the saved Price instance
//
//// Save the Product
//		productRepository.save(product);











//	Category category1=	categoryRepository.findById(UUID.fromString("\u0001c�\u000F\u0017�I\\�DF-�\u000FjC")).get();  // this string is encrepted that's why creating problem


		// List<Product> products= productRepository.findByAllByprice_currancy("Rupee");






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





		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//	                                               	JPA Query
//
//		Product product1= productRepository.findAllById('f5e0706b-cf66-45f4-80e0-78a6d8b0492b');
//		System.out.println("My Product"+product1);


		List<Product> bestProductEver = productRepository.findByTitleAndDescription("Iphone 16 Pro", "best product ever");
		System.out.println(bestProductEver);

		List<Product> all = productRepository.findAll();
		System.out.println(all.size());
		System.out.println(all);
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		List<Product> rupee = productRepository.findByPrice_Currency("Rupee");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println(rupee);
		//-------------------------------------------------	---------------------------------------------------------------------------------------------------------------------------------------
		//Product byTitleEquals = productRepository.findByTitleEquals("Iphone 16 Pro");
		System.out.println("------------*********************************************-------------------------------------------------------------------");
		//System.out.println(byTitleEquals);

//		List<Product> byTitleEquals = (List<Product>) productRepository.findByTitleEquals("Iphone 16 Pro");
//		if (!byTitleEquals.isEmpty()) {
//			byTitleEquals.forEach(System.out::println);
//		} else {
//			System.out.println("No products found with the given title.");
//		}




//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		List<Product> list = productRepository.findByTitleEqualsAndPrice_Price("Iphone 16 Pro", 739.0);
		System.out.println("------------*********************************************-------------------------------------------------------------");
		System.out.println(list);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		List<Product> rupee1 = productRepository.findAllByPriceCurrency("Rupee");
		System.out.println("--------------------------------**************++++++++++++++##################################++++++++++++++++++*******************************--------------------------------------------");
		System.out.println(rupee1);

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		long rupee2 = productRepository.countAllByPrice_Currency("Rupee");
		System.out.println(rupee2);

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		List<Product> rupee3 = productRepository.findDistinctByPriceCurrency("Rupee");
		System.out.println(rupee3);


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("------------------------------------########################################################################---------------------------------------------");

		List<Product> bytTitle= productRepository.findBytTitle("Iphone 16 Pro");
		System.out.println(bytTitle);

//--------------------------------------------------------------------------------------------------------------------------------

//		List<Product> products123 = productRepository.hiberNetQueryLanguage(String "Iphone 16 Pro", String "Rupee");
//		System.out.println(products123);
//--------------------------------------------------------------------------------------------------------------------------------
//		System.out.println("Fetching category 1cb4196e-ea1f-4b7a-a908-0c58dc9f10fd");
//		Thread.sleep(1000);
//		System.out.println("Fetching category 1cb4196e-ea1f-4b7a-a908-0c58dc9f10fd");
//		Category category1 = categoryRepository.findById(UUID.fromString("04eebe4d-686a-418a-adfa-0aece669c39c")).get();
//		//Category category1 = category1Optional.get();
//		//System.out.println("id : " + category1);
//
//		System.out.println("Fatching product");
//		Thread.sleep(1000);
//		List<Product> product1 = category1.getProduct();


}


}
