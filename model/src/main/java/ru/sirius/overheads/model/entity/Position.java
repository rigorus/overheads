package ru.sirius.overheads.model.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POSITION")
public class Position implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POSITION_ID")
    private int id;
               
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Position parent;
  
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<Position> children = new HashSet<Position>(0);

    @Column(name = "IS_GROUP")
    private boolean group;
    
    @Column(name = "BREADTH_INDEX")
    private int breadthIndex;
    
    @Column(name = "DEBTH_INDEX")
    private int debthIndex;    
    
    @Column(name = "POSITION_NAME", length = 500)    
    private String name;
    
    @Column(name = "PRICE")
    private int price;
    
    @Column(name = "DELETED", nullable = false)
    private boolean deleted;
    
    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "POSITION_ID", updatable = false)
    private PositionInfo info;

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getParent() {
        return parent;
    }

    public void setParent(Position parent) {
        this.parent = parent;
    }

    public Set<Position> getChildren() {
        return children;
    }

    public void setChildren(Set<Position> children) {
        this.children = children;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public int getBreadthIndex() {
        return breadthIndex;
    }

    public void setBreadthIndex(int breadthIndex) {
        this.breadthIndex = breadthIndex;
    }

    public int getDebthIndex() {
        return debthIndex;
    }

    public void setDebthIndex(int debthIndex) {
        this.debthIndex = debthIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public PositionInfo getInfo() {
        return info;
    }

    public void setInfo(PositionInfo info) {
        this.info = info;
    }        
}
