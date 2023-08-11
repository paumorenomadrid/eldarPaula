package com.example.eldar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eldar.model.CreditCard;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardDao extends JpaRepository<CreditCard, Long> {
	
}
