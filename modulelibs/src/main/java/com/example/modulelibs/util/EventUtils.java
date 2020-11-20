package com.example.modulelibs.util;

import android.app.Activity;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;

public class EventUtils{

    private static final EventUtils instance = new EventUtils();
    //记录方法名和类
    private TreeMap<String,Activity> functionList = new TreeMap();

    public static EventUtils getInstance(){
        return instance;
    }

    public void init(Object object){
        if(object instanceof Activity){
            Class acitvityClass = object.getClass();
            Method[] activityMethod = acitvityClass.getDeclaredMethods();
            for (Method method : activityMethod) {
                MyEventMsg myEventMsg =method.getAnnotation(MyEventMsg.class);
                if(myEventMsg != null){
                    functionList.put(method.getName(), (Activity) object);
                }
            }

        }
    }

    public Object post(String functionName,Object message){
        Activity activity = functionList.get(functionName);
        Object returnObj = null;
        if(activity == null){
            return null;
        }
        Class acitvityClass = activity.getClass();
        Method[] activityMethod = acitvityClass.getDeclaredMethods();
        for (Method method : activityMethod) {
            MyEventMsg myEventMsg =method.getAnnotation(MyEventMsg.class);
            if(myEventMsg != null && functionName == myEventMsg.functionName()){
                method.setAccessible(true);
                try {
                    returnObj = method.invoke(activity,message);
                    LogUtils.i(returnObj.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }finally {
                    method.setAccessible(false);
                }
            }
        }
        return returnObj;
    }

    public void destroy(Object object){
        functionList.remove(object.getClass().getSimpleName());
    }
}
