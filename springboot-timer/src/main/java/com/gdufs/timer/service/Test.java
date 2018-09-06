package com.gdufs.timer.service;

/**
 * @author gucailiang
 * @date 2018/7/4
 */
public class Test {
    public static void main(String[] args) {
        String SEPARATOR = System.getProperty("file.separator");
        System.out.println(SEPARATOR);
        System.out.println(Test.class.getName());
        String location = "classpath:" + Test.class.getName().replace(".", SEPARATOR) + ".xml";
        System.out.println(location);

    }
}
