package com.yjl.rest.Util;

import java.util.logging.Logger;

public interface Constant {

    static Logger logger = Logger.getLogger("restguice");

    public static final String PROPERTIES_FILE_NAME = "restguice.properties";

    //MQ related configuration keys
    public static final String MQ_SERVER_PORT = "mq.server.port";
    public static final int DEFAULT_MQ_SERVER_PORT = 18000;

    public static final String HOME = "restguice.home";
}
