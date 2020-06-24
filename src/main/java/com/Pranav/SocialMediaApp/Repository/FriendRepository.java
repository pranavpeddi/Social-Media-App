package com.Pranav.SocialMediaApp.Repository;

import com.Pranav.SocialMediaApp.Domain.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface FriendRepository extends CrudRepository<Friend,Long> {

    @Query(value = "SELECT name from Friend where user_user_id=?1",nativeQuery = true)
     List<Map<String,Object>> getFriendByUser_UserId(long id);
}



