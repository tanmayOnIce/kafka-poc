package in.co.indusnet.kafkademo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import in.co.indusnet.kafkademo.enums.ProductType;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(name = "image_link")
	private String imageLink;
	
	private BigDecimal price;
	
	@Column(name = "product_type")
	private ProductType productTypes;
	
	private String categories;
	
	private Integer quantity;
	
	private boolean isOnFlashSale;
	

}
