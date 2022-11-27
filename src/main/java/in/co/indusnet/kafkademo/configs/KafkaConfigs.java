package in.co.indusnet.kafkademo.configs;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfigs {
	public static final String WATCHED_PRODUCTS = "watched-products";
	
/*	@Bean
	public ProducerFactory<String, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092",
				ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class,ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class));
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}*/


	@Bean
	public NewTopic createProductWatchedTopic() {
		return TopicBuilder.name(WATCHED_PRODUCTS)
				.partitions(2)
				.replicas(1)
				.build();
	}

}
