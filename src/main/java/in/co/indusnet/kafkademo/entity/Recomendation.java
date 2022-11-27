package in.co.indusnet.kafkademo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Recomendation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Users customer;

    private Product product;
}
