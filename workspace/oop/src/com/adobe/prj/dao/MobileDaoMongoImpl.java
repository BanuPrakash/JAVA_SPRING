package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;

public class MobileDaoMongoImpl implements MobileDao{
    @Override
    public void addMobile(Mobile mobile) {
        // db.mobiles.insert(mobile); mongo db statements
        System.out.println(mobile.getName() + " stored in mongo db!!!");
    }
}
