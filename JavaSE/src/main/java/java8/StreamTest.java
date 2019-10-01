package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ：Azhu
 * @date ：Created in 2019/9/26 9:38
 * @description：Java8新特性stream流
 */
public class StreamTest {

    /** 总数 */
    private static int total = 100_000_000;
    @Test
    public void Runtime_getRuntime_availableProcessors(){
        System.out.println(String.format("本计算机的核数：%d", Runtime.getRuntime().availableProcessors()));
    }
    @Test
    public void stream_add_Test() throws InterruptedException {
        // 产生1000w个随机数(1 ~ 100)，组成列表
        Random random = new Random();
        List<Integer> list = new ArrayList<>(total);

        for (int i = 0; i < total; i++) {
            list.add(random.nextInt(100));
        }
        //---------foreach第一次计算
        long prevTime = getCurrentTime();
        Integer sum=0;
        for (Integer integer : list) {
            sum+=integer;
        }
        System.out.println(sum);
        System.out.println(String.format("foreach第一次计算耗时：%d", getCurrentTime() - prevTime));
        //------------foreach第二次计算
        prevTime = getCurrentTime();
        sum=0;
        for  (Integer integer : list) {
            sum+=integer;
        }
        System.out.println(sum);
        System.out.println(String.format("foreach第二次计算耗时：%d", getCurrentTime() - prevTime));

        //--------单线程计算
        prevTime = getCurrentTime();
        list.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("单线程计算耗时：%d", getCurrentTime() - prevTime));

        //---------多线程计算
        prevTime = getCurrentTime();
        // 只需要加上 .parallel() 就行了
        list.stream().parallel().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("多线程计算耗时：%d", getCurrentTime() - prevTime));
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }


}

