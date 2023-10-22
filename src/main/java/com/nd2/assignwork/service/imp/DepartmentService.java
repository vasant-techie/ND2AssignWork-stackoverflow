package com.nd2.assignwork.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nd2.assignwork.converter.DepartmentConverter;
import com.nd2.assignwork.dto.DepartmentDTO;
import com.nd2.assignwork.entity.DepartmentEntity;
import com.nd2.assignwork.entity.UserAccountEntity;
import com.nd2.assignwork.repository.DepartmentRepository;
import com.nd2.assignwork.repository.UserAccountRepository;
import com.nd2.assignwork.service.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService {
	
	@Autowired
	private DepartmentConverter departmentConverter;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public DepartmentDTO save(DepartmentDTO departmentDTO) {
		DepartmentEntity departmentEntity = new DepartmentEntity();

		DepartmentEntity oldDepartmentEntity = departmentRepository.findOne(departmentDTO.getDepartmentID());
		if(oldDepartmentEntity != null) {
			departmentEntity = departmentConverter.toEntity(departmentDTO, oldDepartmentEntity);
		} else {
			departmentEntity = departmentConverter.toEntity(departmentDTO);
		}
		
		departmentEntity = departmentRepository.save(departmentEntity);
		return departmentConverter.toDTO(departmentEntity);
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids) {
			departmentRepository.delete(id);
		}
	}

	@Override
	public List<DepartmentDTO> findAll() {
		List<DepartmentDTO> result = new ArrayList<>();
		List<DepartmentEntity> entities = departmentRepository.findAll();
		
		for(DepartmentEntity entity: entities) {
			DepartmentDTO dto = departmentConverter.toDTO(entity);
			result.add(dto);
		}
		return result;
	}
}
