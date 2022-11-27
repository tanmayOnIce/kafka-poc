package in.co.indusnet.kafkademo.service.impl;

import in.co.indusnet.kafkademo.configs.KafkaConfigs;
import in.co.indusnet.kafkademo.entity.Advertisement;
import in.co.indusnet.kafkademo.entity.Product;
import in.co.indusnet.kafkademo.entity.Recomendation;
import in.co.indusnet.kafkademo.entity.Users;
import in.co.indusnet.kafkademo.repository.AdverRepository;
import in.co.indusnet.kafkademo.repository.ProductRepository;
import in.co.indusnet.kafkademo.repository.RecomendationRepository;
import in.co.indusnet.kafkademo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WatchedProductListener {

    private UserRepository userRepository;
    private ProductRepository productRepository;
    private RecomendationRepository recomendationRepository;
    private AdverRepository adverRepository;

    @KafkaListener(topics = KafkaConfigs.WATCHED_PRODUCTS)
    public void createRecomandationForCustomer(ConsumerRecord<String,String> record) {

        String customerEmail = record.key();
        String watchedProduct = record.value();

        Users customer = userRepository.findByEmail(customerEmail);
        Product product = productRepository.findById(Long.valueOf(watchedProduct)).orElseThrow();

        Recomendation recomendation = new Recomendation();
        recomendation.setCustomer(customer);
        recomendation.setProduct(product);

        recomendationRepository.save(recomendation);


    }

    //move to different project
    @KafkaListener(topics = KafkaConfigs.WATCHED_PRODUCTS)
    public void createAdvertsForCustomer(ConsumerRecord<String,String> record) {
        String customerEmail = record.key();
        String watchedProduct = record.value();

        Users customer = userRepository.findByEmail(customerEmail);
        Product product = productRepository.findById(Long.valueOf(watchedProduct)).orElseThrow();

        Advertisement advertisement = new Advertisement();
        advertisement.setCustomer(customer);
        advertisement.setProduct(product);

        adverRepository.save(advertisement);
    }
}
