package com.jml.jul;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestJCL {

    public static final Log LOGGER = LogFactory.getLog(TestJCL.class);

    @Test
    public void testSlf4j(){
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.trace("trace");
    }
}
