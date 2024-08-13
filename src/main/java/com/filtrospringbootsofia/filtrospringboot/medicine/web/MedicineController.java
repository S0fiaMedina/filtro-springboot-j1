package com.filtrospringbootsofia.filtrospringboot.medicine.web;



import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filtrospringbootsofia.filtrospringboot.medicine.domain.dto.MedicineDto;
import com.filtrospringbootsofia.filtrospringboot.medicine.domain.service.MedicineService;
import com.filtrospringbootsofia.filtrospringboot.medicine.persistence.Medicine;

import jakarta.validation.Valid;






@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService service;
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id){
        try {
            Optional<Medicine> med = this.service.delete(id);
            return ResponseEntity.ok("Se ha eliminado correctamente");
            
        } catch (DataIntegrityViolationException  e) {
            return ResponseEntity.badRequest().body( "No puedes eliminar esta medicina ya que farmacyMedicine tiene registros de esta tabla :( \n O ha ocurrido algo extraño:  :/" + e.getMessage());
        }
        
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Medicine> med =  this.service.findById(id);

        if (med.isPresent()){
            return ResponseEntity.ok(med.get());
        }
        return ResponseEntity.notFound().build();
    }
    

    @PostMapping
    public ResponseEntity<?> postMethodName( @Valid @RequestBody MedicineDto med, BindingResult result) {
        if ( result.hasErrors()){
            return this.validation(result);
        }
        Medicine newM = this.service.save(med);
        med.setId(newM.getId());
        return ResponseEntity.ok(med);
    }

    @GetMapping
    public List<Medicine> getMethodName() {
        return this.service.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable Long id, @Valid @RequestBody MedicineDto dto, BindingResult result) {

        if ( result.hasErrors()){
            return this.validation(result);
        }

        Optional<Medicine> optionalMedicine = this.service.findById(id);

        if (optionalMedicine.isPresent()){
            return ResponseEntity.ok(this.service.update(dto, id));
        }
        
        return ResponseEntity.notFound().build();
    }

    

    private ResponseEntity<?> validation(BindingResult result){
        HashMap<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(
            err -> errors.put( err.getField(), err.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body( errors);
    }
    
}
