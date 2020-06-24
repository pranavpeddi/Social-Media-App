package com.Pranav.SocialMediaApp.Domain;


import javax.persistence.*;

@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long FeedId;

    private String Content;


    @ManyToOne
    private User userFeed;
    public long getFeedId() {
        return FeedId;
    }


    public User getUserFeed() {
        return userFeed;
    }

    public void setUserFeed(User userF) {
        this.userFeed = userF;
    }

    public void setFeedId(long feedId) {
        FeedId = feedId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
