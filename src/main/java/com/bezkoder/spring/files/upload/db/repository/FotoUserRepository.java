package com.bezkoder.spring.files.upload.db.repository;

import com.bezkoder.spring.files.upload.db.model.FotoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoUserRepository extends JpaRepository<FotoUser, String> {
}
