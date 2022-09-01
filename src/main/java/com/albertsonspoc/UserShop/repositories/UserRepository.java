package com.albertsonspoc.UserShop.repositories;

import com.albertsonspoc.UserShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
   public User findByUserName(String userName);
}
