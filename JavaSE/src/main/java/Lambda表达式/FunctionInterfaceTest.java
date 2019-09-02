package main.java.Lambda表达式;

import org.junit.Test;

/**
 * @author Azhu
 * @date 2019/8/29 11:01
 */
public class FunctionInterfaceTest {


    @Test
    public void testLambda(){

        func(new FunctionInterface() {
            @Override
            public void test() {
                System.out.println("Hello Lambda");
            }
        });

        func(()-> System.out.println("YYYYYYY"));
    }


    private void func(FunctionInterface functionInterface){
        functionInterface.test();
    }
}
