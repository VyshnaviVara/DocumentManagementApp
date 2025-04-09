package com.document.documentmanagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    private String author;
    private LocalDate uploadDate;

    @Lob
    private byte[] content;

    public Document() {
    }

    public Document(String author, byte[] content, String fileName, String fileType, Long id, LocalDate uploadDate) {
        this.author = author;
        this.content = content;
        this.fileName = fileName;
        this.fileType = fileType;
        this.id = id;
        this.uploadDate = uploadDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Document{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", uploadDate=" + uploadDate +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}


