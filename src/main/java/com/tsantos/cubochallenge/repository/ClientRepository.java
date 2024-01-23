package com.tsantos.cubochallenge.repository;

import com.tsantos.cubochallenge.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
