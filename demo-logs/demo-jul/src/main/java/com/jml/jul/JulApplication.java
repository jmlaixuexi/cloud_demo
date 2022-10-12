package com.jml.jul;

import java.util.logging.Logger;

public class JulApplication {

    private static final Logger logger = Logger.getLogger("JulApplication");

    public static void main(String[] args) {
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

}
