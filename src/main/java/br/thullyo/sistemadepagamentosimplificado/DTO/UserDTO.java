package br.thullyo.sistemadepagamentosimplificado.DTO;

import java.math.BigDecimal;

public record UserDTO(
        String name,
        String password,
        String document,
        UserType type,
        String email,
        BigDecimal balance
) {
}
