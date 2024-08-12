package com.ohgiraffers.pikka_backserver.curation02.controller;

import com.ohgiraffers.pikka_backserver.curation02.entity.CurationEntity;
import com.ohgiraffers.pikka_backserver.curation02.model.CurationDTO;
import com.ohgiraffers.pikka_backserver.curation02.service.CurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/curation")
public class CurationController {

    private static final Logger logger = Logger.getLogger(CurationController.class.getName());

    @Autowired
    private CurationService service;

    @PostMapping
    public ResponseEntity<CurationEntity> createItem(@RequestBody CurationDTO curationDTO) {
        CurationEntity createdItem = service.createItem(curationDTO);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurationEntity>> getAllItems() {
        List<CurationEntity> items = service.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurationEntity> getItemById(@PathVariable Long id) {
        CurationEntity item = service.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurationEntity> updateItem(@PathVariable Long id, @RequestBody CurationDTO curationDTO) {
        CurationEntity updatedItem = service.updateItem(id, curationDTO);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            logger.warning("파일이 없습니다.");
            return new ResponseEntity<>("파일이 없습니다.", HttpStatus.BAD_REQUEST);
        }

        try {
            // 파일 저장 경로 설정
            String uploadDir = System.getProperty("user.dir") + "/uploads/";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            // 파일 이름 설정
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            File dest = new File(uploadDir + fileName);
            file.transferTo(dest);

            // 파일 URL 생성
            String fileUrl = "/uploads/" + fileName;
            logger.info("파일 업로드 성공: " + fileUrl);
            return new ResponseEntity<>(fileUrl, HttpStatus.OK);
        } catch (IOException e) {
            logger.severe("파일 업로드 중 오류 발생: " + e.getMessage());
            return new ResponseEntity<>("파일 업로드 중 오류 발생.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}