package dk.bsys.concept.catz.orm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:catzdb",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
class CatzRepositoryTest {

    @Autowired
    private CatzRepository catzRepository;

    private Catz testCatz;

    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method
        testCatz = new Catz();
        testCatz.setName("Felix");
        testCatz.setAge(12);
        catzRepository.save(testCatz);
    }

    @AfterEach
    public void tearDown() {
        // Release test data after each test method
        catzRepository.delete(testCatz);
    }

    @Test
    void givenCatz_whenSaved_thenCanBeFoundById() {
        Catz savedCatz = catzRepository.findById(testCatz.getId()).orElse(null);
        assertNotNull(savedCatz);
        assertEquals(testCatz.getName(), savedCatz.getName());
        assertEquals(testCatz.getAge(), savedCatz.getAge());
    }


    @Test
    void givenCatz_whenUpdated_thenCanBeFoundByIdWithUpdatedData() {
        testCatz.setName("Benny");
        catzRepository.save(testCatz);

        Catz updatedCatz = catzRepository.findById(testCatz.getId()).orElse(null);

        assertNotNull(updatedCatz);
        assertEquals("Benny", updatedCatz.getName());
    }


    @Test
    void givenCatz_whenFindByNameCalled_thenUserIsFound() {
        Catz foundCatz = catzRepository.findByName("Felix");

        assertNotNull(foundCatz);
        assertEquals("Felix", foundCatz.getName());
    }
}