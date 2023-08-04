package com.example.eldar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eldar.model.CreditCard;

public interface CreditCardDao extends JpaRepository<CreditCard, Long> {
	
}
