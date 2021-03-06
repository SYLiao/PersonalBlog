package com.shaw.demo.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @CreatedDate
    private Date createBy;

    private String email;

    private String name;

    private String ipAddress;

    private boolean isEffective;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public boolean isEffective() {
        return isEffective;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setEffective(boolean effective) {
        isEffective = effective;
    }
}
