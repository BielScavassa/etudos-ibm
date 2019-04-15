package com.ibm.sample.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class FirstJunitTest {

    private FirstJunit firstJunit;


    @Before
    public void setup(){
        firstJunit = new FirstJunit();
    }

    @Test
    public void deve_realizar_soma(){
        //GIVE
        int a = 10,b=10;
        //WHEN
        int sum = firstJunit.sum(a,b);
        //THEN
        assertEquals(20,sum);
    }

    @Test
    public void deve_realizer_div(){
        //GIVE
        int a=10,b=10;
        //WHEN
        float div = firstJunit.div(a,b);
        //THEN
        assertEquals(1.00f,div,1);
    }



}
