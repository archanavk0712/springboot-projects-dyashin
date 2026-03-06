package com.dyashin.empapp.daoimpl;


import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dyashin.empapp.dao.RegisterDao;
import com.dyashin.empapp.dto.RegistrationDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class RegisterDaoImpl implements RegisterDao{
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public RegistrationDto loginUser(String email, String pass) {
		log.info("DAO Called");
			TypedQuery<RegistrationDto> query = manager.createQuery("SELECT u FROM RegistrationDto u WHERE u.email = :email AND u.pass = :pass", RegistrationDto.class);
			query.setParameter("email", email);
			query.setParameter("pass", pass);

			return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public boolean registerUser(RegistrationDto user) {
		log.info("DAO Called");
		try {
			manager.persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
		}


}
