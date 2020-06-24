package com.Pranav.SocialMediaApp.Service;


import com.Pranav.SocialMediaApp.Domain.Feed;
import com.Pranav.SocialMediaApp.Domain.Friend;
import com.Pranav.SocialMediaApp.Domain.User;
import com.Pranav.SocialMediaApp.Repository.FeedRepository;
import com.Pranav.SocialMediaApp.Repository.FriendRepository;
import com.Pranav.SocialMediaApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SmService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private FeedRepository feedRepository;

    public void saveFriend(long fname,long userName)
    {

        User userAno=userRepository.findByUserId(fname);
        System.out.println(userAno);
        User user=userRepository.findByUserId(userName);
        System.out.println(user);
        Friend friend=new Friend();
        friend.setUser(user);
        System.out.println(userAno.getUserId());
        friend.setFID(userAno.getUserId());
        System.out.println(userAno.getUserName());
        friend.setName(userAno.getUserName());
        friendRepository.save(friend);
        List<Friend> friends=new ArrayList<>();
        friends.add(friend);
        userAno.setFriendList(friends);
        userRepository.save(userAno);
    }


    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    public void saveFeed(long id,String content)
    {
        User user=userRepository.findByUserId(id);
        Feed feed=new Feed();
        feed.setContent(content);

        feed.setUserFeed(user);
        feedRepository.save(feed);

    }

    public List<Map<String, Object>> getFeed(long id)
    {
        return feedRepository.getFeedByUserFeed_UserId(id);
    }


}
