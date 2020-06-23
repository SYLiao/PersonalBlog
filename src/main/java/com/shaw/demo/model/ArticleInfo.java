package com.shaw.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.Date;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_article_info")
public class ArticleInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String summary;

    private boolean isTop;

    private int traffic;

    @CreatedDate
    private Date createBy;

    @LastModifiedDate
    private Date modifiedBy;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contend_id", referencedColumnName = "id")
    private ArticleContent articleContent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleInfo")
    @JsonManagedReference
    private List<ArticleComment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleInfo")
    @JsonManagedReference
    private List<ArticlePicture> pictures;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleInfo")
    @JsonManagedReference
    private List<ArticleSort> sorts;

    public ArticleInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ArticleContent getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(ArticleContent articleContent) {
        this.articleContent = articleContent;
    }

    public List<ArticleComment> getComments() {
        return comments;
    }

    public void setComments(List<ArticleComment> comments) {
        this.comments = comments;
    }

    public List<ArticlePicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<ArticlePicture> pictures) {
        this.pictures = pictures;
    }

    public List<ArticleSort> getSorts() {
        return sorts;
    }

    public void setSorts(List<ArticleSort> sorts) {
        this.sorts = sorts;
    }
}
