package com.yang.config;

import com.yang.aop.LogAspect;
import com.yang.aop.MathCalculator;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:[动态代理]
 *      程序运行期间动态的将某段代码插入到指定方法指定位置进行运行的编程方式
 *
 * 1. 导入aop模块： spring的 AOP
 * 2. 定义一个业务逻辑类（MathCalculator）
 * 3. 定义一个日志切面类(logAspect)
 *      通知方法：
 *          前置通知：@Before
 *          后置通知: @After
 *          返回通知:@AfterReturning
 *          异常通知@AfterThrowing
 *          环绕通知@Around
 * 4. 给切面类的目标方法标注何时何地运行（通知注解）
 * 5.将切面类和业务逻辑类(目标方法所在类)都加入到容器中
 * 6.告诉Spring哪个类是切面类(给切面类加注解@Aspect)
 * 7.给配置类加入@EnableAspectJAutoProxy开启基于注解版的
 *
 * @author yg
 * @date 2020/5/2 10:10
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
