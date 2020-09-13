package com.yang.config;

import com.yang.bean.Color;
import com.yang.bean.ColorFactoryBean;
import com.yang.bean.Person;
import com.yang.condition.Linux;
import com.yang.condition.MyImportSelector;
import com.yang.condition.Windows;
import org.springframework.context.annotation.*;

/**
 * 给容器中注册组件
 * 1.包扫描+组件标注注解（@Controller @Service @Repository @Component）[自己写的]
 * 2.@Bean[导入的第三方包里的组件]
 * 3.@Import[快速给容器中导入一个组件]
 *      1.@Import()
 *      2.ImportSeletor:返回需要导入组件的全类名数组
 *      3.ImportBeanDefinitionRegistrar
 *4.使用spring提供的FactoryBean
 *
 * @author yg
 * @date 2020/5/1 9:52
 */
@Configuration
@Import({Color.class, MyImportSelector.class})
public class MainConfig2 {

//    @Scope(value = "prototype")
    @Lazy
    @Bean("person")
    public Person person1() {
        return new Person("李四", "20");
    }

    @Conditional({Windows.class})
    @Bean("li2")
    public Person person2() {
        return new Person("李2", "20");
    }

    @Conditional({Linux.class})
    @Bean("li3")
    public Person person3() {
        return new Person("李3", "20");
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
