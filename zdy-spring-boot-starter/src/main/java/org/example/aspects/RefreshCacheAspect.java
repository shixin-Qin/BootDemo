package org.example.aspects;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.annotions.HandleType;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 更新缓存切面类
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/12/16 17
 */
@Aspect
public class RefreshCacheAspect {

    @AfterReturning("@annotation(org.example.annotions.HandleType)")
    public void refresh(JoinPoint pjp) throws Exception {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        System.out.println(method.getName() + "() 返回后切面处理。");

        // 获取方法上指定注解
        HandleType handleTypeAnnotion = method.getAnnotation(HandleType.class);

        String handle = handleTypeAnnotion.handle();
        /**
         * 模拟更新数据后刷新缓存
         */
        if ("delete".equals(handle)) {
            // 获取参数名称数组
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            String[] parameterNames = methodSignature.getParameterNames();
            // 获取参数值数组
            Object[] args = pjp.getArgs();
            int indexOf = ArrayUtils.indexOf(parameterNames, "sourceName");
            if (indexOf != -1) {
                String arg = (String) args[indexOf];
                System.out.println("模拟刷新缓存:" + arg);
            }
        }
    }
}
