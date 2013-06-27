package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSIFIER", catalog = "DB0001", schema="PUBLIC")
public class Classifier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLASSIFIER_ID", unique = true, nullable = false)
    private int classifierId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Classifier parent;
    
    @Column(name = "CLASSIFIER_NAME", length = 200)
    private String classifierName;
    
    @Column(name = "BREADTH_INDEX", nullable = false)
    private int breadthIndex;
    
    @Column(name = "DEPTH_INDEX", nullable = false)
    private int depthIndex;
    
    @Column(name = "COMMENT", length = 2000)
    private String comment;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<Classifier> children = new HashSet<Classifier>(0);
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classifier")
    private Set<Article> articles = new HashSet<Article>(0);

    public Classifier() {
    }

    public Classifier(int classifierId, int breadthIndex, int depthIndex) {
        this.classifierId = classifierId;
        this.breadthIndex = breadthIndex;
        this.depthIndex = depthIndex;
    }

    public Classifier(int classifierId, Classifier classifier, String classifierName, int breadthIndex, int depthIndex, String comment, Set<Classifier> children, Set<Article> articles) {
        this.classifierId = classifierId;
        this.parent = classifier;
        this.classifierName = classifierName;
        this.breadthIndex = breadthIndex;
        this.depthIndex = depthIndex;
        this.comment = comment;
        this.children = children;
        this.articles = articles;
    }

    public int getClassifierId() {
        return this.classifierId;
    }

    public void setClassifierId(int classifierId) {
        this.classifierId = classifierId;
    }

    public Classifier getClassifier() {
        return this.parent;
    }

    public void setClassifier(Classifier classifier) {
        this.parent = classifier;
    }

    public String getClassifierName() {
        return this.classifierName;
    }

    public void setClassifierName(String classifierName) {
        this.classifierName = classifierName;
    }

    public int getBreadthIndex() {
        return this.breadthIndex;
    }

    public void setBreadthIndex(int breadthIndex) {
        this.breadthIndex = breadthIndex;
    }

    public int getDepthIndex() {
        return this.depthIndex;
    }

    public void setDepthIndex(int depthIndex) {
        this.depthIndex = depthIndex;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Classifier> getChildren() {
        return this.children;
    }

    public void setChildren(Set<Classifier> classifiers) {
        this.children = classifiers;
    }

    public Set<Article> getArticles() {
        return this.articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
