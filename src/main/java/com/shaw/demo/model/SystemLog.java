package com.shaw.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_log")
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ipAddress;

    private Date createBy;

    private String remark;

    private String operateURL;

    private String operateBy;

    public SystemLog() {
    }

    public SystemLog(long id, String ipAddress, Date createBy, String remark, String operateURL, String operateBy) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.createBy = createBy;
        this.remark = remark;
        this.operateURL = operateURL;
        this.operateBy = operateBy;
    }

    public long getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public String getRemark() {
        return remark;
    }

    public String getOperateURL() {
        return operateURL;
    }

    public String getOperateBy() {
        return operateBy;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setOperateURL(String operateURL) {
        this.operateURL = operateURL;
    }

    public void setOperateBy(String operateBy) {
        this.operateBy = operateBy;
    }
}
