package com.example.bill.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private String paymentMethod;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;
}
