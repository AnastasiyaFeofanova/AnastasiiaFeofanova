package hw8.entities;

public enum HeaderMenuNavigation {

    // TODO Java code convention is crying :`(
    home("HOME"),
    contactForme("CONTACT FORM"),
    service("SERVICE"),
    metalsAndColors("METALS & COLORS");

    public String value;
    HeaderMenuNavigation(String value) { this.value = value; }
}
