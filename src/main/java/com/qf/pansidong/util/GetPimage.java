package com.qf.pansidong.util;

import java.util.Random;

public class GetPimage {
    public static String getPimage(){
        Random r = new Random();
        int index = r.nextInt(120)+1;
        String str = "img/mn/"+index+".jpg";
        return str;

    }
}
