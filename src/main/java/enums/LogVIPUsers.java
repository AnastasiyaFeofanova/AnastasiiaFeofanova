package enums;

public enum LogVIPUsers {
    VIP_ON("Vip: condition changed to true");

    public String parameter;

    LogVIPUsers(String parameter) {
        this.parameter = parameter;
    }
}
