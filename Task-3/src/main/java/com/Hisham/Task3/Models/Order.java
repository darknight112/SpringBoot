package com.Hisham.Task3.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    Product product;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Product> cart;

    int quantity;
    String shipping_address;


}
