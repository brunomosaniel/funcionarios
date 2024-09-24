package br.com.f1rst.funcionarios.funcionarios.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class FuncionariosRequest {
    @NotBlank
    private String nomeFuncionarios;
    @NotBlank
    private String designacao;
    @NotBlank
    private String salario;
    @NotBlank
    private String telefone;
    @NotBlank
    private String endereco;
}
