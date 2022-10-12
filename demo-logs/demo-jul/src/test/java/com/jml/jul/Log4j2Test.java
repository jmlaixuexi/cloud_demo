package com.jml.jul;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4j2Test {
    private static final Logger LOG = LogManager.getLogger(Log4j2Test.class.getName());

    // 打印各种级别的日志用于测试
    @Test
    public void logAll() throws InterruptedException {
        //按照优先级从小到大排序:
        //ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF
        //如果没有设置系统属性，
        //则在classpath路径中按照顺序查找如下4个文件:
        //log4j2-test.properties
        //log4j2-test.yaml or log4j2-test.yml
        //log4j2-test.json or log4j2-test.jsn
        //log4j2-test.xml

        LOG.trace("trace level log");
        LOG.debug("debug level log");
        LOG.info("info level log");
        LOG.error("error level log");
        LOG.fatal("fatal level log");
        // 设置休眠时间(单位ms)，控制日志打印速度
        Thread.sleep(3);
    }
}
