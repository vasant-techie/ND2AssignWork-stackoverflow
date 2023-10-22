package com.nd2.assignwork.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nd2.assignwork.converter.PositionConverter;
import com.nd2.assignwork.dto.PositionDTO;
import com.nd2.assignwork.entity.PositionEntity;
import com.nd2.assignwork.repository.PositionRepository;
import com.nd2.assignwork.service.IPositionService;

@Service
public class PositionService implements IPositionService {
	
	@Autowired
	private PositionConverter positionConverter;
	
	@Autowired
	private PositionRepository positionRepository;

	@Override
	public PositionDTO save(PositionDTO positionDTO) {
		PositionEntity positionEntity = new PositionEntity();

		if(positionDTO.getPositionID() != null) {
			PositionEntity oldPositionEntity = positionRepository.findOne(positionDTO.getPositionID());
			positionEntity = positionConverter.toEntity(positionDTO, oldPositionEntity);
		} else {
			positionEntity = positionConverter.toEntity(positionDTO);
		}
		
		positionEntity = positionRepository.save(positionEntity);
		return positionConverter.toDTO(positionEntity);
	}

	@Override
	public void delete(int[] ids) {
		for(int id: ids) {
			positionRepository.delete(id);
		}
		
	}

	@Override
	public List<PositionDTO> findAll() {
		List<PositionDTO> result = new ArrayList<>();
		List<PositionEntity> entities = positionRepository.findAll();
		
		for(PositionEntity entity: entities) {
			PositionDTO dto = positionConverter.toDTO(entity);
			result.add(dto);
		}
		return result;
	}
}
