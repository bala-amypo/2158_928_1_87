// package com.example.demo.controller;

// import com.example.demo.entity.EmissionFactor;
// import com.example.demo.service.EmissionFactorService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/factors")
// @Tag(name = "EmissionFactorController")
// public class EmissionFactorController {
//     private final EmissionFactorService factorService;

//     public EmissionFactorController(EmissionFactorService factorService) {
//         this.factorService = factorService;
//     }

//     @PostMapping("/{activityTypeId}")
//     public EmissionFactor create(@PathVariable Long activityTypeId, @RequestBody EmissionFactor factor) {
//         return factorService.createFactor(activityTypeId, factor);
//     }

//     @GetMapping("/{id}")
//     public EmissionFactor get(@PathVariable Long id) {
//         return factorService.getFactor(id);
//     }

//     @GetMapping("/type/{activityTypeId}")
//     public EmissionFactor getByType(@PathVariable Long activityTypeId) {
//         return factorService.getFactorByType(activityTypeId);
//     }

//     @GetMapping("/")
//     public List<EmissionFactor> listAll() {
//         return factorService.getAllFactors();
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService factorService;

    public EmissionFactorController(EmissionFactorService factorService) {
        this.factorService = factorService;
    }

    @PostMapping("/{activityTypeId}")
    public ResponseEntity<EmissionFactor> createFactor(
            @PathVariable Long activityTypeId, 
            @RequestBody EmissionFactor factor) {
        return ResponseEntity.ok(factorService.createFactor(activityTypeId, factor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmissionFactor> getFactorById(@PathVariable Long id) {
        return ResponseEntity.ok(factorService.getFactor(id));
    }

    @GetMapping("/type/{activityTypeId}")
    public ResponseEntity<EmissionFactor> getFactorByType(@PathVariable Long activityTypeId) {
        return ResponseEntity.ok(factorService.getFactorByType(activityTypeId));
    }

    @GetMapping
    public ResponseEntity<List<EmissionFactor>> getAllFactors() {
        return ResponseEntity.ok(factorService.getAllFactors());
    }
}