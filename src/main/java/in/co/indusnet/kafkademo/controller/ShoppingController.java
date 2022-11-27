package in.co.indusnet.kafkademo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.indusnet.kafkademo.entity.Product;
import in.co.indusnet.kafkademo.enums.ProductType;
import in.co.indusnet.kafkademo.service.ProductService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/kamazon/product")
@AllArgsConstructor
public class ShoppingController {
	
	private ProductService productService;
	private final KafkaTemplate<String , String> kafkaTemplate;
	
	
	@GetMapping("/{productType}")
	public List<Product> getAllItemInAnCategory(@PathVariable("productType") ProductType productType) {
		return productService.getAllProductIn(productType);
	}
	
	@GetMapping("/id/{productId}")
	public Product getProduct(@PathVariable("productId") Long productId) {
		return productService.findById(productId);
	}

	@GetMapping("/hello")
	public String hello(Principal principal) {
		return "hello "+principal.getName();
	}
	
	

}
