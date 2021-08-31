package com.devnoe.personal.tactividad;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TactividadService {
  
    private final TactividadRepository tactividadRepository;
    
    @Autowired
    public TactividadService(TactividadRepository tactividadRepository) {
        this.tactividadRepository = tactividadRepository;
    }

    public List<Tactividad> getTipoActividad() {
        return tactividadRepository.findAll();
    }

    public Tactividad getTipoActividadById(Long idTipoActividad) {
        Tactividad tactividad = tactividadRepository.findById(idTipoActividad).get();
        return tactividad;
    }

    public void addTipoActividad(Tactividad tactividad) {
        tactividadRepository.save(tactividad);
    }

    public void deleteTipoActividadById(Long idTipoActividad) {
        boolean exist = tactividadRepository.existsById(idTipoActividad);
		if(!exist){
			throw new IllegalStateException("El tipo de actividad con Id "+ idTipoActividad + " no existe");
		}
        tactividadRepository.deleteById(idTipoActividad);
    }

    @Transactional
    public void updateTipoActividadById(Tactividad tactividadR ,Long idTipoActividad) {
        Tactividad tactividad = tactividadRepository.findById(idTipoActividad).orElseThrow(()
        -> new IllegalStateException("El tipo de actividad con id "+ idTipoActividad +" no existe"));

        if(tactividadR.getNombre() != null && tactividadR.getNombre().length()>0 && !Objects.equals(tactividad.getNombre(), tactividadR.getNombre())){
            tactividad.setNombre(tactividadR.getNombre());
        }

    }

}
