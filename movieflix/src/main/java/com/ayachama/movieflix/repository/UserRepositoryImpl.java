package com.ayachama.movieflix.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ayachama.movieflix.entity.User;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User signUpUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User signInUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User signOutUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
