package in.co.indusnet.kafkademo.service.impl;

import java.util.List;

import in.co.indusnet.kafkademo.configs.KafkaConfigs;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import in.co.indusnet.kafkademo.entity.Product;
import in.co.indusnet.kafkademo.enums.ProductType;
import in.co.indusnet.kafkademo.repository.ProductRepository;
import in.co.indusnet.kafkademo.service.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;


	private KafkaTemplate<String,String> kafkaTemplate;

	@Override
	public List<Product> getAllProductIn(ProductType type) {
		List<Product> productsUnderType = productRepository.findByProductTypes(type);
		return productsUnderType;
	}

	@Override
	public Product findById(Long productId, Authentication authentication) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException());

		kafkaTemplate.send(KafkaConfigs.WATCHED_PRODUCTS,authentication.getName(),productId.toString());

		return product;

	}

}
