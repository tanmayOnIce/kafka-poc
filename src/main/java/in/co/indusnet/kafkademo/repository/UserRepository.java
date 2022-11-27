package in.co.indusnet.kafkademo.repository;

import in.co.indusnet.kafkademo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {

    public Users findByEmail(String email);
}
