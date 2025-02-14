package com.sura.global_web.polizaSalud.service.imple;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.sura.global_web.polizaSalud.model.RamaRentaDiaria;
import com.sura.global_web.polizaSalud.repository.IRamaRentaDiariaRepository;
import com.sura.global_web.polizaSalud.service.IRamaRentaDiariaService;

@Service
public class RamaRentaDiariaService implements IRamaRentaDiariaService {


    private final IRamaRentaDiariaRepository rentaDiariaRepository;

    public RamaRentaDiariaService(IRamaRentaDiariaRepository rentaDiariaRepository) {
        this.rentaDiariaRepository = rentaDiariaRepository;
    }



    @Override
    public RamaRentaDiaria createRamaRentaDiaria(RamaRentaDiaria ramaRentaDiaria) {
        return this.rentaDiariaRepository.save(ramaRentaDiaria);
    }

    @Override
    public String deleteRamaRentaDiaria(Long id) {
        
        return null;
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
