package com.shaw.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_view")
public class SystemView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ipAddress;

    private Date createBy;

    public SystemView() {
    }

    public SystemView(long id, String ipAddress, Date createBy) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.createBy = createBy;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }
}
