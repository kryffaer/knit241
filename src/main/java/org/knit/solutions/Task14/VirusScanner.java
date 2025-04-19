package org.knit.solutions.Task14;

public class VirusScanner implements FileSystemVisitor {
    @Override
    public void visit(File file) {
        System.out.println("Проверка файла " + file.getName() + " на вирусы...");
    }

    @Override
    public void visit(Folder folder) {
        System.out.println("Папка " + folder.getName() + " не проверяется на вирусы.");
    }

    @Override
    public void visit(Link link) {
        System.out.println("Ссылка " + link.getName() + " не проверяется на вирусы.");
    }
}
