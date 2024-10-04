package md.zoom.model.enums;

public enum AccountStatusEnum {
    ENABLE("Enable"),
    DISABLE("Disable");

    private final String value;

    AccountStatusEnum(String status) {
        this.value = status;
    }
    public String getValue() {
        return value;
    }
    public static AccountStatusEnum valueOfLabel(String label) {
        for (AccountStatusEnum e : values()) {
            if (e.getValue().equals(label)) {
                return e;
            }
        }
        return null;
    }
}
