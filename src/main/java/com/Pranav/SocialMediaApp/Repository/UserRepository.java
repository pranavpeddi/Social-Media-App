package com.Pranav.SocialMediaApp.Repository;

import com.Pranav.SocialMediaApp.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
  User findByUserId(long id);

}
