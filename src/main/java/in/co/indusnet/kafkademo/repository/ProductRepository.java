package in.co.indusnet.kafkademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.indusnet.kafkademo.entity.Product;
import in.co.indusnet.kafkademo.enums.ProductType;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByProductTypes(ProductType productTypes);

}
