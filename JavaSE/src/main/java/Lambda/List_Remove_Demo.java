package Lambda;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：Azhu
 * @date ：Created in 2019/9/24 14:57
 * @description：Lambda表达式List删除元素
 */
public class List_Remove_Demo {

    /**
     *  forecach循环删除
     * 抛出异常java.util.ConcurrentModificationException
     */
    @Test
    public  void method1() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("abc");
        list.add(null);
        list.add("123456");
        list.add("");

        for (String str : list) {
            if ( StringUtils.isEmpty(str)) {
                list.remove(str);
            }
        }
        System.out.println(list);
        System.out.println(list.hashCode());
    }

    /**
     * 方式3：使用lambda表达式删除列表元素
     * 上面使用迭代器的方式虽然能够正常地删除列表中的元素，但还是不够优雅，因为要写好几行的遍历代码，
     * 显得略臃肿。能不能只用一行代码完成这个功能呢？答案是可以的——使用lambda表达式：化。
     */
    @Test
    public  void method2() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("abc");
        list.add(null);
        list.add("123456");
        list.add("");
        System.out.println(list);
        System.out.println(list.hashCode());

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if ( StringUtils.isEmpty(str)) {
                it.remove();
            }
        }
        System.out.println(list);
        System.out.println(list.hashCode());
    }


    /**
     * 使用Lambda表达式删除元素
     * 可见使用Lambda正常地删除列表的元素，并且删除元素之后列表的内存地址已经发生了变化。
     */
    @Test
    public  void method3() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("abc");
        list.add(null);
        list.add("123456");
        list.add("");
        System.out.println(list);
        System.out.println(list.hashCode());

        list.removeIf(e -> StringUtils.isEmpty(e));
        System.out.println(list);
        System.out.println(list.hashCode());
    }

    /**
     * 方式4：使用方法引用删除列表元素
     * 除了lambda表达式，JDK 1.8还可以用一种称为方法引用的方式来删除列表中的元素，使用类似C++的::运算符，
     * 来引用一个对象的实例方法或一个类的类方法，下面就用方法引用的方式来删除一个列表中的指定元
     */
    @Test
    public  void method4() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("abc");
        list.add(null);
        list.add("123456");
        list.add("");
        System.out.println(list);
        System.out.println(list.hashCode());

        list.removeIf(StringUtils::isEmpty);  // isEmpty为StringUtils类的一个静态方法
        System.out.println(list);
        System.out.println(list.hashCode());
    }

    /**
     * 测试一下iterator和Lambda删除的效率
     * Lambda表达式要先找到不符合的数据再删除
     * 而iterator是直接删除的
     * 感觉应该是iterato删除快于Lambda
     * 数据量小的时候iterator优于Lambda
     * 数据量逐渐增大的时候Lambda优势慢慢展现
     *  5000数据量
     * -----------数据生成完毕-----------
     * Iterator 删除元素耗时:40
     * Lambda 删除元素耗时:93
     *
     * 50 000数据量
     * -----------数据生成完毕-----------
     * Iterator 删除元素耗时:410
     * Lambda 删除元素耗时:144
     *
     * 500 000数据量差距很明显
     * -----------数据生成完毕-----------
     * Iterator 删除元素耗时:47590
     * Lambda 删除元素耗时:825
     */
    @Test
    public void Test() {
        //初始化List大小
        List<String> list1=new ArrayList<>(5000);
        List<String> list2=new ArrayList<>(5000);

        for(int i=0;i<5000;i++){
            list1.add(i,i+"");
            list2.add(i,i+"");
            if(i%2==0){
                list1.add(i,null);
                list2.add(i,null);
            }
            if(i%4==0){
                list1.add(i,"");
                list2.add(i,"");
            }
        }
        System.out.println("-----------数据生成完毕-----------");
        long start1=System.currentTimeMillis();
        Iterator<String> it1 = list1.iterator();
        while (it1.hasNext()) {
            String str = it1.next();
            if ( StringUtils.isEmpty(str)) {
                it1.remove();
            }
        }
        long end1=System.currentTimeMillis();
        System.out.println("Iterator 删除元素耗时:"+(end1-start1)+"");

        long start2=System.currentTimeMillis();
        list2.removeIf(e -> StringUtils.isEmpty(e));
        long end2=System.currentTimeMillis();
        System.out.println("Lambda 删除元素耗时:"+(end2-start2)+"");


    }
}
