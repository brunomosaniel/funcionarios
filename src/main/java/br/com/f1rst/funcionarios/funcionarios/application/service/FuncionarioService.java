package br.com.f1rst.funcionarios.funcionarios.application.service;

import br.com.f1rst.funcionarios.funcionarios.application.api.*;

import java.util.List;
import java.util.UUID;

public interface FuncionarioService {
    FuncionariosResponse criaFuncionario(FuncionariosRequest funcionariosRequest);
    List<FuncionariosListResponse> buscaTodosFuncionarios();
    FuncionariosDetalhadoResponse buscaFuncionariosAtravesId(UUID idFuncionarios);
    void deletaFuncionariosAtravesid(UUID idFuncionarios);
    void patchAlteraFuncionarios(UUID idFuncionarios, FuncionariosAlteracaoResquet funcionariosAlteracaoResquet);
}
