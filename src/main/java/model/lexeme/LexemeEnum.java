package model.lexeme;

public enum LexemeEnum {

    PLUS("+") {
        @Override
        public PlusLexeme create() {
            return new PlusLexeme();
        }
    },
    MINUS("-") {
        @Override
        public MinusLexeme create() {
            return new MinusLexeme();
        }
    },
    DOT(".") {
        @Override
        public DotLexeme create() {
            return new DotLexeme();
        }
    },
    CLOSE_BRACKET("]") {
        @Override
        public CloseBracketLexeme create() {
            return new CloseBracketLexeme();
        }
    },
    GREATER_THAN(">") {
        @Override
        public GreaterThanLexeme create() {
            return new GreaterThanLexeme();
        }
    },
    LESS_THAN("<") {
        @Override
        public LessThanLexeme create() {
            return new LessThanLexeme();
        }
    },
    OPEN_BRACKET("[") {
        @Override
        public OpenBracketLexeme create() {
            return new OpenBracketLexeme();
        }

    };
    private String command;

    LexemeEnum(String c) {
        this.command = c;
    }

    public abstract Lexeme create();

    public static LexemeEnum fromString(String text) {
        for (LexemeEnum b : LexemeEnum.values()) {
            if (b.command.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}

