package in.co.indusnet.kafkademo.repository;

import in.co.indusnet.kafkademo.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdverRepository extends JpaRepository<Advertisement,Long> {
}
