package com.jml.jul;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class TestJul {

    private static final Logger LOGGER = Logger.getLogger("com.jml.jul.TestJul");

    @Test
    public void testJUL() throws IOException {

        //去掉默认配置
        LOGGER.setUseParentHandlers(false);

        //自定义handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        consoleHandler.setLevel(Level.ALL);

        //构建fileHandler
        FileHandler fileHandler = new FileHandler("D:\\work\\project\\cloud_demo\\demo-logs\\demo-jul\\logs\\app.log",true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.ALL);

        LOGGER.setLevel(Level.ALL);
        LOGGER.addHandler(consoleHandler);
        LOGGER.addHandler(fileHandler);
        LOGGER.severe("severe");
        LOGGER.warning("warning");
        LOGGER.info("info");
        LOGGER.fine("fine");
        LOGGER.finer("finer");
        LOGGER.finest("finest");
    }

    @Test
    public void testParent(){
        //任何一个logger都是单例的，名字相同的只有一个
        Logger logger = Logger.getLogger("com.jml.jul");
        logger.setLevel(Level.ALL);

        //去掉默认配置
        logger.setUseParentHandlers(false);

        //自定义handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        consoleHandler.setLevel(Level.ALL);

        logger.addHandler(consoleHandler);

        //创建一个com.jml.jul
        Logger julLogger = Logger.getLogger("com.jml.jul.TestJul");
        System.out.println(LOGGER==julLogger);

        Logger parent = julLogger.getParent();
        System.out.println(parent.getName());
        System.out.println(julLogger.getParent());

        julLogger.info("info");
        julLogger.fine("fine");
    }

    @Test
    public void testFormatter(){
        //去掉默认配置
        LOGGER.setUseParentHandlers(false);

        //自定义handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getThreadID() + " " + record.getLoggerName() + " " + record.getMessage() ;
            }
        });
        consoleHandler.setLevel(Level.ALL);

        LOGGER.setLevel(Level.ALL);
        LOGGER.addHandler(consoleHandler);
        LOGGER.severe("severe");
        LOGGER.warning("warning");
        LOGGER.info("info");
        LOGGER.fine("fine");
        LOGGER.finer("finer");
        LOGGER.finest("finest");
    }

    @Test
    public void testStringFormat(){
        String x = String.format("%s-%s","张三","李四");

        System.out.println(x);
    }

    @Test
    public void readConfig() throws IOException {
        LogManager manager = LogManager.getLogManager();

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("logging.properties");

        manager.readConfiguration(in);

        Logger logger = Logger.getLogger(TestJul.class.getName());
        logger.fine("fine");
        logger.finer("finer");
    }

}
