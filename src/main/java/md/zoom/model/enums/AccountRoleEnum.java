package md.zoom.model.enums;

public enum AccountRoleEnum {
    ADMIN("Admin"),
    USER("User"),
    NOT_VERIFIED("Not verified");

    private final String value;

    AccountRoleEnum(String status) {
        this.value = status;
    }
    public String getValue() {
        return value;
    }

}
