package com.jml.jul;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.layout.TTLLLayout;
import ch.qos.logback.classic.spi.Configurator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.spi.ContextAwareBase;


public class MyConfigurator extends ContextAwareBase implements Configurator {
    public MyConfigurator() {
    }


    public void configure(LoggerContext lc) {
        addInfo("Setting up default configuration.");

        ConsoleAppender<ILoggingEvent> ca = new ConsoleAppender<ILoggingEvent>();
        ca.setContext(lc);
        ca.setName("console");
        LayoutWrappingEncoder<ILoggingEvent> encoder = new LayoutWrappingEncoder<ILoggingEvent>();
        encoder.setContext(lc);

        // same as
        PatternLayout layout = new PatternLayout();
        layout.setPattern("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
        //TTLLLayout layout = new TTLLLayout();

        layout.setContext(lc);
        layout.start();
        encoder.setLayout(layout);

        ca.setEncoder(encoder);
        ca.start();


        FileAppender<ILoggingEvent> fa = new FileAppender<ILoggingEvent>();
        fa.setContext(lc);
        fa.setName("file");
        fa.setFile("D:\\work\\project\\cloud_demo\\demo-logs\\demo-jul\\logs\\File.log");
        PatternLayoutEncoder ple = new PatternLayoutEncoder();
        ple.setContext(lc);
        ple.setPattern("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
        ple.start();
        fa.setEncoder(ple);
        fa.start();

        RollingFileAppender<ILoggingEvent> rfa = new RollingFileAppender<>();
        SizeAndTimeBasedRollingPolicy policy = new SizeAndTimeBasedRollingPolicy();;
        rfa.setRollingPolicy(policy);

        Logger rootLogger = lc.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.addAppender(ca);
        rootLogger.addAppender(fa);
    }
}
