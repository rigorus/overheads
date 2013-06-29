package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CHARGES")
public class Charges implements Serializable{
    
    @Id
    @Column(name = "CHARGES_ID")
    private int id;
    
    @Column(name = "CHARGES_DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Column(name = "AMOUNT", nullable = false)
    private int amount;
    
    @Column(name = "DESCRIPTION", nullable = false, length = 2000)
    private String description;
        
}
