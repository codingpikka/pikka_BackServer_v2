package com.ohgiraffers.pikka_backserver.curation.controller;


import com.ohgiraffers.pikka_backserver.curation.entity.CurationEntity;
import com.ohgiraffers.pikka_backserver.curation.model.CurationDTO;
import com.ohgiraffers.pikka_backserver.curation.service.CurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curation")
public class CurationController {

    @Autowired
    private CurationService service;

    @GetMapping
    public ResponseEntity<List<CurationEntity>> getAllItems() {
        List<CurationEntity> items = service.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurationEntity> getItemById(@PathVariable Integer id) {
        Optional<CurationEntity> item = service.findById(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CurationEntity> createItem(@RequestBody CurationDTO curationDTO) {
        CurationEntity item = new CurationEntity();
        item.setCategory(curationDTO.getCategory());
        item.setTitle(curationDTO.getTitle());
        item.setDate(curationDTO.getDate());
        CurationEntity savedItem = service.save(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurationEntity> updateItem(@PathVariable Integer id, @RequestBody CurationDTO curationDTO) {
        Optional<CurationEntity> existingItem = service.findById(id);
        if (existingItem.isPresent()) {
            CurationEntity item = existingItem.get();
            item.setCategory(curationDTO.getCategory());
            item.setTitle(curationDTO.getTitle());
            item.setDate(curationDTO.getDate());
            CurationEntity updatedItem = service.save(item);
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
        Optional<CurationEntity> existingItem = service.findById(id);
        if (existingItem.isPresent()) {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
