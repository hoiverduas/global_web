package com.sura.global_web.planComplement.service.impl;

import java.util.List;
import java.util.Optional;

import com.sura.global_web.planComplement.model.RamaPacFamily;
import com.sura.global_web.planComplement.repository.IRamaPacFamilyRepository;
import com.sura.global_web.planComplement.service.IRamaPacFamilyService;
import com.sura.global_web.plans.model.PlanPacColective;
import com.sura.global_web.plans.model.PlanPacFamily;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class RamaPacFamilyService implements IRamaPacFamilyService {


    private final IRamaPacFamilyRepository ramaPacFamilyRepository;


    
    public RamaPacFamilyService(IRamaPacFamilyRepository ramaPacFamilyRepository) {
        this.ramaPacFamilyRepository = ramaPacFamilyRepository;
    }

    @Override
    public RamaPacFamily createRamaPacFamily(RamaPacFamily ramaPacFamily) {

        if (ramaPacFamily.getPacFamilies() != null) {
            for (PlanPacFamily plan : ramaPacFamily.getPacFamilies()) {
                plan.setRamaPacFamily(ramaPacFamily); // Asignar la entidad correcta
            }
        }
        return this.ramaPacFamilyRepository.save(ramaPacFamily);
    }

    @Override
    public String deleteRamaPacColective(Long id) {
        findRamaPacFamilyById(id);
        this.ramaPacFamilyRepository.deleteById(id);
        return "fue eliminado exitosamente";
    }

    @Override
    public List<RamaPacFamily> findPacFamiliesAll() {
        return this.ramaPacFamilyRepository.findAll();
    }

    @Override
    public RamaPacFamily findRamaPacFamilyById(Long id) {
        return this.ramaPacFamilyRepository
                   .findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public RamaPacFamily updateRamaPacColective(Long id, RamaPacFamily ramaPacFamily) {
        Optional<RamaPacFamily>oprionalRamaPacFamily = this.ramaPacFamilyRepository.findById(id);

        if (oprionalRamaPacFamily.isPresent()) {
            RamaPacFamily existRamaPacFamily = oprionalRamaPacFamily.get();

            existRamaPacFamily.setCharacteristics(ramaPacFamily.getCharacteristics());
            existRamaPacFamily.setPacFamilies(ramaPacFamily.getPacFamilies());
            existRamaPacFamily.setSubRamaPacFamily(ramaPacFamily.getSubRamaPacFamily());

            return this.ramaPacFamilyRepository.save(existRamaPacFamily);
        }else{
            throw new RuntimeException("not found");
        }
    }


    
}
