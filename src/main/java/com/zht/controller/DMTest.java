package com.zht.controller;

import com.zht.Constants;
import com.zht.entity.shiro.MD5;
import com.zht.entity.shiro.MessageBean;
import com.zht.entity.shiro.User;
import com.zht.entity.shiro.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by masterzht on 2018/4/8.
 */
@Controller
public class DMTest {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }


    /**
     * 判断用户是否登录
     * @param
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response, User user){
        Subject users = SecurityUtils.getSubject();
        MD5 md5 = new MD5();
        //用md5加密用户传过来的密码
        String password = md5.getMD5ofStr(user.getPassword());
        // 获取用户的token，登陆记录吧
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),password);
        token.setRememberMe(true);
        try {
            users.login(token);
            User tuser = userRepository.findByUsername(user.getUsername());
            request.getSession().setAttribute(Constants.USER_CONTEXT,
                    tuser);


            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String redirecturl = null;
            // 获取保存的URL
            if (savedRequest != null && savedRequest.getRequestUrl() != null) {
                redirecturl = savedRequest.getRequestUrl();
            }

            return new MessageBean(true, "",redirecturl);
        }catch (UnknownAccountException e) {
            token.clear();
            return new MessageBean(false, Constants.ERROR_1);
        }
        catch (IncorrectCredentialsException ee)
        {
            token.clear();
            return new MessageBean(false, Constants.ERROR_2);
        }
    }



    /**
     * 注册
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Object register(HttpServletRequest request,String username, String realname, String email,String password){

        User tuser = userRepository.findByUsername(username);
        if(tuser!=null){
            return new MessageBean(false,Constants.ERROR_3);
        }



        userRepository.save(tuser);
        return new MessageBean(Constants.SUCCESS_2.equals(Constants.SUCCESS_2),Constants.SUCCESS_2);
    }



}
