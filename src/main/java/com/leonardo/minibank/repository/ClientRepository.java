package com.leonardo.minibank.repository;

import com.leonardo.minibank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}
