package bennyhils.brackets.brackets;

public enum BracketsForCheckTypes {

    ROUND('(', ')'),
    SQUARE('[', ']'),
    CURLY('{', '}'),
    ANGLE('<', '>');

    private final char start;
    private final char end;

    BracketsForCheckTypes(char start, char end) {
        this.start = start;
        this.end = end;
    }

    public char getStart() {
        return start;
    }

    public char getEnd() {
        return end;
    }
}
