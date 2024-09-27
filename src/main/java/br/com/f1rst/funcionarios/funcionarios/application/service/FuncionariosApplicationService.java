package br.com.f1rst.funcionarios.funcionarios.application.service;

import br.com.f1rst.funcionarios.funcionarios.application.api.*;
import br.com.f1rst.funcionarios.funcionarios.application.repository.FuncionariosRepository;
import br.com.f1rst.funcionarios.funcionarios.domain.Funcionarios;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class FuncionariosApplicationService implements FuncionarioService {
    private final FuncionariosRepository funcionariosRepository;

    @Override
    public FuncionariosResponse criaFuncionario(FuncionariosRequest funcionariosRequest) {
        log.info("[start] FuncionariosApplicationService - criaFuncionario");
        Funcionarios funcionarios = funcionariosRepository.salva(new Funcionarios(funcionariosRequest));
        log.info("[finish] FuncionariosApplicationService - criaFuncionario");
        return FuncionariosResponse.builder()
                .idFuncionarios(funcionarios.getIdFuncionarios())
                .build();
    }

    @Override
    public List<FuncionariosListResponse> buscaTodosFuncionarios() {
        log.info("[start] FuncionariosApplicationService - buscaTodosFuncionarios");
        List<Funcionarios> funcionarios = funcionariosRepository.buscaTodosFuncionarios();
        log.info("[finish] FuncionariosApplicationService - buscaTodosFuncionarios");
        return FuncionariosListResponse.converte(funcionarios);
    }

    @Override
    public FuncionariosDetalhadoResponse buscaFuncionariosAtravesId(UUID idFuncionarios) {
        log.info("[start] FuncionariosApplicationService - buscaFuncionariosAtravesId");
        Funcionarios funcionarios = funcionariosRepository.buscaFuncionariosAtravesId(idFuncionarios);
        log.info("[finish]  FuncionariosApplicationService - buscaFuncionariosAtravesId");
        return new FuncionariosDetalhadoResponse(funcionarios);
    }

    @Override
    public void deletaFuncionariosAtravesid(UUID idFuncionarios) {
        log.info("[start] FuncionariosApplicationService - deletaFuncionariosAtravesid");
        Funcionarios funcionarios = funcionariosRepository.buscaFuncionariosAtravesId(idFuncionarios);
        funcionariosRepository.deletaFuncionarios(funcionarios);
        log.info("[finish] FuncionariosApplicationService - deletaFuncionariosAtravesid");


    }

    @Override
    public void patchAlteraFuncionarios(UUID idFuncionarios, FuncionariosAlteracaoResquet funcionariosAlteracaoResquet) {
        log.info("[start] FuncionariosApplicationService - patchAlteraFuncionarios");
        Funcionarios funcionarios = funcionariosRepository.buscaFuncionariosAtravesId(idFuncionarios);
        funcionarios.altera(funcionariosAlteracaoResquet);
        funcionariosRepository.salva(funcionarios);
        log.info("[finish] FuncionariosApplicationService - patchAlteraFuncionarios");
    }
}
