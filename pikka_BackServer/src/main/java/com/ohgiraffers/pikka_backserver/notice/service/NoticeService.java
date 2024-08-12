package com.ohgiraffers.pikka_backserver.notice.service;

import com.ohgiraffers.pikka_backserver.notice.entity.NoticeEntity;
import com.ohgiraffers.pikka_backserver.notice.model.NoticeDTO;
import com.ohgiraffers.pikka_backserver.notice.repository.NoticeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class NoticeService {

    private static final Logger logger = LoggerFactory.getLogger(NoticeService.class);
    private final NoticeRepository noticeRepository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public ResponseEntity<List<NoticeDTO>> getAllNotices() {
        List<NoticeDTO> notices = noticeRepository.findAllByOrderByNotiCreateAtDesc().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(notices);
    }

    public ResponseEntity<NoticeDTO> getNotice(Integer id) {
        try {
            NoticeDTO notice = noticeRepository.findById(id)
                    .map(this::convertToDTO)
                    .orElseThrow(() -> new NoSuchElementException("Notice not found with id: " + id));
            return ResponseEntity.ok(notice);
        } catch (NoSuchElementException e) {
            logger.warn("Notice not found with id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<NoticeDTO> createNotice(NoticeDTO noticeDTO) {
        try {
            NoticeEntity noticeEntity = convertToEntity(noticeDTO);
            ensureNotiCreateAt(noticeEntity);
            NoticeEntity savedEntity = noticeRepository.save(noticeEntity);
            logger.info("Created notice with id: {}", savedEntity.getNotiId());
            return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(savedEntity));
        } catch (Exception e) {
            logger.error("Error creating notice", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Transactional
    public ResponseEntity<NoticeDTO> updateNotice(Integer id, NoticeDTO noticeDTO) {
        try {
            NoticeEntity existingNotice = noticeRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Notice not found with id: " + id));

            updateEntityFromDTO(existingNotice, noticeDTO);
            existingNotice.setNotiModiDate(LocalDateTime.now().format(DATE_FORMATTER));

            NoticeEntity updatedEntity = noticeRepository.save(existingNotice);
            logger.info("Updated notice with id: {}", updatedEntity.getNotiId());
            return ResponseEntity.ok(convertToDTO(updatedEntity));
        } catch (NoSuchElementException e) {
            logger.warn("Notice not found with id: {}", id);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error("Error updating notice with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Transactional
    public ResponseEntity<Void> deleteNotice(Integer id) {
        try {
            if (!noticeRepository.existsById(id)) {
                logger.warn("Attempt to delete non-existent notice with id: {}", id);
                return ResponseEntity.notFound().build();
            }
            noticeRepository.deleteById(id);
            logger.info("Deleted notice with id: {}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting notice with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private NoticeDTO convertToDTO(NoticeEntity noticeEntity) {
        return new NoticeDTO(
                noticeEntity.getNotiId(),
                noticeEntity.getNotiAdminId(),
                noticeEntity.getNotiAdminName(),
                noticeEntity.getNotiTitle(),
                noticeEntity.getNotiContents(),
                noticeEntity.getNotiCreateAt(),
                noticeEntity.getNotiStartDate(),
                noticeEntity.getNotiCloseDate(),
                noticeEntity.getNotiModiDate()
        );
    }

    private NoticeEntity convertToEntity(NoticeDTO noticeDTO) {
        NoticeEntity entity = new NoticeEntity();
        updateEntityFromDTO(entity, noticeDTO);
        return entity;
    }

    private void updateEntityFromDTO(NoticeEntity entity, NoticeDTO dto) {
        entity.setNotiAdminId(dto.getNotiAdminId());
        entity.setNotiAdminName(dto.getNotiAdminName());
        entity.setNotiTitle(dto.getNotiTitle());
        entity.setNotiContents(dto.getNotiContents());
        entity.setNotiStartDate(dto.getNotiStartDate());
        entity.setNotiCloseDate(dto.getNotiCloseDate());
        ensureNotiCreateAt(entity);
    }

    private void ensureNotiCreateAt(NoticeEntity entity) {
        if (entity.getNotiCreateAt() == null || entity.getNotiCreateAt().isEmpty()) {
            entity.setNotiCreateAt(LocalDateTime.now().format(DATE_FORMATTER));
        }
    }
}