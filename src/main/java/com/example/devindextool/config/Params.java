package com.example.devindextool.config;

/**
 * Created by hongkailiu on 2016-04-22.
 */
public class Params {
    public static final String BASE_IP = "127.0.0.1";

    public static final String MONGO_IP = BASE_IP;
    public static final int MONGO_HTTP_PORT = 28017;

    public static final String CALCULATOR_SERVICE_IP = BASE_IP;
    public static final int CALCULATOR_SERVICE_PORT = 8090;

    public static final String COLON = ":";
    public static final String SLASH = "/";
    public static final String HTTP_PROTOCOL = "http" + COLON + SLASH + SLASH;

    public static final String TEST_MONGO = "testmongo";
    public static final String PERSON = "person";

    public static final String MIME_TYPE_TEXT_PLAIN = "text/plain";

    public static final String TESTMONGO_SEARCH_PATH = SLASH + TEST_MONGO + SLASH + "_search";
    public static final String TESTMONGO_PERSON_SEARCH_PATH = SLASH + TEST_MONGO + SLASH + PERSON + SLASH + "_search";

}
