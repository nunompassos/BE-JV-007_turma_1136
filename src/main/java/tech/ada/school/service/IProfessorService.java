package tech.ada.school.service;

import java.util.List;

import tech.ada.school.domain.dto.v1.ProfessorDto;

public interface IProfessorService {

    int criarProfessor(String nome);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id);

    void atualizarProfessor(int id, String nome);

}
