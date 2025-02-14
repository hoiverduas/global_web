package com.sura.global_web.polizaSalud.service.imple;

import java.util.List;
import java.util.Optional;

import com.sura.global_web.polizaSalud.model.RamaSaludFamily;
import com.sura.global_web.polizaSalud.repository.IRamaSaludFamilyRepository;
import com.sura.global_web.polizaSalud.service.IRamaSaludFamilyService;

public class RamaSaludFamilyService implements IRamaSaludFamilyService {

    private final IRamaSaludFamilyRepository ramaSaludFamilyRepository;
    

    public RamaSaludFamilyService(IRamaSaludFamilyRepository ramaSaludFamilyRepository) {
        this.ramaSaludFamilyRepository = ramaSaludFamilyRepository;
    }

    @Override
    public RamaSaludFamily createRamaSaludFamily(RamaSaludFamily ramaSaludFamily) {
        return this.ramaSaludFamilyRepository.save(null);
    }

    @Override
    public String deleteRamaSaludFamily(Long id) {
        findRamaSaludFamilyById(id);
        this.ramaSaludFamilyRepository.deleteById(id);
        return "fue elimanodo exitosamente";
    }

    @Override
    public List<RamaSaludFamily> findRamaSaludFamiliesAll() {
        return this.ramaSaludFamilyRepository.findAll() ;
    }

    @Override
    public RamaSaludFamily findRamaSaludFamilyById(Long id) {
        return this.ramaSaludFamilyRepository
                   .findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public RamaSaludFamily updateRamaSaludFamily(Long id, RamaSaludFamily ramaSaludFamily) {
        
        Optional<RamaSaludFamily>ramaSaludFamilyOptional = this.ramaSaludFamilyRepository.findById(id);
        
        if(ramaSaludFamilyOptional.isPresent()){
            RamaSaludFamily existRamaSaludFamily = ramaSaludFamilyOptional.get();

            existRamaSaludFamily.setCharacteristics(ramaSaludFamily.getCharacteristics());
            existRamaSaludFamily.setPlanFamilies(ramaSaludFamily.getPlanFamilies());
            existRamaSaludFamily.setSubRamaSaludFamily(ramaSaludFamily.getSubRamaSaludFamily());

            return this.ramaSaludFamilyRepository.save(existRamaSaludFamily);
        }else{
            throw new RuntimeException("not found");
        }
        

    }
    
}
