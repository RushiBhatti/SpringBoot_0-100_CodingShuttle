package com.learningspring.rushi.week2homework.Week2Homework.controllers;

import com.learningspring.rushi.week2homework.Week2Homework.dto.DepartmentDTO;
import com.learningspring.rushi.week2homework.Week2Homework.exceptions.ResourceNotFoundException;
import com.learningspring.rushi.week2homework.Week2Homework.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId){
        Optional<DepartmentDTO> departmentDTO1 = departmentService.getDepartmentById(departmentId);
        return departmentDTO1
                .map(departmentDTO -> ResponseEntity.ok(departmentDTO))
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id : " + departmentId));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.createNewDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable(name = "departmentId") Long id,
                                                              @RequestBody @Valid DepartmentDTO departmentDTO) {
       DepartmentDTO departmentDTO1 = departmentService.updateDepartmentById(id,departmentDTO);
       if (departmentDTO1 == null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(departmentDTO1);
    }

    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> partiallyUpdateDepartmentById(@PathVariable Long departmentId, @RequestBody Map<String, Object> updates){
        DepartmentDTO departmentDTO = departmentService.partiallyUpdateDepartmentById(departmentId,updates);
        return ResponseEntity.ok(departmentDTO);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long departmentId){
        boolean isDeleted = departmentService.deleteDepartmentById(departmentId);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted Successfully...");
    }

}
