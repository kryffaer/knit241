package org.knit.solutions.Task14;

public class Folder implements FileSystemElement {
    private String name;
    private FileSystemElement[] elements;

    public Folder(String name, FileSystemElement... elements) {
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public FileSystemElement[] getElements() {
        return elements;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}
