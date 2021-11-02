package com.example.Modifier.controller;

import com.example.Modifier.dto.IncreaseRequestDTO;
import com.example.Modifier.dto.IncreaseResponseDTO;
import com.example.Modifier.service.ModifierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping()
@Validated
public class ModifierController {

    private final ModifierService modifierService;

    public ModifierController(ModifierService modifierService) {
        this.modifierService = modifierService;
    }

    @ResponseBody
    @PostMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IncreaseResponseDTO> increaseCurrent(@RequestBody @Valid IncreaseRequestDTO increaseRequestObject) {
        return new ResponseEntity<>(modifierService.increaseCurrent(increaseRequestObject), HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> handleRunTimeExc(RuntimeException exc) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).contentType(MediaType.APPLICATION_JSON).body(exc.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> handleRunTimeExc(MethodArgumentNotValidException exc) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).contentType(MediaType.APPLICATION_JSON).body(exc.getLocalizedMessage());
    }

}
