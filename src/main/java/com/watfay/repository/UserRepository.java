package com.watfay.repository;

import com.watfay.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> getUserByEmail(String username);
  User findByEmail (String email);

}
