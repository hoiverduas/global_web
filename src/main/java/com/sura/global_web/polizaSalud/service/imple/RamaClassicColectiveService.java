package com.sura.global_web.polizaSalud.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sura.global_web.polizaSalud.model.RamaClassicColective;
import com.sura.global_web.polizaSalud.repository.IRamaClassicColectiveRepository;
import com.sura.global_web.polizaSalud.service.IRamaClassicColectiveService;

@Service
public class RamaClassicColectiveService implements IRamaClassicColectiveService{
    
    private final IRamaClassicColectiveRepository ramaClassicColectiveRepository;

    public RamaClassicColectiveService(IRamaClassicColectiveRepository ramaClassicColectiveRepository) {
        this.ramaClassicColectiveRepository = ramaClassicColectiveRepository;
    }

    @Override
    public RamaClassicColective createRamaClassicColective(RamaClassicColective ramaClassicColective) {
        return this.ramaClassicColectiveRepository.save(ramaClassicColective);
    }

    @Override
    public String delecteRamaClassicColective(Long id) {

           findClassicColectiveById(id);
           this.ramaClassicColectiveRepository.deleteById(id);

        return "fue eliminado exitosamente";
    }

    @Override
    public RamaClassicColective findClassicColectiveById(Long id) {
        return this.ramaClassicColectiveRepository
        .findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public List<RamaClassicColective> findClassicColectivesAll() {
        return this.ramaClassicColectiveRepository.findAll();
    }

    @Override
    public RamaClassicColective updateRamaClassicColective(Long id, RamaClassicColective ramaClassicColective) {
        
        Optional<RamaClassicColective>optionalROptional = this.ramaClassicColectiveRepository.findById(id);
        
        if(optionalROptional.isPresent()){
            RamaClassicColective existClassicColective = optionalROptional.get();

            existClassicColective.setPlanClassicColectives(ramaClassicColective.getPlanClassicColectives());
            existClassicColective.setCharacteristics(ramaClassicColective.getCharacteristics());
            existClassicColective.setSubRamaClassicColective(ramaClassicColective.getSubRamaClassicColective());
            existClassicColective.setPlanClassicColectives(ramaClassicColective.getPlanClassicColectives());

            return this.ramaClassicColectiveRepository.save(existClassicColective);
        }else{
            throw new RuntimeException("not found");
        }
        
    
    }

    

    
}
