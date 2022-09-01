
package com.albertsonspoc.UserShop.controllers;
import com.albertsonspoc.UserShop.models.Status;
import com.albertsonspoc.UserShop.models.User;

import com.albertsonspoc.UserShop.services.UserService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import javax.validation.Valid;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class UserController
{
@Autowired
private UserService userService;


@PostMapping("/user/register")
 public Status registerUser(@RequestBody User newUser)
{
List<User> users=userService.findAll();
if(users.equals(newUser))
{
    System.out.println("User Already exists!");
    return Status.USER_ALREADY_EXISTS;
}
return this.userService.registerUser(newUser);
}

@PostMapping("/user/login")
public Map<String,String> getLogin(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
    List<User> users = userService.findAll();
    HashMap<String,String> map=new HashMap<>();
    map.put("value","name");
    String s3=(payload.get("userName")).toString();
    String s4=(payload.get("password")).toString();
    s3=s3.substring(1,s3.length()-1);
    s4=s4.substring(1,s4.length()-1);
    for (User user : users) {
        String s1=(user.getUserName());
        String s2=(user.getPassword());
        System.out.println(s1+"  "+s2+"  "+s3+"    "+s4);
        if (s1.equals(s3) && s2.equals(s4)) {
            map.put("value","name1");
            return map;
        }
    }return map;
}
    @PutMapping("/user/profile")
    public ResponseEntity<User> updateProfile(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws Exception {

        HashMap<String, String> map = new HashMap<>();
        map.put("value", "name");
        String s1 = (payload.get("address")).toString();
        String s2 = (payload.get("email")).toString();
        String s3 = (payload.get("phone")).toString();
        String s4 = (payload.get("username")).toString();
        String s5 = (payload.get("pass")).toString();

        s1 = s1.substring(1, s1.length() - 1);
        s2 = s2.substring(1, s2.length() - 1);
        s3 = s3.substring(1, s3.length() - 1);
        s4 = s4.substring(1, s4.length() - 1);

        User user = userService.findByUserName(s4);

        user.setEmail(s2);
        user.setPhone(s3);
        user.setAddress(s1);
        return ResponseEntity.ok(this.userService.updateProfile(user));
    }

}



