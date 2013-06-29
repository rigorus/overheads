package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.NaturalId;


@Entity
@Table(name = "POSITION_INFO", uniqueConstraints = @UniqueConstraint(columnNames = "FULL_NAME"))
public class PositionInfo implements Serializable {

    @Id
    @Column(name = "POSITION_ID")
    private int id;
    
    @NaturalId(mutable = true)
    @Column(name = "FULL_NAME", unique = true, nullable = false, length = 1000)
    private String fullName;
        
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @Column(name = "COMMENT", length = 2000)
    private String comment;
   
    @Column(name = "NEXT_PRICE")
    private int nextPrice;
    
    @Column(name = "NEXT_PRICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date changePriceDate;
   
}
