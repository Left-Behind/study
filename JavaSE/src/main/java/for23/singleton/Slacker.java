package for23.singleton;


/**
 * @author Azhu
 * @date 2019/8/21 14:31
 * 单例模式---懒汉式
 */
public class Slacker {

    private static Slacker instance;

    public static Slacker getInstance(){

        if(instance == null){
            instance = new Slacker();
        }
        return instance;
    }
}
