package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable{

    @Id
    @Column(name = "INVOICE_ID")
    private int name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "INVOICE__PARTNER__FK")
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;
                   
    @Column(name = "INVOICE_DATE")
    @Temporal(TemporalType.DATE)   
    private Date date;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
    private Set<InvoicePosition> positions;

    
}
