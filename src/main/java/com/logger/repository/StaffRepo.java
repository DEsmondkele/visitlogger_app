package com.logger.repository;

import com.logger.data.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;


@Transactional
@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer> {

    Optional<Staff> finByEmail(String email);

    Optional<Staff> findByPassword(String passWord);

}
