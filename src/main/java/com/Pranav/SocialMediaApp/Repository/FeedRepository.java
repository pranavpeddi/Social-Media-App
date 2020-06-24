package com.Pranav.SocialMediaApp.Repository;

import com.Pranav.SocialMediaApp.Domain.Feed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface FeedRepository extends CrudRepository<Feed,Long> {



    @Query(value = "select  content from Feed where userf_user_id=?1",nativeQuery = true)
    List<Map<String,Object>> getFeedByUserFeed_UserId(long id);
}
