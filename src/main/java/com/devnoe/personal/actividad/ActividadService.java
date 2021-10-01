package com.devnoe.personal.actividad;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    @Autowired
    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> getActividad() {    
        return actividadRepository.findAll();
    }

    public Actividad getActividadById(Long actividadId) {
        Actividad actividad = actividadRepository.findById(actividadId).orElseThrow(()
		-> new IllegalStateException("La actividad con id "+ actividadId + " no existe"));
        return actividad;
    }

    public List<Actividad> getActividadByPerson(Long person_id) {
        return actividadRepository.findActividadByPerson(person_id);
    }     

    public void addActividad(Actividad actividad) {
        actividadRepository.save(actividad);
    }

    public void deleteActividadById(Long actividadId) {
        boolean exist = actividadRepository.existsById(actividadId);
		if(!exist){
			throw new IllegalStateException("Actividad con Id "+ actividadId + " no existe");
		}
        actividadRepository.deleteById(actividadId);
    }

    @Transactional
    public void updateActividadById(Actividad actividadR,Long actividadId) {
        Actividad actividad = actividadRepository.findById(actividadId).orElseThrow(()
		-> new IllegalStateException("La actividad con id "+ actividadId  + " no existe"));
    
        if(actividadR.getNombre() != null && actividadR.getNombre().length()>0 && !Objects.equals(actividad.getNombre(), actividadR.getNombre())){
            actividad.setNombre(actividadR.getNombre());
        }
        if(actividadR.getDescripcion() != null && actividadR.getDescripcion().length()>0 && !Objects.equals(actividad.getDescripcion(), actividadR.getDescripcion())){
            actividad.setDescripcion(actividadR.getDescripcion());
        }
        if(actividadR.getHoras() != null  && !Objects.equals(actividad.getHoras(), actividadR.getHoras())){
            actividad.setHoras(actividadR.getHoras());
        }
    }
    
}
