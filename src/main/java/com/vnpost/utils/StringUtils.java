package com.vnpost.utils;

public class StringUtils {
    public static String convert(String str){
        char[] array = VNCharacterUtils.removeAccent(str).trim()
                .replaceAll("[^a-zA-Z0-9]", " ").trim()
                .replaceAll("[^a-zA-Z0-9]", "-").toLowerCase().toCharArray();
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
    public static String convertEnglish(String str){
        char[] array = VNCharacterUtils.removeAccent(str).trim()
                .replaceAll("[^a-zA-Z0-9]", " ").trim()
                .replaceAll("[^a-zA-Z0-9]", " ").toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<array.length;i++){
            builder.append(array[i]);
        }
        return builder.toString();
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


}
