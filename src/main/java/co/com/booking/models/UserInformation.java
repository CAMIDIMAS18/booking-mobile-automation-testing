package co.com.booking.models;


public enum UserInformation {
    CAMILA("camila@test.com", "cra 16 a este 45", "111999", "Bogota", "Colombia", "3223864362"),
    DANIEL("josehurtado@mail.com", "", "", "", "Colombia", "930731660");

    private final String email;
    private final String address;
    private final String postalCode;
    private final String city;
    private final String country;
    private final String phone;


    UserInformation(String email, String address, String postalCode, String city, String country, String phone) {
        this.email = email;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }
}
