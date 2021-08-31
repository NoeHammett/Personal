package com.devnoe.personal.tactividad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TactividadRepository extends JpaRepository<Tactividad, Long> {
    
}
