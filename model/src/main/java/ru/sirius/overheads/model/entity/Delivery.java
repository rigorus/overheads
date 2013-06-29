package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "DELIVERY")
public class Delivery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DELIVERY_ID")    
    private int id;
    
    @Column(name = "DELIVERY_DATE")
    @Temporal(TemporalType.DATE)    
    private Date date;         
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")    
    private Set<DeliveryPosition> positions;
    
    public Delivery() {
    }

    public Delivery(Date date) {
        this.date = date;
    }

    public int getDeliveryId() {
        return id;
    }

    public void setDeliveryId(int deliveryId) {
        this.id = deliveryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
