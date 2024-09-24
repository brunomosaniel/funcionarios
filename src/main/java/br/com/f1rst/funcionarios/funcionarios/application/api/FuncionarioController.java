package br.com.f1rst.funcionarios.funcionarios.application.api;

import br.com.f1rst.funcionarios.funcionarios.application.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FuncionarioController implements FuncionariosAPI {

    private final FuncionarioService funcionarioService;

    @Override
    public FuncionariosResponse postFuncionarios(FuncionariosRequest funcionariosRequest) {
        log.info("[start] funcionarioController - postFuncionarios");
        FuncionariosResponse funcionarioCriado = funcionarioService.criaFuncionario(funcionariosRequest);
        log.info("[finish] funcionarioController - postFuncionarios");
        return funcionarioCriado;
    }

    @Override
    public List<FuncionariosListResponse> getTodosFuncionarios() {
        log.info("[start] funcionarioController - getTodosFuncionarios");
        List<FuncionariosListResponse> funcionarios = funcionarioService.buscaTodosFuncionarios();
        log.info("[finsih] funcionarioController - getTodosFuncionarios");
        return funcionarios;
    }

    @Override
    public FuncionariosDetalhadoResponse getFuncionariosAtravesId(UUID idFuncionarios) {
        log.info("[start] funcionarioController - getFuncionariosAtravesId");
        log.info("[idFuncionarios] {} ", idFuncionarios);
        FuncionariosDetalhadoResponse funcionarioDetalhado = funcionarioService.buscaFuncionariosAtravesId(idFuncionarios);
        log.info("[finish] funcionarioController - getFuncionariosAtravesId");
        return funcionarioDetalhado;
    }

    @Override
    public void deletaFuncionariosAtravesId(UUID idFuncionarios) {
        log.info("[start] funcionarioController - deletaFuncionariosAtravesId");
        log.info("[idFuncionarios] {} ", idFuncionarios);
        funcionarioService.deletaFuncionariosAtravesid(idFuncionarios);
        log.info("[finish] funcionarioController - deletaFuncionariosAtravesId");

    }

    @Override
    public void patchAlteraFuncionarios(UUID idFuncionarios, @Valid FuncionariosAlteracaoResquet funcionariosAlteracaoResquet) {
        log.info("[start] funcionarioController -patchAlteraFuncionarios");
        log.info("[idFuncionarios] {} ", idFuncionarios);
        funcionarioService. patchAlteraFuncionarios(idFuncionarios, funcionariosAlteracaoResquet);
        log.info("[finish] funcionarioController - patchAlteraFuncionarios");
    }

}
