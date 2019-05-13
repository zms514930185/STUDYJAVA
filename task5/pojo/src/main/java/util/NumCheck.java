package util;

public class NumCheck {
    public static boolean checkNumber(double value){
        String str = String.valueOf(value);
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
        return str.matches(regex);
    }

    public static boolean checkNumber(int value){
        String str = String.valueOf(value);
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
        return str.matches(regex);
    }

    public static boolean checkNumber(String value){
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
        return value.matches(regex);
    }


//        System.out.println(checkNumber(0));// true
//        System.out.println(checkNumber(-0));// true
//        System.out.println(checkNumber(23));// true
//        System.out.println(checkNumber(-23));// true
//        System.out.println(checkNumber(0.0));// true
//        System.out.println(checkNumber(-0.0));// true
//        System.out.println(checkNumber(23.01));// true
//        System.out.println(checkNumber(-23.01));// true
//        System.out.println(checkNumber("-10.01.01"));// false
//        System.out.println(checkNumber("A110"));// false



}
