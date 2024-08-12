package com.ohgiraffers.pikka_backserver.notice.controller;

import com.ohgiraffers.pikka_backserver.notice.model.NoticeDTO;
import com.ohgiraffers.pikka_backserver.notice.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173/insert/notice")
@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping
    public ResponseEntity<List<NoticeDTO>> getAllNotices() {
        logger.info("Retrieving all notices");
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticeDTO> getNotice(@PathVariable Integer id) {
        logger.info("Retrieving notice with ID: {}", id);
        return noticeService.getNotice(id);
    }

    @PostMapping
    public ResponseEntity<NoticeDTO> createNotice(@RequestBody NoticeDTO noticeDTO) {
        logger.info("Creating new notice: {}", noticeDTO);
        return noticeService.createNotice(noticeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticeDTO> updateNotice(@PathVariable Integer id, @RequestBody NoticeDTO noticeDTO) {
        logger.info("Updating notice with ID: {}", id);
        return noticeService.updateNotice(id, noticeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Integer id) {
        try {
            logger.info("Received delete request for notice ID: {}", id);
            ResponseEntity<Void> response = noticeService.deleteNotice(id);
            logger.info("Delete operation completed for notice ID: {}", id);
            return response;
        } catch (IllegalArgumentException e) {
            logger.error("Invalid notice ID: {}", id, e);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Error deleting notice with ID: {}", id, e);
            return ResponseEntity.internalServerError().build();
        }
    }
}