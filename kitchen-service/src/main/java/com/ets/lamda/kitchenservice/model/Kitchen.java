package com.ets.lamda.kitchenservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "kitchen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kitchen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        NEW, PREPARING, READY
    }

    public Kitchen(Long orderId, String ticketNumber, Status status) {
        this.orderId = orderId;
        this.ticketNumber = ticketNumber;
        this.status = status;
    }
}
