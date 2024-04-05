package br.thullyo.sistemadepagamentosimplificado.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "TRANSACTIONS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private User payee;

    private LocalDateTime time_transaction;

    private BigDecimal amount;

    public Transaction(User payer, User payee, BigDecimal amount, LocalDateTime time_transaction){
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
        this.time_transaction =  time_transaction ;
    }
}
