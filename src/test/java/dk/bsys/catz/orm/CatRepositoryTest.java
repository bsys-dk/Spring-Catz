package dk.bsys.catz.orm;

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
class CatRepositoryTest {

    @Autowired
    private CatRepository catRepository;

    private Cat testCat;

    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method
        testCat = new Cat();
        testCat.setName("Felix");
        testCat.setAge(12);
        catRepository.save(testCat);
    }

    @AfterEach
    public void tearDown() {
        // Release test data after each test method
        catRepository.delete(testCat);
    }

    @Test
    void givenCat_whenSaved_thenCanBeFoundById() {
        Cat savedCat = catRepository.findById(testCat.getId()).orElse(null);
        assertNotNull(savedCat);
        assertEquals(testCat.getName(), savedCat.getName());
        assertEquals(testCat.getAge(), savedCat.getAge());
    }


    @Test
    void givenCat_whenUpdated_thenCanBeFoundByIdWithUpdatedData() {
        testCat.setName("Benny");
        catRepository.save(testCat);

        Cat updatedCat = catRepository.findById(testCat.getId()).orElse(null);

        assertNotNull(updatedCat);
        assertEquals("Benny", updatedCat.getName());
    }


    @Test
    void givenCat_whenFindByNameCalled_thenUserIsFound() {
        Cat foundCat = catRepository.findByName("Felix");

        assertNotNull(foundCat);
        assertEquals("Felix", foundCat.getName());
    }
}