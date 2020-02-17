public enum Title {
    BREAK("Break"),
    FOCUS("Focus");

    private String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
