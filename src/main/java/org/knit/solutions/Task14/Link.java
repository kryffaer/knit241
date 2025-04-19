package org.knit.solutions.Task14;

public class Link implements FileSystemElement {
    private String name;
    private String target;

    public Link(String name, String target) {
        this.name = name;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
