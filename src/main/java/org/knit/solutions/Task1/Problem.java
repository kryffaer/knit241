package org.knit.solutions.Task1;

public class Problem{
    private final String text;
    private final int index;

    public Problem(String text, int index){
        this.text = text;
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public int getIndex() {
        return index;
    }
}
