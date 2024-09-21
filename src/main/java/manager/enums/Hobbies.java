package manager.enums;

public enum Hobbies {

    SPORTS("lable[for=hobbies-checkbox-1]"),  //css selector
    READING("lable[for=hobbies-checkbox-2]"),
    MUSIC("lable[for=hobbies-checkbox-3]");

    private final String locator;

    Hobbies(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
