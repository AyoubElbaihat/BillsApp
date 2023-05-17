package com.example.bill.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate invoiceDate;

    private LocalDate dueDate;
    @NonNull
    private String paymentMethod;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;


}
