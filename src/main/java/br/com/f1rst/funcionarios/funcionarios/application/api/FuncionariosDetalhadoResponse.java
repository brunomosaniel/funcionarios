package br.com.f1rst.funcionarios.funcionarios.application.api;

import br.com.f1rst.funcionarios.funcionarios.domain.Funcionarios;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;
@Value
public class  FuncionariosDetalhadoResponse {
    private UUID idFuncionarios;
    private String nomeFuncionarios;
    private String designacao;
    private String salario;
    private String telefone;
    private String endereco;
    private LocalDateTime dataHoraDoCadastro;

    public FuncionariosDetalhadoResponse(Funcionarios funcionarios) {
        this.idFuncionarios = funcionarios.getIdFuncionarios();
        this.nomeFuncionarios = funcionarios.getNomeFuncionarios();
        this.designacao = funcionarios.getDesignacao();
        this.salario = funcionarios.getSalario();
        this.telefone = funcionarios.getTelefone();
        this.endereco = funcionarios.getEndereco();
        this.dataHoraDoCadastro = funcionarios.getDataHoraDoCadastro();
    }
}
