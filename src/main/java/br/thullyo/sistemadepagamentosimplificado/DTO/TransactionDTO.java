package br.thullyo.sistemadepagamentosimplificado.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        Long payeeID,
        Long payerID,
        BigDecimal amount
)  {
}
