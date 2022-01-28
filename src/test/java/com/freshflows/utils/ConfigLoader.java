package com.freshflows.utils;

import java.util.Properties;

public class ConfigLoader   {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }
    public static ConfigLoader getInstance(){
        if(configLoader ==null)
        {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

        public String getBaseUrl(){
            String prop = properties.getProperty("baseURL");
            if(prop != null)  return prop;
            else throw new RuntimeException("property baseURL is not specified in the config.properties file");
        }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null)  return prop;
        else throw new RuntimeException("property username is not specified in the config.properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null)  return prop;
        else throw new RuntimeException("property password is not specified in the config.properties file");
    }


    public String getorgName(){
        String prop = properties.getProperty("organization");
        if(prop != null)  return prop;
        else throw new RuntimeException("property organization is not specified in the config.properties file");
    }

    public String getmailinatorURL(){
        String prop = properties.getProperty("mailinatorURL");
        if(prop != null)  return prop;
        else throw new RuntimeException("property mailinator URL is not specified in the config.properties file");

    }
    public String getmailinatorID(){
        String prop = properties.getProperty("mailinatorID");
        if(prop != null)  return prop;
        else throw new RuntimeException("property mailinatorID is not specified in the config.properties file");
    }
}
