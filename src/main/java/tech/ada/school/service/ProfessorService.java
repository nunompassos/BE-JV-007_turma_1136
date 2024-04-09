package tech.ada.school.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import tech.ada.school.domain.dto.exception.NotFoundException;
import tech.ada.school.domain.dto.v1.ProfessorDto;

@Service
public class ProfessorService implements IProfessorService {

    private final List<ProfessorDto> professores = new ArrayList<>();
    private int id = 1;

    @Override
    public ProfessorDto criarProfessor(ProfessorDto novoProfessor) {
        final ProfessorDto p = new ProfessorDto(
            id++,
            novoProfessor.getNome(),
            novoProfessor.getCpf(),
            novoProfessor.getEmail()
        );
        professores.add(p);
        return p;
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return professores;
    }

    @Override
    public ProfessorDto buscarProfessor(int id) throws NotFoundException {
        return professores
            .stream()
            .filter(it -> it.getId()==id)
            .findFirst()
            .orElseThrow(() -> new NotFoundException(ProfessorDto.class, String.valueOf(id)));
    }

    @Override
    public ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) {
        final ProfessorDto professor = professores.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
        if (professor == null) {
            return null;
        }
        professores.remove(professor);
        final ProfessorDto p = new ProfessorDto(professor.getId(), pedido.getNome(), pedido.getCpf(), pedido.getEmail());
        professores.add(p);
        return p;
    }

    @Override
    public void removerProfessor(int id) throws NotFoundException {
        final ProfessorDto professor = buscarProfessor(id);
        professores.remove(professor);
    }
}
