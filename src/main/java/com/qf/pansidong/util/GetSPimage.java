package com.qf.pansidong.util;

import java.util.Random;

public class GetSPimage {

    public static String getSPimage(){
        Random r = new Random();
        int index = r.nextInt(15)+1;
        String str = "img/smn/"+index+".jpg";
        return str;

    }

}
