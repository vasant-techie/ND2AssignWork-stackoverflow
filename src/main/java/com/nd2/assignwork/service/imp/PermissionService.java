package com.nd2.assignwork.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nd2.assignwork.converter.PermissionConverter;
import com.nd2.assignwork.dto.PermissionDTO;
import com.nd2.assignwork.entity.PermissionEntity;
import com.nd2.assignwork.repository.PermissionRepository;
import com.nd2.assignwork.service.IPermissionService;

@Service
public class PermissionService implements IPermissionService {
	
	@Autowired
	private PermissionConverter permissionConverter;
	
	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public PermissionDTO save(PermissionDTO permissionDTO) {
		PermissionEntity permissionEntity = new PermissionEntity();

		if(permissionDTO.getPermissionID() != null) {
			PermissionEntity oldPermissionEntity = permissionRepository.findOne(permissionDTO.getPermissionID());
			permissionEntity = permissionConverter.toEntity(permissionDTO, oldPermissionEntity);
		} else {
			permissionEntity = permissionConverter.toEntity(permissionDTO);
		}
		
		permissionEntity = permissionRepository.save(permissionEntity);
		return permissionConverter.toDTO(permissionEntity);
	}

	@Override
	public void delete(int[] ids) {
		for(int id: ids) {
			permissionRepository.delete(id);
		}
	}

	@Override
	public List<PermissionDTO> findAll() {
		List<PermissionDTO> result = new ArrayList<>();
		List<PermissionEntity> entities = permissionRepository.findAll();
		
		for(PermissionEntity entity: entities) {
			PermissionDTO dto = permissionConverter.toDTO(entity);
			result.add(dto);
		}
		return result;
	}

}
