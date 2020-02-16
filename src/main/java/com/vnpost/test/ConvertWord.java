package com.vnpost.test;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class ConvertWord {
    protected static String removeAccent(String s) {
        s = s.trim();
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
    protected static String split(String a){
        return removeAccent(a).toLowerCase().replaceAll("[^a-zA-Z0-9]", " ").
                trim().replaceAll(" ","-");
    }
    private static char[] removeElement(char[] array,int position){
        char[] newArray = new char[array.length-1];
        for(int i=0;i<array.length-1;i++){
            if(i>=position ){
                newArray[i] = array[i+1];
            }else
                newArray[i] = array[i];

        }
        return newArray;
    }
    public static String convert(String str){
        char[] array = split(str).toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<array.length-1;i++){
            if ((array[i]=='-') && (array[i]==array[i+1])){
                array= (char[]) removeElement(array,i);
                i--;
            }
        }
        for (int i=0;i<array.length;i++){
            builder.append(array[i]);
        }

        return builder.toString();
    }



    public static void main(String[] args) {
        String a = "Mù Cang Chải: “Đi từng ngõ, gõ cửa từng nhà”";
        String b = removeAccent(a);
        System.out.println(removeAccent(a));
        System.out.println(split(a));
        System.out.println(convert(a));

    }

}
