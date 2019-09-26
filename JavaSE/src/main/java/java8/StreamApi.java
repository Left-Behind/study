package main.java.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：Azhu
 * @date ：Created in 2019/9/26 10:34
 * @description：stream流的api实践
 */
public class StreamApi {

    /**
     * 和迭代器一样，流只能遍历一次。当流遍历完之后，我们就说这个流已经被消费掉了，
     * 你可以从原始数据那里重新获得一条新的流，但是却不允许消费已消费掉的流。
     * 例如下面代码就会抛出一个异常，说流已被消费掉了：
     */
    @Test
    public void forEach(){
        List<String> title = Arrays.asList("Wmyskxz", "Is", "Learning", "Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }

    /**
     * Stream 接口支持 filter 方法，该操作会接受一个返回 boolean 的函数作为参数，
     * 并返回一个包含所有符合该条件的流。例如，你可以这样选出所有以字母 w 开头的单词并打印：
     */
    @Test
    public void filter(){
        List<String> titles=Arrays.asList("wmyskxz", "say", "wow", "to", "everybody");
        titles.stream()
             .filter(title->title.startsWith("w"))
             .forEach(System.out::println);

        List<String> filteredTitles = titles.stream()
                .filter(word -> word.startsWith("w"))
                .collect(Collectors.toList());
    }


    /**
     * 流还支持一个叫做 distinct 的方法，
     * 它会返回一个元素各异（根据流所生成的元素的 hashCode 和 equals 方法实现）的流。例如，
     * 以下代码会筛选出列表中所有的偶数，并确保没有重复：
     */
    @Test
    public void distinct(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 2, 1, 3, 4);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 流支持 limit(n) 方法，该方法会返回一个不超过给定长度的流，
     * 所需长度需要作为参数传递给 limit。如果流是有序的，
     * 则最多会返回前 n 个元素。比如，你可以建立一个 List，选出前 3 个元素：
     */
    @Test
    public void limit(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        //filter和limit可以换位置，效果不同
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .limit(3)
                .forEach(System.out::println);
    }

    /**
     * 流还支持 skip(n) 方法，
     * 返回一个扔掉了前 n 个元素的流。如果流中元素不足 n 个，则返回一个空流。
     * 请注意 litmit 和 skip 是互补的！例如，下面这段程序，选出了所有的偶数并跳过了前两个输出：
     */
    @Test
    public void skip(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        //skip，效果不同
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .skip(2)
                .forEach(System.out::println);
    }

    /**
     * 流支持 map 方法，他会接受一个函数作为参数。这个函数会被应用到每个元素身上吗，
     * 并将其映射成一个新的函数。例如，下面的代码把方法引用 Words::getContent 传给了 map 方法，
     * 来提取流中 Words 的具体内容：
     */
    @Test
    public void map(){
        List<Words> numbers = Arrays.asList(new Words("我没有三颗心脏"),
                new Words("公众号"), new Words("wmyskxz"));
        numbers.stream()
                .map(Words::getContent)
                .forEach(System.out::println);

        numbers.stream()
                .map(Words::getContent)
                .map(String::length)
                .forEach(System.out::println);
    }




    public static class Words {
        public Words(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String content;
    }
}
