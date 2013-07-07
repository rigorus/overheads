package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.NaturalId;


@Entity
@Table(name = "POSITION_INFO")
public class PositionInfo implements Serializable {

    @Id
    @Column(name = "POSITION_ID")
    private int id;
    
    @NaturalId(mutable = true)
    @Column(name = "SHORT_NAME", unique = true, nullable = false, length = 500)
    private String shortName;
        
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @Column(name = "COMMENT", length = 2000)
    private String comment;
   
    @Column(name = "NEXT_PRICE")
    private int nextPrice;
    
    @Column(name = "NEXT_PRICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date changePriceDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNextPrice() {
        return nextPrice;
    }

    public void setNextPrice(int nextPrice) {
        this.nextPrice = nextPrice;
    }

    public Date getChangePriceDate() {
        return changePriceDate;
    }

    public void setChangePriceDate(Date changePriceDate) {
        this.changePriceDate = changePriceDate;
    }
}
