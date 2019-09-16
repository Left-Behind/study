package main.java.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 短路运算符测试 {

    @Test
    public void _Test1(){
        List list=new ArrayList<Integer>();
        if(!list.isEmpty()&&list.get(0).equals(0)){
            System.out.println("ssssss");
        }else{
            System.out.println("ssssssssssssssssssssssssssssssssss");
        }
    }
}
