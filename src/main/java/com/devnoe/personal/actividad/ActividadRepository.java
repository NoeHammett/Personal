package com.devnoe.personal.actividad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
   
    
    @Query(value = "select * from actividad where person_id = ?", nativeQuery = true)
    List<Actividad> findActividadByPerson(Long person_id);

}
