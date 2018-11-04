package co.org.osso.api;

enum CalculatorCommands {
    SUM, SUB, MUL, DIV;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
