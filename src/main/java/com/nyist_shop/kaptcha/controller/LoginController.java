package com.nyist_shop.kaptcha.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class LoginController {

    /**
     * session中的验证码
     */
    private String SHIRO_VERIFY_SESSION = "verifySessionCode";

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @GetMapping({"/", "/login"})
    public String login() {
        return "/login";
    }

//    @GetMapping("/403")
//    public String page_403() {
//        return "403";
//    }

    @ApiModelProperty(name = "登录接口")
    @PostMapping("/login")
    public String login(@ApiParam(name = "学号或工号") @RequestParam("workid") String workid,
                        @ApiParam("密码") @RequestParam("password") String password, @ApiParam("验证码") @RequestParam("verifyCode") String verifyCode, boolean rememberMe, Model model) {
        //md5加密
//        password = new Md5Hash(password, workid, 1024).toString();
        UsernamePasswordToken token = new UsernamePasswordToken(workid, password);
        Subject currentUser = SecurityUtils.getSubject();
        // 获取session中的验证码
        String verCode = (String) currentUser.getSession().getAttribute("verifySessionCode");
        if ("".equals(verifyCode)) {
            model.addAttribute("msg", "验证码不能为空");
            return "/login";
        } else if ((!verCode.equals(verifyCode))) {
            model.addAttribute("msg", "验证码不正确");
            return "/login";
        }
        try {
            //主体提交登录请求到SecurityManager
            token.setRememberMe(rememberMe);
            currentUser.login(token);
            return "/index";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg", "密码不正确");
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg", "账户不存在");
        } catch (AuthenticationException ae) {
            model.addAttribute("msg", "状态被锁定");
        }
        token.clear();
        return "/login";
    }

    /**
     * 获取验证码
     *
     * @param response
     */
    @GetMapping("/getCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        byte[] verByte = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute(SHIRO_VERIFY_SESSION, createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        verByte = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(verByte);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

}