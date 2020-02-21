package for23.singleton;

/**
 * @author Azhu
 * @date 2019/8/21 14:31
 * 单例模式---双重检查式
 */
public class DoubleCheck {

    private static volatile  DoubleCheck instance;

    public static DoubleCheck getInstance() {

        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
