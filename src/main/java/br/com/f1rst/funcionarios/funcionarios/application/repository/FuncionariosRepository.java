package br.com.f1rst.funcionarios.funcionarios.application.repository;

import br.com.f1rst.funcionarios.funcionarios.domain.Funcionarios;

import java.util.List;
import java.util.UUID;

public interface FuncionariosRepository {
    Funcionarios salva(Funcionarios funcionarios);
    List<Funcionarios> buscaTodosFuncionarios();
    Funcionarios buscaFuncionariosAtravesId(UUID idFuncionarios);
    void deletaFuncionarios(Funcionarios funcionarios);
}
