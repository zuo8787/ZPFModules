package com.example.modulelibs.util;

import android.app.Activity;

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

    public void post(String functionName,String message){
        Activity activity = functionList.get(functionName);
        if(activity == null){
            return;
        }
        Class acitvityClass = activity.getClass();
        Method[] activityMethod = acitvityClass.getDeclaredMethods();
        for (Method method : activityMethod) {
            MyEventMsg myEventMsg =method.getAnnotation(MyEventMsg.class);
            if(myEventMsg != null && functionName == myEventMsg.eventCode()){
                method.setAccessible(true);
                try {
                    method.invoke(activity,message);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                method.setAccessible(false);
            }
        }
    }

    public void destroy(Object object){
        functionList.remove(object.getClass().getSimpleName());
    }
}
