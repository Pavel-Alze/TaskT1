package com.example.taskT1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTests extends Assert {

    LinkedHashMap<Character,Integer> dir = new LinkedHashMap<>();
    String str;



    @Before
    public void setUpDir(){
        dir.put('a', 5);
        dir.put('b',1);
        dir.put('c',4);
    }

    @Before
    public void setUpStr(){
        str = "aaaaabcccc";
    }

    @After
    public void tearDownDir(){
        dir.clear();
    }

    @After
    public void tearDownStr(){
        str = "";
    }
    @Test
    public void testDir(){
        List<Character> test_result = Arrays.asList('a','c','b');
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
        List<Character> expected = new ArrayList<>(dir.keySet());
        assertEquals(expected,test_result);
    }

    @Test
    public void testStr(){
        LinkedHashMap<Character,Integer> exp_dir = new LinkedHashMap<>();
        for(char c : str.toCharArray()){
            if(exp_dir.containsKey(c)){
                exp_dir.replace(c, exp_dir.get(c)+1);
            }else{
                exp_dir.put(c,1);
            }
        }
        assertEquals(exp_dir,dir);
    }

}
