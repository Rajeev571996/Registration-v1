package com.api.service;

import com.api.entity.Registration;
import com.api.exception.RecordNotFound;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RegistrationService {
    private ModelMapper modelMapper;

    private RegistrationRepository registrationRepository;

    public RegistrationService(ModelMapper modelMapper, RegistrationRepository registrationRepository) {
        this.modelMapper = modelMapper;
        this.registrationRepository = registrationRepository;

    }

    public List<Registration> getRegistrations() {
        List<Registration> registrations = registrationRepository.findAll();
        return registrations;
    }


    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
        //copy dto to entity
        Registration registration = mapToEntity(registrationDto);
        Registration savedEntity = registrationRepository.save(registration);
        //copy entity to dto
        RegistrationDto dto = mapToDto(savedEntity);
        return dto;
    }

    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);
    }

    Registration mapToEntity(RegistrationDto registrationDto) {
        Registration registration = modelMapper.map(registrationDto, Registration.class);
        // Registration registration = new Registration();
        //   registration.setName(registrationDto.getName());
        //   registration.setEmail(registrationDto.getName());
        //   registration.setMobile(registrationDto.getMobile());
        return registration;
    }

    RegistrationDto mapToDto(Registration registration) {
        RegistrationDto dto = modelMapper.map(registration, RegistrationDto.class);
        // RegistrationDto dto= new RegistrationDto();
        // dto.setName(registration.getName());
        // dto.setEmail(registration.getEmail());
        //  v   dto.setMobile(registration.getMobile());
        return dto;
    }

    public RegistrationDto getRegistrationBtId(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                ()->new RecordNotFound("Record Not Found")
        );
       return mapToDto(registration);
    }

}
