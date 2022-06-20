package com.shop.supermarket.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @Column(name = "item_id")
    private int id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "cost")
    private int cost;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "username")
    )
    private List<Customer> customers;

    public void addCustomer(Customer customer)
    {
        if(customers==null)
        {
            customers=new ArrayList<>();
        }
        customers.add(customer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }


    public Books() {
    }


    public Books(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
