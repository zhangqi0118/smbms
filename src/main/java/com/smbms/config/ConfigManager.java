package com.smbms.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager configManager;
    private static Properties properties;
    private ConfigManager() {
        String configFile = "db.properties";
        properties = new Properties();
        InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized  ConfigManager getInstance() {
        if(configManager == null) {
            configManager = new ConfigManager();
        }
        return configManager;
    }
    public String getString(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(ConfigManager.getInstance().getString("druid.url"));
    }
}
