package com.sura.global_web.polizaSalud.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sura.global_web.polizaSalud.model.RamaJuvenil;
import com.sura.global_web.polizaSalud.repository.IRamaJuvenileRepository;
import com.sura.global_web.polizaSalud.service.IRamaJuvenilService;

@Service
public class RamaJuvenilService implements IRamaJuvenilService{


    private final IRamaJuvenileRepository ramaJuvenileRepository;

    public RamaJuvenilService(IRamaJuvenileRepository ramaJuvenileRepository) {
        this.ramaJuvenileRepository = ramaJuvenileRepository;
    }
    
    @Override
    public RamaJuvenil createRamaJuvenil(RamaJuvenil ramaJuvenil) {
        return this.ramaJuvenileRepository.save(ramaJuvenil);
    }

    @Override
    public String deleteRamaJuvenilById(Long id) {
        findRamaJuvenilByIdJuvenil(id);
        this.ramaJuvenileRepository.deleteById(id);
        return "fue eliminado exitosamente";
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

            existRamaJuvenil.setCharacteristics(ramaJuvenil.getCharacteristics());
            existRamaJuvenil.setPlanJuvenils(ramaJuvenil.getPlanJuvenils());
            existRamaJuvenil.setSubRamaJuvenil(ramaJuvenil.getSubRamaJuvenil());
            
            return this.ramaJuvenileRepository.save(existRamaJuvenil);
        }else{
            throw new RuntimeException("not found");
        }


    }

   



   


}
