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
@Table(name = "TEMPLATE_POSITION")
public class TemplatePosition implements Serializable{

    @Id
    @Column(name = "TEMPLATE_POSITION_ID")
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "TEMPLATE_POSITION__TEMPLATE__FK")
    @JoinColumn(name = "TEMPLATE_ID", insertable = false, updatable = false)
    private Template template;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "TEMPLATE_POSITION__POSITION__FK")
    @JoinColumn(name = "POSITION_ID", insertable = false, updatable = false)
    private Position position;
    
    
    

}
