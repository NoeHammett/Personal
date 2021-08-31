package com.devnoe.personal.tactividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/tipoActividad")
public class TactividadController {
    
    private final TactividadService tactividadService;

    @Autowired
    public TactividadController(TactividadService tactividadService) {
        this.tactividadService = tactividadService;
    }

    @GetMapping(path = "/getTipoActividad")
    public List<Tactividad> getTipoActividad(){
        return tactividadService.getTipoActividad();
    }

    @GetMapping(path = "/getTipoActividad/{idTipoActividad}")
    public Tactividad getTipoActividadById(@PathVariable ("idTipoActividad") Long idTipoActividad){
        return tactividadService.getTipoActividadById(idTipoActividad);
    }

    @PostMapping(path ="/addTipoActividad")
    public String addTipoActividad (@RequestBody Tactividad tactividad){
        tactividadService.addTipoActividad(tactividad);
        return "Tipo de actividad agregada correctamente";
    }

    @DeleteMapping(path = "/deleteTipoActividad/{idTipoActividad}")
    public String deleteTipoActividadById (@PathVariable("idTipoActividad") Long idTipoActividad){
        tactividadService.deleteTipoActividadById(idTipoActividad);
        return "Tipo de actividad eliminada correctamente";
    }

    @PutMapping(path ="/updateTipoActividad/{idTipoActividad}")
    public String updateTipoActividadById(@RequestBody Tactividad tactividad,@PathVariable("idTipoActividad") Long idTipoActividad){
        tactividadService.updateTipoActividadById(tactividad,idTipoActividad);
        return "Tipo de actividad actualizada";
    }
   

}
