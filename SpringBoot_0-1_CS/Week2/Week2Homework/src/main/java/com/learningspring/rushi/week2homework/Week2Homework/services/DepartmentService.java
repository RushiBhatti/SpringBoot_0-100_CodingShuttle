package com.learningspring.rushi.week2homework.Week2Homework.services;

import com.learningspring.rushi.week2homework.Week2Homework.dto.DepartmentDTO;
import com.learningspring.rushi.week2homework.Week2Homework.entities.DepartmentEntity;
import com.learningspring.rushi.week2homework.Week2Homework.exceptions.ResourceNotFoundException;
import com.learningspring.rushi.week2homework.Week2Homework.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper mapper){
        this.departmentRepository = departmentRepository;
        this.modelMapper = mapper;
    }

    public Optional<DepartmentDTO> getDepartmentById(Long id){
        return departmentRepository.findById(id).map(departmentEntity -> modelMapper.map(departmentEntity,
                DepartmentDTO.class));
    }

    public List<DepartmentDTO> getAllDepartments(){
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO){
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long id, DepartmentDTO departmentDTO){
        isDepartmentExistsById(id);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(id);
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }

    public DepartmentDTO partiallyUpdateDepartmentById(Long id, Map<String, Object> updates){
        isDepartmentExistsById(id);
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();

        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value);
        });

        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long id){
        isDepartmentExistsById(id);

        departmentRepository.deleteById(id);
        return true;
    }

    private void isDepartmentExistsById(Long id){
        if(!departmentRepository.existsById(id)){
            throw new ResourceNotFoundException("Department not found with id = " + id);
        }
    }

}
