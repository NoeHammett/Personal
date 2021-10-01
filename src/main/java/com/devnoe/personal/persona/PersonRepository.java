package com.devnoe.personal.persona;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    
    // Función para encontrar personas por email en lenguajes SQL
    // @Query("SELECT s FROM person s WHERE s.email= ?1")

    //Función Para encontrar personas por email
    Optional<Person> findPersonByEmail(String email);


}
