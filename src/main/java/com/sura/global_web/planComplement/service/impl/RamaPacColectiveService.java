package com.sura.global_web.planComplement.service.impl;

import java.util.List;
import java.util.Optional;

import com.sura.global_web.planComplement.dto.ramaPacColective.RequestRamaPacColective;
import com.sura.global_web.planComplement.dto.ramaPacColective.ResponseRamaPacColective;
import com.sura.global_web.planComplement.model.RamaPacColective;
import com.sura.global_web.planComplement.repository.IRamaPacColectiveRepository;
import com.sura.global_web.planComplement.service.IRamaPacColectiveService;
import com.sura.global_web.plans.model.PlanPacColective;
import com.sura.global_web.utils.mapper.ObjectMapperDto;
import org.springframework.stereotype.Service;


@Service
public class RamaPacColectiveService implements IRamaPacColectiveService{

    private final IRamaPacColectiveRepository ramaPacColectiveRepository;
    private final ObjectMapperDto objectMapperDto;

    public RamaPacColectiveService(IRamaPacColectiveRepository ramaPacColectiveRepository, ObjectMapperDto objectMapperDto) {
        this.ramaPacColectiveRepository = ramaPacColectiveRepository;
        this.objectMapperDto = objectMapperDto;
    }

    @Override
    public ResponseRamaPacColective createRamaPacColective(RequestRamaPacColective requestRamaPacColective) {

        RamaPacColective ramaPacColective = this.objectMapperDto.map(requestRamaPacColective, RamaPacColective.class);

        if (ramaPacColective.getPacColectives() != null) {
            for (PlanPacColective plan : ramaPacColective.getPacColectives()) {
                plan.setRamaPacColective(ramaPacColective); // Asignar la entidad correcta
            }
        }

        RamaPacColective saveRama = this.ramaPacColectiveRepository.save(ramaPacColective);

        return this.objectMapperDto.map(saveRama,ResponseRamaPacColective.class);
    }

    @Override
    public String deleteRamaPacColective(Long id) {
        findRamaPacColectiveById(id);
        this.ramaPacColectiveRepository.deleteById(id);
        return "fue eliminado exitoxamente"; 
    }

    @Override
    public List<RamaPacColective> findPacColectivesAll() {
        return this.ramaPacColectiveRepository.findAll();
    }

    @Override
    public RamaPacColective findRamaPacColectiveById(Long id) {
        return this.ramaPacColectiveRepository
                   .findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public RamaPacColective updateRamaPacColective(Long id, RamaPacColective ramaPacColective) {

        Optional<RamaPacColective> optionalRamaPacColective = ramaPacColectiveRepository.findById(id);
        if (optionalRamaPacColective.isPresent()) {
            RamaPacColective existRamaPacColective = optionalRamaPacColective.get();

            existRamaPacColective.setCharacteristics(ramaPacColective.getCharacteristics());
            existRamaPacColective.setPacColectives(ramaPacColective.getPacColectives());
            existRamaPacColective.setSubRamaPacColective(ramaPacColective.getSubRamaPacColective());
            
            return this.ramaPacColectiveRepository.save(existRamaPacColective);
        }else{
            throw new RuntimeException("no found");
        }
    }

    
}
