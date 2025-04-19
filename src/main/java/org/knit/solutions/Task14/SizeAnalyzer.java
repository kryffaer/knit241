package org.knit.solutions.Task14;

public class SizeAnalyzer implements FileSystemVisitor {
    private int totalSize = 0;

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Folder folder) {
        // Папки не вносят вклад в размер
    }

    @Override
    public void visit(Link link) {
        // Ссылки не учитываются в размере
    }
}