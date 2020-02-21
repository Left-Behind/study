package for23.singleton;


/**
 * @author Azhu
 * @date 2019/8/21 14:31
 * 单例模式---饿汉式
 */
public class Hungry {

    private static Hungry instance = new Hungry();

    public static Hungry getInstance(){
        return instance;
    }
}
