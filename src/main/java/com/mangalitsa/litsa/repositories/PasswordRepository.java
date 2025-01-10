package com.mangalitsa.litsa.repositories;

import com.mangalitsa.litsa.model.Password;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends CrudRepository<Password, Long> {
}
