package com.example.Modifier.repository;

import com.example.Modifier.entity.SkObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class ModifierRepository {

    @Autowired
    private SKRepository skRepository;

    @Transactional
    public Optional<Integer> increaseCurrent(int id, int add) {
        System.out.println();
        try {
            SkObject entity = skRepository.findById(id).get();
            entity.increaseCurrent(add);
            skRepository.save(entity);
            return Optional.of(entity.getJsonObj().getCurrent().get());
        } catch (NoSuchElementException ex) {
            return Optional.empty();
        }
    }
}
