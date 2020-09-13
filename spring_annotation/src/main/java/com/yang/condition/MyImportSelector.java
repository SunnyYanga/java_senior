package com.yang.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yg
 * @date 2020/5/1 11:16
 */
public class MyImportSelector implements ImportSelector {

//    返回值就是要导入到容器中组件全类名
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[0];
    }
}
