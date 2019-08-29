package com.sleepy.food.service.impl;

import com.sleepy.food.entity.User;
import com.sleepy.food.mapper.UserMapper;
import com.sleepy.food.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sleepy
 * @since 2019-08-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
