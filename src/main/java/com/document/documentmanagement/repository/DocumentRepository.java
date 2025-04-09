package com.document.documentmanagement.repository;


import com.document.documentmanagement.entity.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

//    @Query("SELECT d FROM Document d WHERE LOWER(d.content) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//    List<Document> searchByKeyword(@Param("keyword") String keyword);
//
//    Page<Document> findAll(Specification<Document> spec, Pageable pageable);

}
