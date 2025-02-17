package com.sura.global_web.polizaSalud.service.imple;

import java.util.List;
import java.util.Optional;

import com.sura.global_web.plans.model.PlanClassicColective;
import com.sura.global_web.plans.model.PlanJuvenil;
import com.sura.global_web.plans.model.PlanRentaDiaria;
import com.sura.global_web.polizaSalud.model.RamaClassicColective;
import com.sura.global_web.polizaSalud.model.SubRamaJuvenil;


import com.sura.global_web.polizaSalud.model.RamaJuvenil;
import com.sura.global_web.polizaSalud.repository.IRamaJuvenileRepository;
import com.sura.global_web.polizaSalud.service.IRamaJuvenilService;
import org.springframework.stereotype.Service;

@Service
public class RamaJuvenilService implements IRamaJuvenilService{


    private final IRamaJuvenileRepository ramaJuvenileRepository;

    public RamaJuvenilService(IRamaJuvenileRepository ramaJuvenileRepository) {
        this.ramaJuvenileRepository = ramaJuvenileRepository;
    }





    @Override
    public String deleteRamaJuvenilById(Long id) {
        findRamaJuvenilByIdJuvenil(id);
        this.ramaJuvenileRepository.deleteById(id);
        return "fue eliminado exitosamente";
    }

    @Override
    public RamaJuvenil createRamaJuvenil(RamaJuvenil ramaJuvenil) {

        if (ramaJuvenil.getPlanJuvenils() != null) {
            for (PlanJuvenil plan : ramaJuvenil.getPlanJuvenils()) {
                plan.setRamaJuvenil(ramaJuvenil); // Asignar la entidad correcta
            }
        }
        return this.ramaJuvenileRepository.save(ramaJuvenil);
    }

    @Override
    public List<RamaJuvenil> findJuvenilAll() {
        return this.ramaJuvenileRepository.findAll();
    }

    @Override
    public RamaJuvenil findRamaJuvenilByIdJuvenil(Long id) {
        return this.ramaJuvenileRepository
                    .findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public RamaJuvenil updatJuvenil(Long id, RamaJuvenil ramaJuvenil) {
        
        Optional<RamaJuvenil> optionalRamaJuvenil = this.ramaJuvenileRepository.findById(id);
        if (optionalRamaJuvenil.isPresent()) {
            RamaJuvenil existRamaJuvenil = optionalRamaJuvenil.get();

           /* existRamaJuvenil.setCharacteristics(ramaJuvenil.getCharacteristics());
            existRamaJuvenil.setPlanJuvenils(ramaJuvenil.getPlanJuvenils());
            existRamaJuvenil.setSubRamaJuvenil(ramaJuvenil.getSubRamaJuvenil());*/
            
            return this.ramaJuvenileRepository.save(existRamaJuvenil);
        }else{
            throw new RuntimeException("not found");
        }


    }

   



   


}
