package com.logger.repository;

import com.logger.data.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Transactional
@Repository
public interface VisitorRepo extends JpaRepository<Visitor, Integer> {

   Optional <Visitor> findByEmail(String email);

    Optional<Visitor> findByPassword(String passWord);
}
