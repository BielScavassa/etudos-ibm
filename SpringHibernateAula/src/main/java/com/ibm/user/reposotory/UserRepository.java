package com.ibm.user.reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.user.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{
	List<UserModel> findByName(String name);
	List<UserModel> findAll();
	UserModel save(UserModel user);
	
	@Query("SELECT U FROM UserModel AS U WHERE U.id = :id AND U.name = :name")
	UserModel findAllFields(@Param("id") long id, @Param("name") String name);
}
