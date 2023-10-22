package com.nd2.assignwork.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nd2.assignwork.converter.DocumentSendConverter;
import com.nd2.assignwork.converter.PermissionConverter;
import com.nd2.assignwork.converter.UserAccountConverter;
import com.nd2.assignwork.dto.DocumentSendDTO;
import com.nd2.assignwork.dto.PermissionDTO;
import com.nd2.assignwork.dto.UserAccountDTO;
import com.nd2.assignwork.entity.DepartmentEntity;
import com.nd2.assignwork.entity.DocumentSendEntity;
import com.nd2.assignwork.entity.PermissionEntity;
import com.nd2.assignwork.entity.PositionEntity;
import com.nd2.assignwork.entity.UserAccountEntity;
import com.nd2.assignwork.repository.DepartmentRepository;
import com.nd2.assignwork.repository.DocumentSendRepository;
import com.nd2.assignwork.repository.PermissionRepository;
import com.nd2.assignwork.repository.PositionRepository;
import com.nd2.assignwork.repository.UserAccountRepository;
import com.nd2.assignwork.service.IUserAccountService;

@Service
public class UserAccountService implements IUserAccountService {

	@Autowired
	private UserAccountConverter userAccountConverter;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private PositionRepository positionRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private PermissionConverter permissionConverter;
	
	@Autowired
	private DocumentSendRepository documentSendRepository;
	
	@Autowired
	private DocumentSendConverter documentSendConverter;

	@Override
	public UserAccountDTO save(UserAccountDTO userAccountDTO) {
		UserAccountEntity userAccountEntity = new UserAccountEntity();

		UserAccountEntity oldUserAccountEntity = userAccountRepository.findOne(userAccountDTO.getUserID());
		if (oldUserAccountEntity != null) {
			userAccountEntity = userAccountConverter.toEntity(userAccountDTO, oldUserAccountEntity);
		} else {
			userAccountEntity = userAccountConverter.toEntity(userAccountDTO);
		}

		PositionEntity positionEntity = positionRepository.findOneByPositionName(userAccountDTO.getUserPosition());
		userAccountEntity.setUserPosition(positionEntity);

		userAccountEntity = userAccountRepository.save(userAccountEntity);
		return userAccountConverter.toDTO(userAccountEntity);
	}

	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			userAccountRepository.delete(id);
		}
	}

	@Override
	public List<UserAccountDTO> findAll() {
		List<UserAccountDTO> result = new ArrayList<>();
		List<UserAccountEntity> entities = userAccountRepository.findAll();

		for (UserAccountEntity entity : entities) {
			UserAccountDTO dto = userAccountConverter.toDTO(entity);
			// Get list of user's permission
			for (PermissionEntity permission : entity.getPermission()) {
				PermissionDTO permissionDTO = permissionConverter.toDTO(permission);
				dto.getPermissionName().add(permissionDTO.getPermissionName());
			}
			// Get list of user's document receive
			for (DocumentSendEntity documentSend : entity.getDocumentSend()) {
				DocumentSendDTO documentSendDTO = documentSendConverter.toDTO(documentSend);
				dto.getDocumentReceive().add(documentSendDTO.getDocumentSendTitle());
			}
			
			result.add(dto);
		}
		return result;
	}

	@Override
	public UserAccountDTO findSingleUser(String userId) {
		UserAccountEntity user = userAccountRepository.findOne(userId);
		UserAccountDTO userAccountDTO = userAccountConverter.toDTO(user);

		// Get list of user's permission from UserAccountEntity.
		for (PermissionEntity permission : user.getPermission()) {
			PermissionDTO permissionDTO = permissionConverter.toDTO(permission);
			userAccountDTO.getPermissionName().add(permissionDTO.getPermissionName());
		}
		// Get list of user's document receive from UserAccountEntity.
		for (DocumentSendEntity documentSend : user.getDocumentSend()) {
			DocumentSendDTO documentSendDTO = documentSendConverter.toDTO(documentSend);
			userAccountDTO.getDocumentReceive().add(documentSendDTO.getDocumentSendTitle());
		}

		return userAccountDTO;
	}
	
	// UserAccount - Permission
	@Override
	public void addPermissionForUser(String userId, int permissionId) {
		UserAccountEntity user = userAccountRepository.findOne(userId);
		PermissionEntity permission = permissionRepository.findOne(permissionId);

		if (user != null && permission != null) {
			// Check permission exist yet?
			boolean oldPermissionExists = user.getPermission().contains(permission);
			
			if (!oldPermissionExists) {
				user.getPermission().add(permission);
				userAccountRepository.save(user);
			}
		}
	}

	@Override
	public void deletePermissionForUser(String userId, int permissionId) {
	    UserAccountEntity user = userAccountRepository.findOne(userId);
	    PermissionEntity permission = permissionRepository.findOne(permissionId);

	    if (user != null && permission != null) {
	    	// Check permission exist yet?
	        boolean oldPermissionExists = user.getPermission().contains(permission);

	        if (oldPermissionExists) {
	        	// Permission existed, so remove it.
	            user.getPermission().remove(permission);
	            userAccountRepository.save(user);
	        }
	    }
	}
	
	// User - Receive - Document
	@Override
	public void addDocumentReceiveForUser(String userId, String documentSendId) {
		UserAccountEntity user = userAccountRepository.findOne(userId);
		DocumentSendEntity documentSend = documentSendRepository.findOne(documentSendId);

		if (user != null && documentSend != null) {
			user.getDocumentSend().add(documentSend);
			userAccountRepository.save(user);
		}
	}
	
	@Override
	public void deleteDocumentReceiveForUser(String userId, String documentSendId) {
	    UserAccountEntity user = userAccountRepository.findOne(userId);
	    DocumentSendEntity documentSend = documentSendRepository.findOne(documentSendId);

	    if (user != null && documentSend != null) {
	        // Check document exist yet?
	        boolean documentSendExists = user.getDocumentSend().contains(documentSend);

	        if (documentSendExists) {
	            // Document existed, so remove it.
	            user.getDocumentSend().remove(documentSend);
	            // Save update into database.
	            userAccountRepository.save(user);
	        }
	    }
	}
}
