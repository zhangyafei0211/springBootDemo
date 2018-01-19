package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.data.UserEntity;
import com.example.demo.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String user(){
        logger.info("方法内。。。");
        return "秦般若";
    }

    @RequestMapping(value = "/userList")
    public List<UserEntity> userList(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/getUserById/{id}")
    public UserEntity getById(@PathVariable("id") int id){
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/addUser")
    public UserEntity addUser(@RequestParam("userName") String userName,@RequestParam("age") int age){
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setAge(age);
            userEntity.setUserName(userName);
            return userRepository.save(userEntity);
        }catch (Exception e){
            e.printStackTrace();
            Logger.getLogger(e.getMessage());
        }
        return  null;
    }

    /**
     * @Desc 表单验证
     * @param userEntity
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/saveUser")
    public UserEntity saveUser(@Valid UserEntity userEntity, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                System.out.println(bindingResult.getFieldError().getDefaultMessage());
                return null;
            }
            return userRepository.save(userEntity);
        }catch (Exception e){
            e.printStackTrace();
            Logger.getLogger(e.getMessage());
        }
        return  null;
    }

    @RequestMapping(value = "/updateUser/{id}")
    public UserEntity updateUser(@PathVariable("id") int id,@RequestParam("userName") String userName,@RequestParam("age") int age){
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(id);
            userEntity.setUserName(userName);
            userEntity.setAge(age);
            return userRepository.save(userEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delUser/{id}")
    public void delUser(@PathVariable("id") int id){
        try {
            userRepository.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/addTwo")
    public void addTwo(){
        userService.Trainactical();
    }


}
