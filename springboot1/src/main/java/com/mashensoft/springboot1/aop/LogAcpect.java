package com.mashensoft.springboot1.aop;//package com.mashensoft.springboot1.aop;
//
//import com.mashensoft.springboot1.model.User;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LogAcpect {
//    @Pointcut(value = "execution(public * com.mashensoft.springboot1.service.*.*(..))")
//    public void pointCut() {
//
//    }
//
//    @Before("pointCut()")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("before");
//    }
//
//    /**
//     * 方法执行完的时候
//     *
//     * @param joinPoint
//     */
//    @After("pointCut()")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("after");
//    }
//
//    /**
//     * 方法return。返回值，获取返回值，检查返回值，对它进行各种操作
//     *
//     * @param result
//     */
//    @AfterReturning(returning = "result", pointcut = "pointCut()")
//    public void afterReturn(Object result) {
//        System.out.println("AfterReturning");
//    }
//
//    //    @After("pointCut()")
////    public void after3(JoinPoint joinPoint){
////        System.out.println("After");
////    }
//    @AfterThrowing("pointCut()")
//    public void afterThrowing(JoinPoint jp) {
//        System.out.println("AfterTrowing");
//    }
//
//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("around开始");
//        Object obj = jp.proceed();
//        System.out.println("around结束");
//        return obj;
//    }
//}
