package br.com.f1rst.funcionarios.funcionarios.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/funcionarios")
public interface FuncionariosAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    FuncionariosResponse postFuncionarios (@Valid @RequestBody FuncionariosRequest funcionariosRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<FuncionariosListResponse> getTodosFuncionarios();

    @GetMapping(value = "/{idFuncionarios}")
    @ResponseStatus(code = HttpStatus.OK)
    FuncionariosDetalhadoResponse getFuncionariosAtravesId(@PathVariable UUID idFuncionarios);

    @DeleteMapping(value = "/{idFuncionarios}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaFuncionariosAtravesId(@PathVariable UUID idFuncionarios);

    @PatchMapping(value = "/{idFuncionarios}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraFuncionarios(@PathVariable UUID idFuncionarios,
                                 @Valid @RequestBody FuncionariosAlteracaoResquet funcionariosAlteracaoResquet );

}
