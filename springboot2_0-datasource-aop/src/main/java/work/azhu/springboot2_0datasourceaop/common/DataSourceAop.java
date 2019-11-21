package work.azhu.springboot2_0datasourceaop.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/11/21 21:23
 **/
@Aspect
@Component
public class DataSourceAop {
    @Pointcut("!@annotation(work.azhu.springboot2_0datasourceaop.annotation.Master) " +
            "&& (execution(* work.azhu.springboot2_0datasourceaop.service..*.query*(..)) " +
            "|| execution(* work.azhu.springboot2_0datasourceaop.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(work.azhu.springboot2_0datasourceaop.annotation.Master) " +
            "|| execution(* work.azhu.springboot2_0datasourceaop.service..*.insert*(..)) " +
            "|| execution(* work.azhu.springboot2_0datasourceaop.service..*.add*(..)) " +
            "|| execution(* work.azhu.springboot2_0datasourceaop.service..*.update*(..)) " +
            "|| execution(* work.azhu.springboot2_0datasourceaop.service..*.edit*(..)) " +
            "|| execution(* work.azhu.springboot2_0datasourceaop.service..*.delete*(..)) " +
            "|| execution(* work.azhu.springboot2_0datasourceaop.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
        System.out.println("切点 readPointcut");
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
        System.out.println("切点 writePointcut");
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
