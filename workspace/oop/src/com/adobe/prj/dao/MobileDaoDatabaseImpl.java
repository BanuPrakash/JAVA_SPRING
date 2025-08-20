package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;

public class MobileDaoDatabaseImpl implements MobileDao{
    @Override
    public void addMobile(Mobile mobile) {
        Object
        // INSERT INTO ... SQL statements
        System.out.println(mobile.getName() + " stored in MySQL database!!");
    }
}
