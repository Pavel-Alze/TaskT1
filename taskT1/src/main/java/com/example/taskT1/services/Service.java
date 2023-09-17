package com.example.taskT1.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    public LinkedHashMap<Character,Integer> sort(String str){
        LinkedHashMap<Character,Integer> dir = new LinkedHashMap<>();

        for(char c : str.toCharArray()){
            if(dir.containsKey(c)){
                dir.replace(c, dir.get(c)+1);
            }else{
                dir.put(c,1);
            }
        }
        List<Character> ch = new ArrayList<>(dir.keySet());
        for (int i = 0; i<ch.size();i++){
            for (int j = i+1; j<ch.size();j++){
                if(dir.get(ch.get(i))< dir.get(ch.get(j))){
                    char tempc = ch.get(i);
                    int tempi = dir.get(ch.get(i));
                    dir.remove(ch.get(i));
                    dir.put(tempc,tempi);
                }
            }
        }
        return dir;
    }

}
