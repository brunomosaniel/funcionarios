package br.com.f1rst.funcionarios.funcionarios.application.api;

import br.com.f1rst.funcionarios.funcionarios.domain.Funcionarios;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Value
public class FuncionariosListResponse {
    private UUID idFuncionarios;
    private String nomeFuncionarios;
    private String designacao;
    private String telefone;
    private String endereco;


    public static List<FuncionariosListResponse> converte(List<Funcionarios> funcionarios) {
        return funcionarios.stream()
                .map(FuncionariosListResponse::new)
                .collect(Collectors.toList());
    }

    public FuncionariosListResponse(Funcionarios funcionarios) {
        this.idFuncionarios =  funcionarios.getIdFuncionarios();
        this.nomeFuncionarios = funcionarios.getNomeFuncionarios();
        this.designacao = funcionarios.getDesignacao();
        this.telefone = funcionarios.getTelefone();
        this.endereco = funcionarios.getEndereco();
    }
}
