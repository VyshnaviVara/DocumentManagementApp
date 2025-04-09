package com.document.documentmanagement;

import com.document.documentmanagement.entity.Document;
import com.document.documentmanagement.repository.DocumentRepository;
import com.document.documentmanagement.service.DocumentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DocumentServiceTest {

    @Mock
    private DocumentRepository documentRepository;

    @InjectMocks
    private DocumentService documentService;

    @Mock
    private MultipartFile file;

    @Test
    public void testIngestDocument() throws IOException {
        // Arrange
        String author = "John Doe";
        String fileName = "test_document.pdf";
        String contentType = "application/pdf";
        byte[] content = new byte[]{1, 2, 3, 4}; // example byte content

        // Mock the MultipartFile methods
        Mockito.when(file.getOriginalFilename()).thenReturn(fileName);
        Mockito.when(file.getContentType()).thenReturn(contentType);
        Mockito.when(file.getBytes()).thenReturn(content);

        // Create a mock document to return from the repository
        Document savedDocument = new Document();
        savedDocument.setFileName(fileName);
        savedDocument.setFileType(contentType);
        savedDocument.setAuthor(author);
        savedDocument.setUploadDate(LocalDate.now());
        savedDocument.setContent(content);

        // Mock repository save method
        Mockito.when(documentRepository.save(any(Document.class))).thenReturn(savedDocument);

        // Act
        CompletableFuture<Document> result = documentService.ingestDocument(file, author);

        // Assert
        result.thenAccept(document -> {
            assertEquals(fileName, document.getFileName());
            assertEquals(contentType, document.getFileType());
            assertEquals(author, document.getAuthor());
            assertEquals(LocalDate.now(), document.getUploadDate());
        });
    }
}
