package top.flooog.scss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.flooog.scss.core.HttpResult;
import top.flooog.scss.entity.SysUser;
import top.flooog.scss.security.JwtAuthenticatioToken;
import top.flooog.scss.service.SysUserService;
import top.flooog.scss.util.PasswordUtils;
import top.flooog.scss.util.SecurityUtils;
import top.flooog.scss.vo.LoginBean;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
public class LoginController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private AuthenticationManager authenticationManager;



    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String userid = loginBean.getAccount();
        String password = loginBean.getPassword();
        ///String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
      /*  Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return HttpResult.error("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }*/
        // 用户信息
        SysUser user = sysUserService.findByName(userid);
        // 账号不存在、密码错误
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, userid, password, authenticationManager);
        return HttpResult.ok(token);
    }

}
