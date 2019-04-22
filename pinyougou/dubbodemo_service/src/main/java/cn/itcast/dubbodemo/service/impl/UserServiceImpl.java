package cn.itcast.dubbodemo.service.impl;

import cn.itcast.dubbodemo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String showName() {
        return "测试一下linux的dubbo";
    }
}
