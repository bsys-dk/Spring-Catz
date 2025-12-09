package dk.bsys.concept.catz.orm;

import org.springframework.data.jpa.repository.JpaRepository;

interface CatzRepository extends JpaRepository<Catz, Long> {

    Catz findByName(String name);
}
