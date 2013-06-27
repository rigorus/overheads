package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERY_ARTICLE", catalog = "DB0001", schema = "PUBLIC")
public class DeliveryArticle implements Serializable{
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)     
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    public DeliveryArticle() {
    }

    public DeliveryArticle(Delivery delivery, Article article) {
        this.delivery = delivery;
        this.article = article;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }    
}
