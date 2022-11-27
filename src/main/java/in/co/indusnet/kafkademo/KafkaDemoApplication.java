package in.co.indusnet.kafkademo;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import in.co.indusnet.kafkademo.configs.RSAKeyProperties;
import in.co.indusnet.kafkademo.entity.Product;
import in.co.indusnet.kafkademo.enums.ProductType;
import in.co.indusnet.kafkademo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableConfigurationProperties(RSAKeyProperties.class)
public class KafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return (args -> {
			Commerce commerce = Faker.instance().commerce();
			for(int i = 0 ; i < 100 ; i++) {
				Product product = new Product();
				product.setCategories(commerce.department());
				product.setProductTypes(Arrays.stream(ProductType.values()).findAny().get());
				product.setName(commerce.productName());
				product.setPrice(commerce.price(1.0,10000.0));
				product.setOnFlashSale(true);
				product.setQuantity(ThreadLocalRandom.current().nextInt());

				productRepository.save(product);
			}
		});
	}*/

}
