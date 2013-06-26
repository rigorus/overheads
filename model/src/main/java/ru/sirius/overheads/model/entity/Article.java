package ru.sirius.overheads.model.entity;
// Generated Jun 27, 2013 12:54:31 AM by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Article generated by hbm2java
 */
@Entity
@Table(name = "ARTICLE", catalog = "DB0001", uniqueConstraints =
        @UniqueConstraint(columnNames = "FULL_NAME"))
public class Article implements java.io.Serializable {

    private int articleId;
    private Classifier classifier;
    private String fullName;
    private String shortName;
    private String description;
    private String comment;

    public Article() {
    }

    public Article(int articleId, String fullName) {
        this.articleId = articleId;
        this.fullName = fullName;
    }

    public Article(int articleId, Classifier classifier, String fullName, String shortName, String description, String comment) {
        this.articleId = articleId;
        this.classifier = classifier;
        this.fullName = fullName;
        this.shortName = shortName;
        this.description = description;
        this.comment = comment;
    }

    @Id
    @Column(name = "ARTICLE_ID", unique = true, nullable = false)
    public int getArticleId() {
        return this.articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASSIFIER_ID")
    public Classifier getClassifier() {
        return this.classifier;
    }

    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }

    @Column(name = "FULL_NAME", unique = true, nullable = false, length = 1000)
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "SHORT_NAME", length = 500)
    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Column(name = "DESCRIPTION", length = 4000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "COMMENT", length = 2000)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
