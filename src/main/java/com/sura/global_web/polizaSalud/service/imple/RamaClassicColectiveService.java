package com.sura.global_web.polizaSalud.service.imple;

import java.util.List;
import java.util.Optional;

import com.sura.global_web.plans.model.PlanClassicColective;
import com.sura.global_web.plans.repository.PlanClassicColectiveRepository;
import com.sura.global_web.polizaSalud.dto.ramaClassicColetiveDto.RequestClassicColectiveDto;
import com.sura.global_web.polizaSalud.dto.ramaClassicColetiveDto.ResponseClassicColectiveDto;
import com.sura.global_web.utils.mapper.ObjectMapperDto;
import org.springframework.stereotype.Service;

import com.sura.global_web.polizaSalud.model.RamaClassicColective;
import com.sura.global_web.polizaSalud.repository.IRamaClassicColectiveRepository;
import com.sura.global_web.polizaSalud.service.IRamaClassicColectiveService;

@Service
public class RamaClassicColectiveService implements IRamaClassicColectiveService{
    
    private final IRamaClassicColectiveRepository ramaClassicColectiveRepository;
    private final PlanClassicColectiveRepository planClassicColectiveRepository;
    private final ObjectMapperDto objectMapperDto;

    public RamaClassicColectiveService(IRamaClassicColectiveRepository ramaClassicColectiveRepository, PlanClassicColectiveRepository planClassicColectiveRepository, ObjectMapperDto objectMapperDto) {
        this.ramaClassicColectiveRepository = ramaClassicColectiveRepository;
        this.planClassicColectiveRepository = planClassicColectiveRepository;
        this.objectMapperDto = objectMapperDto;
    }

    @Override
    public ResponseClassicColectiveDto createRamaClassicColective(RequestClassicColectiveDto requestClassicColectiveDto) {

        RamaClassicColective ramaClassicColective = objectMapperDto.map(requestClassicColectiveDto,RamaClassicColective.class);

        if (ramaClassicColective.getPlanClassicColectives() != null) {
            for (PlanClassicColective plan : ramaClassicColective.getPlanClassicColectives()) {
                plan.setRamaClassicColective(ramaClassicColective); // Asignar la entidad correcta
            }
        }

        RamaClassicColective ramaSave = ramaClassicColectiveRepository.save(ramaClassicColective);

        return this.objectMapperDto.map(ramaSave,ResponseClassicColectiveDto.class);
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


            return this.ramaClassicColectiveRepository.save(existClassicColective);
        }else{
            throw new RuntimeException("not found");
        }
        
    
    }

    

    
}
