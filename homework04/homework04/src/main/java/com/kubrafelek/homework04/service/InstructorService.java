package com.kubrafelek.homework04.service;

import com.kubrafelek.homework04.dto.InstructorDTO;
import com.kubrafelek.homework04.exceptions.InstructorIsAlreadyExistException;
import com.kubrafelek.homework04.mappers.InstructorMapper;
import com.kubrafelek.homework04.model.Instructor;
import com.kubrafelek.homework04.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Transactional
    public Optional<Instructor> saveInstructor(InstructorDTO instructorDTO) {

        boolean isExists = instructorRepository.selectExistsPhoneNumber(instructorDTO.getPhoneNumber());
        if (isExists) {
            throw new InstructorIsAlreadyExistException("Instructor phone number " + instructorDTO.getPhoneNumber() + " is already exists !");
        }

        Instructor instructor = instructorMapper.mapFromInstructorDTOtoInstructor(instructorDTO);
        return Optional.of(instructorRepository.save(instructor));
    }

    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        Iterable<Instructor> instructorIterable = instructorRepository.findAll();
        instructorIterable.iterator().forEachRemaining(instructorList::add);
        return instructorList;
    }

    @Transactional
    public Instructor findInstructorById(long id) {
        return instructorRepository.findById(id).get();
    }

    @Transactional
    public Instructor updateInstructor(InstructorDTO instructorDTO, long id) {
        Instructor findInstructor = findInstructorById(id);
        findInstructor.setName(instructorDTO.getName());
        findInstructor.setAddress(instructorDTO.getAddress());
        findInstructor.setPhoneNumber(instructorDTO.getPhoneNumber());
        return instructorRepository.save(findInstructor);
    }

    public String deleteInstructorById(long id) {
        instructorRepository.deleteById(id);
        return "Instructor id => " + id + " Deleted....";
    }

}
