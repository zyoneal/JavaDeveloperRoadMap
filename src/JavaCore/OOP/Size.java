public enum Size {

    VERY_SMALL("XS"),

    SMALL("S"),

    AVERAGE("M"),

    BIG("L"),

    VERY_BIG("XL"),

    UNDEFINED("UNDEFINED");

    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}
