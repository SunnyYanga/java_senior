package com.yang.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yg
 * @date 2020/7/12 15:27
 */
@ConfigurationProperties(prefix = "yang.hello")
public class HelloProperties {

    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
