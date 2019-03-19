package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
*
arg() 限制连接点匹配参数为指定类型的执行方法
@args() 限制连接点匹配参数由指定注解标注的执行方法
execution() 用于匹配是连接点的执行方法
this() 限制连接点匹配AOP代理的bean引用为指定类型的类
target 限制连接点匹配目标对象为指定类型的类
@target() 限制连接点匹配特定的执行对象， 这些对象对应的类要具有指定类型的注解
within() 限制连接点匹配指定的类型
@within() 限制连接点匹配指定注解所标注的类型（ 当使用Spring AOP时， 方法定义在由指定的注解所标注的类里）
@annotation 限定匹配带有指定注解的连接点
*
* */


/*
*
* @After 通知方法会在目标方法返回或抛出异常后调用
@AfterReturning 通知方法会在目标方法返回后调用
@AfterThrowing 通知方法会在目标方法抛出异常后调用
@Around 通知方法会将目标方法封装起来
@Before 通知方法会在目标方法调用之前执行
*
* */

@Component
@Aspect
public class Audience {

    @Before("execution(* aop.Performance.perform(..))") //返回类型　方法所属的类.方法(参数)
    public void silenceCellPhones() {
        System.out.println("silenceCellPhone");
    }

    @AfterReturning("execution(* aop.Performance.perform(..))")
    public void applause() {
        System.out.println("applause");
    }

    @AfterThrowing("execution(* aop.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("demandRefund");
    }

    @Pointcut("execution(* aop.Performance.performs(int)) && args(i)")
    public void performances(int i) {}

    @Around("performances(i)")
    public void watchPerformance(ProceedingJoinPoint jp,int i) {
        try {
            System.out.println("11"+i);
            jp.proceed();
            System.out.println("22"+i);
        } catch (Throwable e) {
            System.out.println("33"+i);
        }
    }
}
