package tech.ada.school.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import tech.ada.school.domain.dto.v1.ProfessorDto;

@Service
public class ProfessorService implements IProfessorService {

    private final List<ProfessorDto> professores = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarProfessor(ProfessorDto novoProfessor) {
        professores.add(new ProfessorDto(id, novoProfessor.getNome(), novoProfessor.getCpf(), novoProfessor.getEmail()));
        return id++;
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return professores;
    }

    @Override
    public ProfessorDto buscarProfessor(int id) {
        return professores.stream().filter(it -> it.getId()==id).findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void atualizarProfessor(int id, ProfessorDto pedido) {
        final ProfessorDto professor = buscarProfessor(id);
        professores.remove(professor);
        professores.add(new ProfessorDto(professor.getId(), pedido.getNome(), pedido.getCpf(), pedido.getEmail()));
    }

    @Override
    public void removerProfessor(int id) {
        final ProfessorDto professor = buscarProfessor(id);
        professores.remove(professor);
    }
}
