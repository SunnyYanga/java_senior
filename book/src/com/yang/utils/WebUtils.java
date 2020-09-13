package com.yang.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yg
 * @date 2020/4/11 11:13
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String stringInt, int defaultValue) {
        try {
            return Integer.parseInt(stringInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }

        return defaultValue;
    }
}
