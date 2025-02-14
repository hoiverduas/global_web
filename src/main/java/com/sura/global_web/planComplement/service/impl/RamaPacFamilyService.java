package com.sura.global_web.planComplement.service.impl;

import java.util.List;
import java.util.Optional;

import com.sura.global_web.planComplement.model.RamaPacFamily;
import com.sura.global_web.planComplement.repository.IRamaPacFamilyRepository;
import com.sura.global_web.planComplement.service.IRamaPacFamilyService;

public class RamaPacFamilyService implements IRamaPacFamilyService {


    private final IRamaPacFamilyRepository ramaPacFamilyRepository;


    
    public RamaPacFamilyService(IRamaPacFamilyRepository ramaPacFamilyRepository) {
        this.ramaPacFamilyRepository = ramaPacFamilyRepository;
    }

    @Override
    public RamaPacFamily createRamaPacFamily(RamaPacFamily ramaPacFamily) {
    
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
