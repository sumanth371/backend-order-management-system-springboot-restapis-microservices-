package com.arjun.orderser.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="t_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;

    @OneToMany(cascade =CascadeType.ALL)
    private List<orderLineItems> orderLineItemsList;

}
