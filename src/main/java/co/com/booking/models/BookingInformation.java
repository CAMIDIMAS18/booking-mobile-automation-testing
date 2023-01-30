package co.com.booking.models;


public enum BookingInformation {
    CAMILA("Camila", "Dimas", "Cusco", "14 February 2023", "28 February 2023", "5 years old"),
    DANIEL("Jose", "Hurtado", "Cusco", "14 February 2023", "28 February 2023", "5 years old");

    private final String firstName;
    private final String lastName;
    private final String cityDestination;
    private final String dateStart;
    private final String dateEnd;
    private final String ageChildren;


    BookingInformation(String firstName, String lastName, String cityDestination, String dateStart, String dateEnd, String ageChildren) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityDestination = cityDestination;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ageChildren = ageChildren;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCityDestination() {
        return cityDestination;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getAgeChildren() {
        return ageChildren;
    }
}
