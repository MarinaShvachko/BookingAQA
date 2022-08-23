package utility;

public class Constants {
    public class URL {
        public static final String MAIN_PAGE_URL = "http://booking.com";
    }

    public class EXPECTED_HINTS {
        public static final int EXPECTED_DESTINATION_HINTS_NUMBER = 5;
    }

    //TODO: add separate class for errors
    public class ERROR_TXT {
        public static final String WRONG_NUMBER_OF_HINTS = "Wrong number of hints in drop down list after adding values in destination field";
        public static final String NOT_RIGHT_PAGE_TITLE = "Wrong page is opened";
        public static final String NOT_RIGHT_PAGE_HEADING = "Wrong page heading";
    }

    public class DataForDestinationField {
        public static final String CITY_NAME_FOR_CHECKING_FILTRATION = "Baly";
        public static final int LENGTH_LIMITATION_FOR_CHECKING_FILTRATION = 3;
    }

    public class TravelData {
        public static final int DAYS_UNTIL_CHECKIN = 5;
        public static final int DAYS_UNTIL_CHECKOUT = 10;
        public static final String DESTINATION_LISBON = "Lisbon";
    }

    public class PAGE_TITLES {
        public static final String BASIC_TITLE_SEARCH_RESULT_PAGE = "Booking.com : Hotels in";
    }
}
