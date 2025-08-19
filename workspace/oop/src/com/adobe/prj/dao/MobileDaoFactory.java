package com.adobe.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
    private static String IMPL_CLASS = ""; // com.adobe.prj.dao.MobileDaoDatabaseImpl
    // static block is executed as soon as class is loaded
    // right place to load drivers, read config files
    static  {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        IMPL_CLASS = resourceBundle.getString("MOBILE_DAO"); // com.adobe.prj.dao.MobileDaoDatabaseImpl
    }
    public static  MobileDao getMobileDao() {
//        return new MobileDaoDatabaseImpl();
//        return  new MobileDaoMongoImpl();
        try {
            // Reflection API
            return (MobileDao) Class.forName(IMPL_CLASS).getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
