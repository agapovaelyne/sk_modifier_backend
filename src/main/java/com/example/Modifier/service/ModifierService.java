package com.example.Modifier.service;

import com.example.Modifier.dto.IncreaseRequestDTO;
import com.example.Modifier.dto.IncreaseResponseDTO;
import com.example.Modifier.exception.ModifyOperationError;
import com.example.Modifier.repository.ModifierRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ModifierService {

    private ModifierRepository modifierRepository;

    public ModifierService(ModifierRepository modifierRepository) {
        this.modifierRepository = modifierRepository;
    }

    public IncreaseResponseDTO increaseCurrent(IncreaseRequestDTO increaseRequestObject) {
        int value = increaseRequestObject.getAdd();
        if (value == 0) {
            throw new ModifyOperationError("No modifies expected");
        }
        int current = modifierRepository.increaseCurrent(increaseRequestObject.getId(), value).orElseThrow(() -> new EntityNotFoundException("Value not found"));
        return new IncreaseResponseDTO(current);
    }
}
