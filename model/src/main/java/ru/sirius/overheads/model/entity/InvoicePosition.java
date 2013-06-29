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
@Table(name = "INVOICE_POSITION")
public class InvoicePosition implements Serializable{
    
    @Id
    @Column(name = "INVOICE_POSITION_ID")
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "INVOICE_POSITION__INVOICE__FK")    
    @JoinColumn(name = "INVOICE_ID", insertable = false, updatable = false)
    private Invoice invoice;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "INVOICE_POSITION__POSITION__FK")
    @JoinColumn(name = "POSITION_ID", insertable = false, updatable = false)
    private Position position;

    @Column(name = "QUANTITY")
    private int quantiry;

    
    
    
}
