package for23.singleton;

/**
 * @author Azhu
 * @date 2019/8/21 14:31
 * 单例模式---静态内部类式
 */
public class StaticInnerClass {

    private static class SingetonHolder{
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    public static final StaticInnerClass getInstance(){
        return SingetonHolder.instance;
    }

}
