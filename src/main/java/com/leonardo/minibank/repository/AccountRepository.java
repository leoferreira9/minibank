package com.leonardo.minibank.repository;

import com.leonardo.minibank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {}
