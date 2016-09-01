package com.feicui.contacts.entity;

/**
 * Created by Administrator on 2016/8/26.
 * 电话类型实体类
 */

public class PhoneTypeEntity {

    //电话类型名称
    private String typeName;

    //子表表名
    private String subTable;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSubTable() {
        return subTable;
    }

    public void setSubTable(String subTable) {
        this.subTable = subTable;
    }
}
