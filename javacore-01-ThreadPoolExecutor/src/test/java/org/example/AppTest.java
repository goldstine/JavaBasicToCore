package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest 
{

    @Test
    public void test01(){
        MyTask myTask = new MyTask(1);
        System.out.println(myTask.getClass());
    }


    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
