package com.example.demo.Controller;

import com.example.demo.Exceptions.InvalidOrgRequest;
import com.example.demo.Exceptions.InvalidUserRequest;
import com.example.demo.Model.Org;
import com.example.demo.Model.User;
import com.example.demo.Request.UserRequest;
import com.example.demo.Response.UserResponse;
import com.example.demo.Service.OrgService;
import com.example.demo.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    OrgService orgService;

    public UserController(UserService userService, OrgService orgService){

        this.userService = userService;
        this.orgService = orgService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest){
        try{
            long id = userService.addUser(userRequest);
            return ResponseEntity.ok("User created with id: " + id);
        } catch(InvalidUserRequest e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUser(){
        List<User> users = userService.getAllUsers();
        List<UserResponse> response = new ArrayList<>();
        for(User user : users){
            UserResponse res = getUserResponse(user);
            response.add(res);
        }
        return ResponseEntity.ok(response);
    }

    private UserResponse getUserResponse(User user) {
        Org org = orgService.findOrgByName(user.getOrg().getOrgName());
        return new UserResponse(user.getUserId(), user.getUserName(), user.getPhone(), org.getOrgName());
    }

    @PutMapping("/edit/{userId}")
    public ResponseEntity<UserResponse> editUser(@PathVariable Long userId, @RequestParam(required = false) String userName,
                                        @RequestParam(required = false) String phone,
                                        @RequestParam(required = false) String orgName){
        User theUser = userService.editUser(userId, userName, phone, orgName);
        UserResponse res = new UserResponse(theUser.getUserId(), theUser.getUserName(), theUser.getPhone(), theUser.getOrg().getOrgName());
        return ResponseEntity.ok(res);

    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
