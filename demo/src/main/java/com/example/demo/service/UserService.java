package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.data.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注解 事务处理 添加失败 添加两条数据，
 * 即使第一条能添加成功，第二条不符合要求，依然数据回滚
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void Trainactical(){
        try{
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName("皇帝");
            userEntity.setAge(50);
            userRepository.save(userEntity);

            //数据库表用户名长度3，此处超过了最大长度，添加失败
            UserEntity u = new UserEntity();
            u.setUserName("静妃娘娘");
            u.setAge(30);
            userRepository.save(u);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
