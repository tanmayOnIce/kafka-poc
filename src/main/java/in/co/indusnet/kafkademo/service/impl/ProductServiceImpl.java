package in.co.indusnet.kafkademo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.indusnet.kafkademo.entity.Product;
import in.co.indusnet.kafkademo.enums.ProductType;
import in.co.indusnet.kafkademo.repository.ProductRepository;
import in.co.indusnet.kafkademo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProductIn(ProductType type) {
		List<Product> productsUnderType = productRepository.findByProductTypes(type);
		return productsUnderType;
	}

	@Override
	public Product findById(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException());
		
		return product;

	}

}
