package com.example.demo.Service;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Model.Org;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    OrgService orgService;
    UserRepository userRepository;

    public UserServiceImpl(OrgService orgService, UserRepository userRepository){
        this.orgService = orgService;
        this.userRepository = userRepository;
    }
    @Override
    public long addUser(UserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPhone(request.getPhone());
        Org org = new Org();
        org = orgService.findOrgByName(request.getOrgName());
        user.setOrg(org);
        userRepository.save(user);
        return user.getUserId();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User editUser(Long userId, String userName, String phone, String orgName) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if(userName != null) {
            user.setUserName(userName);
        }
        if(phone != null){
            user.setPhone(phone);
        }
        if(orgName != null) {
            Org theOrg = orgService.findOrgByName(orgName);
            if(theOrg != null){
                theOrg.setOrgName(orgName);
            }
            else{
                throw new ResourceNotFoundException("No org found");
            }
            user.setOrg(theOrg);
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> theUser = userRepository.findById(userId);
        if(theUser.isPresent()){
            userRepository.deleteById(userId);
        }
    }
}
