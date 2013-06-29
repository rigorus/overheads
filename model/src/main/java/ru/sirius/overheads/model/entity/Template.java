package ru.sirius.overheads.model.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

  
@Entity  
@Table(name = "TEMPLATE")
public class Template implements Serializable{
    
    @Id
    @Column(name = "TEMPLATE_ID")
    private int id;
    
    @Column(name = "TEMPLATE_NAME", nullable = false, length = 256)
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "template")
    private Set<TemplatePosition> positions;
}
