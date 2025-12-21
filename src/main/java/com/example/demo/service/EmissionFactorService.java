package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import org.springframework.stereotype.Service;

@Service
public class EmissionFactorService {

    private final EmissionFactorRepository repo;
    private final ActivityTypeRepository typeRepo;

    public EmissionFactorService(EmissionFactorRepository repo,
                                 ActivityTypeRepository typeRepo) {
        this.repo = repo;
        this.typeRepo = typeRepo;
    }

    public EmissionFactor create(EmissionFactor factor) {
        ActivityType type = typeRepo.findById(
                factor.getActivityType().getId()
        ).orElseThrow(() -> new RuntimeException("Activity type not found"));

        factor.setActivityType(type);
        return repo.save(factor);
    }
}


// package com.example.demo.service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.ActivityType;
// import com.example.demo.entity.EmissionFactor;
// import com.example.demo.repository.ActivityTypeRepository;
// import com.example.demo.repository.EmissionFactorRepository;

// @Service
// public class EmissionFactorService {

//     private final EmissionFactorRepository repo;
//     private final ActivityTypeRepository typeRepo;

//     public EmissionFactorService(EmissionFactorRepository repo,
//                                  ActivityTypeRepository typeRepo) {
//         this.repo = repo;
//         this.typeRepo = typeRepo;
//     }

//     public EmissionFactor createFactor(Long typeId, EmissionFactor f) {
//         ActivityType type = typeRepo.findById(typeId).orElseThrow();
//         f.setActivityType(type);
//         return repo.save(f);
//     }

//     public EmissionFactor getFactor(Long id) {
//         return repo.findById(id).orElseThrow();
//     }

//     public List<EmissionFactor> getAllFactors() {
//         return repo.findAll();
//     }
// }
