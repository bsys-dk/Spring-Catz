package dk.bsys.catz.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface CatRepository extends JpaRepository<Cat, Long> {

    Cat findByName(String name);

    @Query("select c from Cat c Where c.age < 3 ")
    List<Cat> findYoungCats();
}
