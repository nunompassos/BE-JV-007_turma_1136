package tech.ada.school.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import tech.ada.school.domain.dto.exception.NotFoundException;
import tech.ada.school.domain.dto.v1.ProfessorDto;
import tech.ada.school.service.IProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private IProfessorService servico;

    public ProfessorController(IProfessorService servico) {
        this.servico = servico;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> lerProfessores() {
        return ResponseEntity.ok(servico.listarProfessores());
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> criarProfessor(
        @RequestBody @Valid ProfessorDto pedido
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarProfessor(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDto> atualizarProfessor(
        @PathVariable("id") int id,
        @RequestBody ProfessorDto pedido
    ) throws NotFoundException {
        final ProfessorDto p = servico.atualizarProfessor(id, pedido);

        if (p == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDto> buscarProfessor(
        @PathVariable("id") int id
    ) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarProfessor(id));
    }

    @DeleteMapping("/{id}")
    @SecurityRequirements(@SecurityRequirement(name = "JWT"))
    public ResponseEntity<Void> removerProfessor(
        @PathVariable("id") int id
    ) throws NotFoundException {
        servico.removerProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ProfessorDto> buscarPorCpf(@PathParam("cpf") String cpf) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarPorCpf(cpf));
    }

}
