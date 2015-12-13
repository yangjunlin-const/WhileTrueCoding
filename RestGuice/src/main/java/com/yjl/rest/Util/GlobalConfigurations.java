package com.yjl.rest.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;

public class GlobalConfigurations {

    private static Properties properties = new LoadProperties().getProperties();

    public static int getMQServerPort() {
        return getIntValue(Constant.MQ_SERVER_PORT, Constant.DEFAULT_MQ_SERVER_PORT);
    }

    public static String getHomePath() {
        return properties.getProperty(Constant.HOME, "/mnt/restguice/");
    }

    private static int getIntValue(String key, int defaultValue) {
        Pattern pattern = Pattern.compile("[0-9]*");
        String value = properties.getProperty(key);
        if (value != null && !value.equals("") && pattern.matcher(value).matches()) {
            return Integer.parseInt(value);
        }
        return defaultValue;
    }

    public static void main(String[] args) {
        System.out.println(GlobalConfigurations.getMQServerPort());
    }

}

class LoadProperties {

    private static Properties properties = new Properties();

    protected Properties getProperties() {
        if (properties == null) {
            load();
        }
        return properties;
    }

    private void load() {
        // load from user home
        String userHome = System.getProperty("user.home");
        if (userHome != null) {
            File proFile = new File(userHome, Constant.PROPERTIES_FILE_NAME);
            InputStream istream = null;
            try {
                if (proFile != null && proFile.exists()) {
                    istream = new FileInputStream(proFile);
                    if (istream != null) {
                        properties.load(istream);
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (istream != null) {
                        istream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // load from resource folder META-INF
        InputStream metaInput = this.getClass().getClassLoader().getResourceAsStream("META-INF/" + Constant.PROPERTIES_FILE_NAME);
        if (metaInput == null) {
            metaInput = this.getClass().getClassLoader().getResourceAsStream(Constant.PROPERTIES_FILE_NAME);
        }
        if (metaInput != null) {
            try {
                properties.load(metaInput);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    metaInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //TODO log, failed to read properties file
    }
}
