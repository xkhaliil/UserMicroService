package com.khalil.microsservice.restControllers;

import java.util.List;
import java.util.Map;

import com.khalil.microsservice.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.khalil.microsservice.entities.User;
import com.khalil.microsservice.service.UserService;
@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
    @Autowired
    UserService userService;
    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(path="add",method=RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(path="addRole/{id}",method=RequestMethod.POST)
    public User addRoleToUser(@PathVariable long id,@RequestBody Role r) {
        return userService.addRoleToUser(id, r);
    }
    //je veut passer l id in the url
    @RequestMapping(path="findUserById/{id}",method=RequestMethod.GET)
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(path="allRoles",method=RequestMethod.GET)
    public List<Role> getAllRoles() {
        return userService.findAllRoles();
    }

    @RequestMapping(path="findRoleById/{id}",method=RequestMethod.GET)
    public Role findRoleById(@PathVariable Long id) {
        return userService.findRoleById(id);
    }

    @RequestMapping(path="deleteUserById/{id}",method=RequestMethod.DELETE)
    public void deleteUserById(@PathVariable long id) {
         userService.deleteUser(id);
    }

    @RequestMapping(path="removeRoleFromUer/{id}",method=RequestMethod.POST)
    public User removeRole(@PathVariable long id,@RequestBody Role r)
    {
        return  userService.removeRoleFromUser(id,r);

    }
    @RequestMapping(path = "activateUser/{username}", method = RequestMethod.POST)
    public User activateUser(@PathVariable String username, @RequestBody Map<String, String> requestBody) {
        String code = requestBody.get("code");
        System.out.println("user activated: " + code);
        return userService.activateUser(username, code);
    }




}