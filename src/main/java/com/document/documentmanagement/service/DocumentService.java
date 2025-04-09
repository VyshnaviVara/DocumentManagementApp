package com.document.documentmanagement.service;


import com.document.documentmanagement.entity.Document;
import com.document.documentmanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Async
    public CompletableFuture<Document> ingestDocument(MultipartFile file, String author) throws IOException {
        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        document.setFileType(file.getContentType());
        document.setAuthor(author);
        document.setUploadDate(LocalDate.now());
        document.setContent(file.getBytes());

        // Save document to database
        return CompletableFuture.completedFuture(documentRepository.save(document));
    }


}
