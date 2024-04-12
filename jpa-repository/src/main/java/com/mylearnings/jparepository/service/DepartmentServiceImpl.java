package com.mylearnings.jparepository.service;

import com.mylearnings.jparepository.entity.Department;
import com.mylearnings.jparepository.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department dept = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department) && !department.getDepartmentName().isEmpty()) {
            dept.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department) && !department.getDepartmentName().isEmpty()) {
            dept.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department) && !department.getDepartmentName().isEmpty()) {
            dept.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(dept);

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        departmentRepository.delete(department);
    }
}
