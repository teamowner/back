/*
package com.owner.backproject.security;

import com.owner.backproject.domain.model.TbUser;
import com.owner.backproject.mapper.TbUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // 1. 查询用户
        log.info("==================" + name);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name",name);
        TbUser userFromDatabase = userMapper.getTbUser(params);
        log.info("==================" + userFromDatabase.toString());
        if (userFromDatabase == null) {
            log.warn("User: {} not found", name);
            throw new UsernameNotFoundException("User " + name + " was not found in db");
            //这里找不到必须抛异常
        }
        // 2. 设置角色
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFromDatabase.getRole());
        grantedAuthorities.add(grantedAuthority);

        return new org.springframework.security.core.userdetails.User(name,
                userFromDatabase.getPassword(), grantedAuthorities);
    }
}
*/
