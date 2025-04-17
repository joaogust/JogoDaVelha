package core;

public enum Symbol {
    O('X'),
    X('X'),
    NONE(' ');

    private final char charSymbol;

    Symbol(char charSymbol) {
        this.charSymbol = charSymbol;
    }

    @Override
    public String toString() {
        return String.valueOf(charSymbol);
    }
}
