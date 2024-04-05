package br.thullyo.sistemadepagamentosimplificado.DTO;

import br.thullyo.sistemadepagamentosimplificado.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResult {
    private Transaction transaction;
    private String errorMessage;
}
