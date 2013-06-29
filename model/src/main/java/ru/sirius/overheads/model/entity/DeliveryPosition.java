package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "DELIVERY_POSITION")
public class DeliveryPosition implements Serializable{

    @Id
    @Column(name = "DELIVERY_POSITION_ID")
    private int id;;

    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "DELIVERY_POSITION__DELIVERY__FK")
    @JoinColumn(name = "DELIVERY_ID", insertable = false, updatable = false)
    private Delivery delivery;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "DELIVERY_POSITION__POSITION__FK")
    @JoinColumn(name = "POSITION_ID", insertable = false, updatable = false)
    private Position position;
    
    @Column(name="PRICE")
    private int price;
    
    @Column(name="INITIAL_QUANTITY")
    private int initialQuantiry;

    @Column(name = "CURRENT_QUANTITY")
    private int currentQuantiry;

    
    public DeliveryPosition() {
    }
  
}
