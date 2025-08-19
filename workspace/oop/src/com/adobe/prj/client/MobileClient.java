package com.adobe.prj.client;

import com.adobe.prj.dao.MobileDao;
import com.adobe.prj.dao.MobileDaoFactory;
import com.adobe.prj.entity.Mobile;

public class MobileClient {
    public static void main(String[] args) {

//        MobileDao mobileDao = new MobileDaoDatabaseImpl(); // always program to interface
//        MobileDao mobileDao = new MobileDaoMongoImpl(); // switching between strategies
        // abstraction using factory
       // MobileDaoFactory mobileDaoFactory = new MobileDaoFactory(); // waste because member is static
        MobileDao mobileDao = MobileDaoFactory.getMobileDao();
       performAdd(mobileDao);
       fetch(mobileDao);
    }
    // OCP
    private  static  void performAdd(MobileDao mobileDao) {
        Mobile mobile = new Mobile(45, "Samsung Fold", 2_10_000.00, "5G");
        mobileDao.addMobile(mobile);
    }

    private static void fetch(MobileDao mobileDao) {

    }
}
