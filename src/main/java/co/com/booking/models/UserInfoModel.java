package co.com.booking.models;

import java.util.HashMap;
import java.util.Map;

import static co.com.booking.utils.data.Constants.*;

public class UserInfoModel {

    private static final Map<String, String> infoUser = new HashMap<>();

    private UserInfoModel() {
    }

    public static Map<String, String> userInformation() {
        infoUser.put(CITY_DESTINATION, BookingInformation.CAMILA.getCityDestination());
        infoUser.put(FIRST_NAME, BookingInformation.CAMILA.getFirstName());
        infoUser.put(LAST_NAME, BookingInformation.CAMILA.getLastName());
        infoUser.put(START_DATE, BookingInformation.CAMILA.getDateStart());
        infoUser.put(END_DATE, BookingInformation.CAMILA.getDateEnd());
        infoUser.put(AGE_CHILDREN, BookingInformation.CAMILA.getAgeChildren());

        infoUser.put(EMAIL, UserInformation.CAMILA.getEmail());
        infoUser.put(ADDRESS, UserInformation.CAMILA.getAddress());
        infoUser.put(POSTAL_CODE, UserInformation.CAMILA.getPostalCode());
        infoUser.put(CITY, UserInformation.CAMILA.getCity());
        infoUser.put(COUNTRY, UserInformation.CAMILA.getCountry());
        infoUser.put(PHONE, UserInformation.CAMILA.getPhone());
        return infoUser;
    }
}
