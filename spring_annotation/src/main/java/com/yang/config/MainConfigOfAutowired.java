package com.yang.config;

import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：
 *      Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系赋值
 *
 * 1.Autowired
 *      默认优先按照类型去容器中找对应的组件
 *      如果找个多个相同组件，将属性名作为id去容器中查找
 *      使用@Qualifier指定id
 *      默认要将属性赋值好，没有会报错，可以使用@AutoWired(required=false)
 *      使用@Primary,让Spring进行自动装配的时候，默认使用首选的bean，也可以继续使用@Qualifier指定
 *
 *
 * 2.Spring还支持使用@Resource和@Inject[java规范的注解]
 * @author yg
 * @date 2020/5/2 8:00
 */
@Configuration
public class MainConfigOfAutowired {
}
