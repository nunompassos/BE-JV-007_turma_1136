package tech.ada.school.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tech.ada.school.domain.dto.v1.ProfessorDto;
import tech.ada.school.service.IProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final IProfessorService servico;

    @Autowired
    public ProfessorController(IProfessorService servico) {
        this.servico = servico;
    }

    @GetMapping
    public List<ProfessorDto> lerProfessores() {
        return servico.listarProfessores();
    }

    @PostMapping
    public int criarProfessor(
        @RequestBody ProfessorDto pedido
    ) {
        return servico.criarProfessor(pedido.getNome());
    }

    @PutMapping("/{id}")
    public void atualizarProfessor(
        @PathVariable("id") int id,
        @RequestBody ProfessorDto pedido
    ) {
        return;
    }

    @GetMapping("/{id}")
    public ProfessorDto buscarProfessor(
        @PathVariable("id") int id
    ) {
        return new ProfessorDto();
    }

}
