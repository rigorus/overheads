package ru.sirius.overheads.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ARTICLE", catalog="DB0001", schema="PUBLIC", uniqueConstraints =
        @UniqueConstraint(columnNames = "FULL_NAME"))
public class Article implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ARTICLE_ID")
    private int articleId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASSIFIER_ID")
    private Classifier classifier;
    
    @Column(name = "FULL_NAME", unique = true, nullable = false, length = 1000)
    private String fullName;
    
    @Column(name = "SHORT_NAME", length = 500)
    private String shortName;
    
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;
    
    @Column(name = "COMMENT", length = 2000)
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

    public int getArticleId() {
        return this.articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Classifier getClassifier() {
        return this.classifier;
    }

    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
