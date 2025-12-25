// package com.example.demo.repository;
// import com.example.demo.entity.EmissionFactor;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, Long> {
//     Optional<EmissionFactor> findByActivityType_Id(Long typeId);
// }

package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, Long> {
    
    // Used in t82_getFactorByType_found and log-activity emission calculations
    Optional<EmissionFactor> findByActivityType_Id(Long typeId);
}