package com.mylearnings.jparepository.controller;

import com.mylearnings.jparepository.entity.Department;
import com.mylearnings.jparepository.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{deptId}")
    public Department updateDepartment(@RequestBody Department dept, @PathVariable Long deptId) {
        return departmentService.updateDepartment(dept, deptId);
    }

    @DeleteMapping("/departments/{deptId}")
    public String  deleteDepartmentById(@PathVariable Long deptId){
        departmentService.deleteDepartmentById(deptId);
        return "Department has been deleted successfully";
    }
}
