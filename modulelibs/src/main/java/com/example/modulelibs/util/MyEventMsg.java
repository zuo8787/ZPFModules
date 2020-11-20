package com.example.modulelibs.util;

import android.app.Activity;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName: ZPFModules
 * @Package: com.example.modulelibs.util
 * @ClassName: MyEventMsg
 * @Description: java类作用描述
 * @Author: 左鹏飞
 * @CreateDate: 20-11-20 下午2:17
 * @UpdateUser: 左鹏飞
 * @UpdateDate: 20-11-20 下午2:17
 * @UpdateRemark: 更新说明
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyEventMsg {
    String functionName();
    //String[] eventMsg();
}


