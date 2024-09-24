package br.com.f1rst.funcionarios.funcionarios.infra;

import br.com.f1rst.funcionarios.funcionarios.domain.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FuncionariosSpringDataJPARepository extends JpaRepository<Funcionarios, UUID> {
}
