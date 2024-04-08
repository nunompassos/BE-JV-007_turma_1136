package tech.ada.school.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
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
        @RequestBody @Valid ProfessorDto pedido
    ) {
        return servico.criarProfessor(pedido);
    }

    @PutMapping("/{id}")
    public void atualizarProfessor(
        @PathVariable("id") int id,
        @RequestBody ProfessorDto pedido
    ) {
        servico.atualizarProfessor(id, pedido);
    }

    @GetMapping("/{id}")
    public ProfessorDto buscarProfessor(
        @PathVariable("id") int id
    ) {
        return servico.buscarProfessor(id);
    }

    @DeleteMapping("/{id}")
    public void removerProfessor(
        @PathVariable("id") int id
    ) {
        servico.removerProfessor(id);
    }

}
