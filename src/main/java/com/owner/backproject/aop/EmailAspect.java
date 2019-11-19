package com.owner.backproject.aop;

import com.owner.backproject.domain.model.email.MailDTO;
import com.owner.backproject.service.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class EmailAspect {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    SendEmailService sendEmailService;

    /**
     * 指定切点
     * 匹配 包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(public * com.owner.backproject.restful.userManager.UserController.user(..))")
    public void beforeNotify(){
    }



    /**
     * 前置通知，方法调用前被调用
     * @param joinPoint
     */
    @Before("beforeNotify()")
    public void doBefore(JoinPoint joinPoint){
        log.info("我是前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        log.info("请求参数："+obj);
        // 代理
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        log.info("方法："+signature.getName());
        //AOP代理类的名字
        log.info("方法所在包:"+signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] strings = methodSignature.getParameterNames();
        log.info("参数名："+ Arrays.toString(strings));
        log.info("参数值ARGS : " + Arrays.toString(joinPoint.getArgs()));
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        // 记录下请求内容
        log.info("请求URL : " + req.getRequestURL().toString());
        log.info("HTTP_METHOD : " + req.getMethod());
        log.info("IP : " + req.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("beforeNotify()")
    public void after(JoinPoint jp) throws MessagingException {
        MailDTO mailDTO = new MailDTO();
        mailDTO.setFrom(from);
        String[] to = new String[2];
        to[0] = "vndhnl@cn.ibm.com";
        to[1] = "478703766@qq.com";
        mailDTO.setTo(to);
        mailDTO.setText("测试发邮件,在执行请求之后，只针对config 方法=====");
        mailDTO.setSubject("after");

        sendEmailService.sendEmail(mailDTO);

        log.info("读取配置=========邮件发送完成");

    }
}
