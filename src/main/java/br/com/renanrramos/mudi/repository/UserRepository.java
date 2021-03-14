package br.com.renanrramos.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renanrramos.mudi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(final String username);
}
