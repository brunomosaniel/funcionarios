package br.com.f1rst.funcionarios.funcionarios.infra;

import br.com.f1rst.funcionarios.funcionarios.application.repository.FuncionariosRepository;
import br.com.f1rst.funcionarios.funcionarios.domain.Funcionarios;
import br.com.f1rst.funcionarios.funcionarios.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class FuncionariosInfraRepository implements FuncionariosRepository {
    private final FuncionariosSpringDataJPARepository funcionariosSpringDataJPARepository;

    @Override
    public Funcionarios salva(Funcionarios funcionarios) {
        log.info("[start] FuncionariosInfraRepository - salva");
        funcionariosSpringDataJPARepository.save(funcionarios);
        log.info("[finish] FuncionariosInfraRepository - salva");
        return funcionarios;
    }

    @Override
    public List<Funcionarios> buscaTodosFuncionarios() {
        log.info("[start] FuncionariosInfraRepository - buscaTodosFuncionarios");
        List<Funcionarios> todosFuncionarios = funcionariosSpringDataJPARepository.findAll();
        log.info("[finish] FuncionariosInfraRepository - buscaTodosFuncionarios");
        return todosFuncionarios;
    }

    @Override
    public Funcionarios buscaFuncionariosAtravesId(UUID idFuncionarios) {
        log.info("[start] FuncionariosInfraRepository - buscaFuncionariosAtravesId");
         Funcionarios funcionarios =  funcionariosSpringDataJPARepository.findById(idFuncionarios)
                 .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Funcionarios não encontrados!"));
        log.info("[finish] FuncionariosInfraRepository - buscaFuncionariosAtravesId");
        return funcionarios;
    }

    @Override
    public void deletaFuncionarios(Funcionarios funcionarios) {
        log.info("[start] FuncionariosInfraRepository - deletaFuncionarios");
        funcionariosSpringDataJPARepository.delete(funcionarios);
        log.info("[start] FuncionariosInfraRepository - deletaFuncionarios");

    }
}
