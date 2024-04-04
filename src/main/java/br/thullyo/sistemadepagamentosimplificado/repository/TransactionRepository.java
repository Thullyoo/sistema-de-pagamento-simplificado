package br.thullyo.sistemadepagamentosimplificado.repository;

import br.thullyo.sistemadepagamentosimplificado.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<User, Long> {
}