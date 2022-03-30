package com.logger.repository;

import com.logger.data.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface VisitRepo extends JpaRepository<Visit, Integer> {

    Object findByEmail();

}
