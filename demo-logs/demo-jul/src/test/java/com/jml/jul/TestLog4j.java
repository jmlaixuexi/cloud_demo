package com.jml.jul;

import org.apache.log4j.*;
import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;

import java.io.PrintWriter;

public class TestLog4j {

    public static final Logger LOGGER = Logger.getLogger(TestLog4j.class.getName());

    @Test
    public void testLog4j(){

        //默认配置文件
        //BasicConfigurator.configure();

        Logger rootLogger = Logger.getRootLogger();
        //构建consoleAppender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        //构建consoleAppender需要一个输出流
        consoleAppender.setWriter(new PrintWriter(System.out));
        //需要一个layout
        Layout layout = new Layout() {
            @Override
            public void activateOptions() {

            }

            @Override
            public String format(LoggingEvent loggingEvent) {
                return loggingEvent.getTimeStamp() + " " + loggingEvent.getThreadName() + "\r\n";
            }

            @Override
            public boolean ignoresThrowable() {
                return false;
            }
        };
        //consoleAppender.setLayout(layout);

        SimpleLayout simpleLayout = new SimpleLayout();
        //consoleAppender.setLayout(simpleLayout);

        PatternLayout patternLayout = new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN);
        consoleAppender.setLayout(patternLayout);

        //数据库实现
        //JDBCAppender job = new JDBCAppender();

        rootLogger.addAppender(consoleAppender);


        LOGGER.debug("main()");
        LOGGER.info("INFO");
        LOGGER.warn("WARN");
        LOGGER.error("ERROR");
        LOGGER.fatal("FATAL");
        LOGGER.log(Priority.DEBUG, "Testing a log message use a alternate form");

        while (true){
            LOGGER.info("1 - INFO");
            LOGGER.warn("2 - WARN");
            LOGGER.error("3 - ERROR");
            LOGGER.fatal("4 - FATAL");
        }
    }


    @Test
    public void testReadConfig(){
        LOGGER.debug("main()");
        LOGGER.info("INFO");
        LOGGER.warn("WARN");
        LOGGER.error("ERROR");
        LOGGER.fatal("FATAL");
        LOGGER.log(Priority.DEBUG, "Testing a log message use a alternate form");

    }
}
