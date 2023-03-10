package com.project.organic.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.organic.model.Account;

public interface AccountRespository extends JpaRepository<Account, Integer> {
	Account findById(int id);
	Account findByEmail(String email);
}
