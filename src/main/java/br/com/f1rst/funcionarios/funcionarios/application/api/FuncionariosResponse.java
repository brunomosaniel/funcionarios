package br.com.f1rst.funcionarios.funcionarios.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class FuncionariosResponse {
    private UUID idFuncionarios;
}
