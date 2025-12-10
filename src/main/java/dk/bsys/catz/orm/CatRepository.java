package dk.bsys.catz.orm;

import org.springframework.data.jpa.repository.JpaRepository;

interface CatRepository extends JpaRepository<Cat, Long> {

    Cat findByName(String name);
}
