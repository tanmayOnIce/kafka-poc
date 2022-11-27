package in.co.indusnet.kafkademo.repository;

import in.co.indusnet.kafkademo.entity.Recomendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecomendationRepository extends JpaRepository<Recomendation,Long> {
}
