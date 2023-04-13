package com.bitchpeng.springdemo.demo;

public class Test {
    public static String reverse(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String reverse = reverse("123");
        System.out.println(reverse);
    }


}
