package com.example.Modifier.service;

import com.example.Modifier.dto.IncreaseRequestDTO;
import com.example.Modifier.dto.IncreaseResponseDTO;
import com.example.Modifier.exception.ModifyOperationError;
import com.example.Modifier.repository.ModifierRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ModifierService {

    private final ModifierRepository modifierRepository;

    public ModifierService(ModifierRepository modifierRepository) {
        this.modifierRepository = modifierRepository;
    }

    public IncreaseResponseDTO increaseCurrent(IncreaseRequestDTO increaseRequestObject) {
        if (increaseRequestObject.getAdd() == 0) {
            throw new ModifyOperationError("No modifies expected");
        }
        int current = modifierRepository.increaseCurrent(increaseRequestObject.getId(), increaseRequestObject.getAdd()).orElseThrow(() -> new EntityNotFoundException("Value not found"));
        return new IncreaseResponseDTO(current);
    }
}
