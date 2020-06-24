package com.Pranav.SocialMediaApp.Controller;


import com.Pranav.SocialMediaApp.Domain.User;
import com.Pranav.SocialMediaApp.Repository.FriendRepository;
import com.Pranav.SocialMediaApp.Service.SmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {


   @Autowired
   private SmService smService;


   @Autowired
   private FriendRepository friendRepository;


   @PostMapping("/saveUser/{DOB}")
    public ResponseEntity<?> saveUser(@RequestBody User user, @RequestParam String DOB)
    {
        LocalDate date1= LocalDate.now();
        LocalDate date2=LocalDate.parse(DOB);
        user.setDob(date2);
        user.setDate_of_registration(date1);

        smService.saveUser(user);
        return new ResponseEntity<>("saved user", HttpStatus.OK);

    }


    @PostMapping("/saveFriend/{fname}/{userName}")
    public ResponseEntity<?> saveFriend(@RequestParam long fname,@RequestParam long userName)
    {
         smService.saveFriend(fname,userName);
         return new ResponseEntity<>("added friend to ur friends list",HttpStatus.OK);
    }


    @GetMapping("getFriends/{Id}")
    public List<Map<String, Object>> getFriends(@RequestParam long Id)
    {

      return friendRepository.getFriendByUser_UserId(Id);
    }




    @PostMapping("postFeed/{id}/{content}")
    public  ResponseEntity<String>  postFeed(@RequestParam String content,@RequestParam long id)
    {

        smService.saveFeed(id,content);

        return new ResponseEntity<String>("Feed Updated!!",HttpStatus.OK);
    }


    @GetMapping("feed/getFeed/{id}")
    public List<Map<String, Object>> getFeed(@RequestParam  long id)
    {
        return smService.getFeed(id);
    }
}
