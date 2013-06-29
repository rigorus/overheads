package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTNER")
public class Partner implements Serializable{
    
    @Id
    @Column(name = "PARENT_ID")    
    private int id;
        
}
