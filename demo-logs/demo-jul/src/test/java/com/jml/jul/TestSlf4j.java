package com.jml.jul;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlf4j {

    public static final Logger LOGGER = LoggerFactory.getLogger(TestSlf4j.class);

    @Test
    public void testSlf4j(){
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.trace("trace");
    }

}
