package org.knit.solutions.Task14;

// Интерфейс для всех файловых объектов
public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
