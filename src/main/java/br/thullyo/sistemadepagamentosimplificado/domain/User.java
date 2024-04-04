package br.thullyo.sistemadepagamentosimplificado.domain;

import br.thullyo.sistemadepagamentosimplificado.DTO.UserDTO;
import br.thullyo.sistemadepagamentosimplificado.DTO.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    private String name;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private UserType type;

    public User(UserDTO dto) {
        this.balance = dto.balance();
        this.name = dto.name();
        this.document = dto.document();
        this.email = dto.email();
        this.password = dto.password();
        this.type = dto.type();
    }
}
