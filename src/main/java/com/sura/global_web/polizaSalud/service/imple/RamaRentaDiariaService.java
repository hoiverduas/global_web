package com.sura.global_web.polizaSalud.service.imple;

import java.util.List;
import java.util.Optional;

import com.sura.global_web.plans.model.PlanRentaDiaria;
import com.sura.global_web.polizaSalud.dto.ramaDiariaRentaDto.RequestRamaRentaDiariaDto;
import com.sura.global_web.polizaSalud.dto.ramaDiariaRentaDto.ResponseRamaRentaDiariaDto;
import com.sura.global_web.utils.mapper.ObjectMapperDto;
import org.springframework.stereotype.Service;

import com.sura.global_web.polizaSalud.model.RamaRentaDiaria;
import com.sura.global_web.polizaSalud.repository.IRamaRentaDiariaRepository;
import com.sura.global_web.polizaSalud.service.IRamaRentaDiariaService;

@Service
public class RamaRentaDiariaService implements IRamaRentaDiariaService {


    private final IRamaRentaDiariaRepository rentaDiariaRepository;
    private final ObjectMapperDto objectMapperDto;

    public RamaRentaDiariaService(IRamaRentaDiariaRepository rentaDiariaRepository, ObjectMapperDto objectMapperDto) {
        this.rentaDiariaRepository = rentaDiariaRepository;
        this.objectMapperDto = objectMapperDto;
    }



    @Override
    public ResponseRamaRentaDiariaDto createRamaRentaDiaria(RequestRamaRentaDiariaDto requestRamaRentaDiariaDto) {


        RamaRentaDiaria ramaRentaDiaria = this.objectMapperDto.map(requestRamaRentaDiariaDto, RamaRentaDiaria.class);

        if (ramaRentaDiaria.getPlanRentaDiarias() != null) {
            for (PlanRentaDiaria plan : ramaRentaDiaria.getPlanRentaDiarias()) {
                plan.setRamaRentaDiaria(ramaRentaDiaria); // Asignar la entidad correcta
            }
        }

        RamaRentaDiaria saveRama = this.rentaDiariaRepository.save(ramaRentaDiaria);

        return this.objectMapperDto.map(saveRama, ResponseRamaRentaDiariaDto.class);
    }

    @Override
    public String deleteRamaRentaDiaria(Long id) {
        this.rentaDiariaRepository.deleteById(id);
        return "fue eliminado exitosamente";
    }

    @Override
    public RamaRentaDiaria findRamaRentaDiariaById(Long id) {
        
        return this.rentaDiariaRepository
                   .findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public List<RamaRentaDiaria> findRamaRentaDiariasAllList() {
        return this.rentaDiariaRepository.findAll();
    }

    @Override
    public RamaRentaDiaria updatRamaRentaDiaria(Long id, RamaRentaDiaria ramaRentaDiaria) {
        
        Optional<RamaRentaDiaria>optionalRamaRenta = this.rentaDiariaRepository.findById(id);
        if (optionalRamaRenta.isPresent()) {
            RamaRentaDiaria existRamaRentaDiaria = optionalRamaRenta.get();

            existRamaRentaDiaria.setCharacteristics(ramaRentaDiaria.getCharacteristics());
            existRamaRentaDiaria.setPlanRentaDiarias(ramaRentaDiaria.getPlanRentaDiarias());
            existRamaRentaDiaria.setSubRamaRentaDiaria(ramaRentaDiaria.getSubRamaRentaDiaria());

            return this.rentaDiariaRepository.save(existRamaRentaDiaria);
            
        }else{
            throw new RuntimeException("not found");
        }

    }
    
    
   
    

   
    
}
