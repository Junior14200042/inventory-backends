package com.devjr.inventory.response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {

    private ArrayList<HashMap<String,String>> medatada = new ArrayList<>();

    public  ArrayList<HashMap<String, String>> getMedatada(){
        return medatada;
    }
    public void setMedatada(String type, String code, String date){
        HashMap<String,String> map=new HashMap<String,String>();

        map.put("type",type);
        map.put("code",code);
        map.put("date",date);

        medatada.add(map);
    }

}
