package tech.ada.school.service;

import java.util.List;

import tech.ada.school.domain.dto.exception.NotFoundException;
import tech.ada.school.domain.dto.v1.ProfessorDto;

public interface IProfessorService {

    ProfessorDto criarProfessor(ProfessorDto pedido);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id) throws NotFoundException;

    ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) throws NotFoundException;

    void removerProfessor(int id) throws NotFoundException;

    ProfessorDto buscarPorCpf(String cpf) throws NotFoundException;

}
