package in.co.indusnet.kafkademo.service;

import java.util.List;

import in.co.indusnet.kafkademo.entity.Product;
import in.co.indusnet.kafkademo.enums.ProductType;

public interface ProductService {
	
	List<Product> getAllProductIn(ProductType type);

	Product findById(Long productId);

}
