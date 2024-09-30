package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("  /api/v1/registration")
public class RegistrationCotroller {

    private RegistrationService registrationService;

    private RegistrationDto registrationDto;


    public RegistrationCotroller(RegistrationService registrationService) {
        this.registrationService = registrationService;

    }

    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.getRegistrations();
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<RegistrationDto> getRegistrationById(
            @PathVariable() long id
    ){
        RegistrationDto dto=registrationService.getRegistrationBtId(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);

}
    @PostMapping
   public ResponseEntity<?> createRegistration(
       @Valid @RequestBody RegistrationDto registrationDto,
         BindingResult result
    ) {
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage() , HttpStatus.CREATED);
        }

        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);

    }


    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(
            @RequestParam long id
           ) {
        registrationService.deleteRegistration(id );
        return new ResponseEntity<>("Deleted", HttpStatus.OK);

    }
}


