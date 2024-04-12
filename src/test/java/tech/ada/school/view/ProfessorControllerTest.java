package tech.ada.school.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.ada.school.mocks.ProfessorServiceMock;

public class ProfessorControllerTest {


    @Test
    public void testListarProfessores() {
        ProfessorController underTest = new ProfessorController(new ProfessorServiceMock());
        assertEquals(1, underTest.lerProfessores().getBody().size(), "Tamanho tem de ser 1");
    }
}
