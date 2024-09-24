package br.com.f1rst.funcionarios.funcionarios.domain;

import br.com.f1rst.funcionarios.funcionarios.application.api.FuncionariosAlteracaoResquet;
import br.com.f1rst.funcionarios.funcionarios.application.api.FuncionariosRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idFuncionarios", updatable = false, unique = true, nullable = false)
    private UUID idFuncionarios;
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

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime getDataHoraDaUltimaAlteracao;




    public Funcionarios(FuncionariosRequest funcionariosRequest) {
        this.nomeFuncionarios = funcionariosRequest.getNomeFuncionarios();
        this.designacao = funcionariosRequest.getDesignacao();
        this.salario = funcionariosRequest.getSalario();
        this.telefone = funcionariosRequest.getTelefone();
        this.endereco = funcionariosRequest.getEndereco();
        this.dataHoraDoCadastro = LocalDateTime.now();

    }


    public void altera(FuncionariosAlteracaoResquet funcionariosAlteracaoResquet) {
        this.nomeFuncionarios = funcionariosAlteracaoResquet.getNomeFuncionarios();
        this.designacao = funcionariosAlteracaoResquet.getDesignacao();
        this.salario = funcionariosAlteracaoResquet.getSalario();
        this.telefone = funcionariosAlteracaoResquet.getTelefone();
        this.endereco = funcionariosAlteracaoResquet.getEndereco();
        this.getDataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}
