package org.afirikaofe.kpage.infrastructure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static final String APPLICATION_PROPERTIES = "application.properties";

    private static Properties instance;

    public static final Properties getInstance() {
        if (instance == null) {
            instance = new Properties();
        }
        return instance;
    }

    public Properties load() throws IOException {
        Properties props = new Properties();
        String propFileName = APPLICATION_PROPERTIES;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            props.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        return props;
    }
}
