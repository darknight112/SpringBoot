package com.codeline.sampleProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Account extends JpaRepository<Account, Long> {
}
