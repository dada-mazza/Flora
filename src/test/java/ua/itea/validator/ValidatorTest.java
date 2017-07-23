package ua.itea.validator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    public void testYear() {
        Integer currentYear = new DateTime().getYear();

        for (int i = 0; i < currentYear - 100; i++) {
            validator.setYearOfBirth(String.valueOf(i));
            assertFalse("year: " + i, validator.getYearOfBirthErrorMessages().isEmpty());
        }
        for (int i = currentYear - 100; i < currentYear - 3; i++) {
            validator.setYearOfBirth(String.valueOf(i));
            assertTrue("year: " + i, validator.getYearOfBirthErrorMessages().isEmpty());
        }
        for (int i = currentYear - 3; i < currentYear; i++) {
            validator.setYearOfBirth(String.valueOf(i));
            assertFalse("year: " + i, validator.getYearOfBirthErrorMessages().isEmpty());
        }

        validator.setYearOfBirth("");
        assertFalse("empty year", validator.getYearOfBirthErrorMessages().isEmpty());

        validator.setYearOfBirth("year");
        assertFalse("string year", validator.getYearOfBirthErrorMessages().isEmpty());

    }

    @Test
    public void testMonth() {

        for (int i = 0; i < 12 - 100; i++) {
            validator.setMonthOfBirth(String.valueOf(i));
            assertFalse("month: " + i, validator.getMonthOfBirthErrorMessages().isEmpty());
        }
        for (int i = 1; i <= 12; i++) {
            validator.setMonthOfBirth(String.valueOf(i));
            assertTrue("month: " + i, validator.getMonthOfBirthErrorMessages().isEmpty());
        }
        for (int i = 13; i < 20; i++) {
            validator.setMonthOfBirth(String.valueOf(i));
            assertFalse("month: " + i, validator.getMonthOfBirthErrorMessages().isEmpty());
        }

        validator.setMonthOfBirth("");
        assertFalse("empty month", validator.getMonthOfBirthErrorMessages().isEmpty());

        validator.setMonthOfBirth("month");
        assertFalse("string month", validator.getMonthOfBirthErrorMessages().isEmpty());
    }

    @Test
    public void testDay() {

        DateTime startDate = new DateTime(new DateTime().getYear() - 100, 1, 1, 0, 0);
        DateTime endDate = new DateTime(new DateTime().getYear() - 3, 1, 1, 0, 0);
        DateTime currentDate = startDate;
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MMMM-dd");

        while (currentDate.isAfter(endDate.getMillis())) {
            String year = String.valueOf(currentDate.getYear());
            String month = String.valueOf(currentDate.getMonthOfYear());
            String day = String.valueOf(currentDate.getDayOfMonth());

            validator.setYearOfBirth(year);
            validator.setMonthOfBirth(month);
            validator.setDayOfBirth(day);

            assertTrue("day: " + fmt.print(currentDate), validator.getMonthOfBirthErrorMessages().isEmpty());

            if (day == "1") {
                validator.setDayOfBirth("0");
                assertFalse("day: " + year + "-" + month + "-(0)", validator.getMonthOfBirthErrorMessages().isEmpty());
                validator.setDayOfBirth("-1");
                assertFalse("day: " + year + "-" + month + "-(-1)", validator.getMonthOfBirthErrorMessages().isEmpty());
            }

            if (day == String.valueOf(currentDate.dayOfMonth().getMaximumValue())) {
                String day1 = String.valueOf(currentDate.dayOfMonth().getMaximumValue() + 1);
                validator.setDayOfBirth(String.valueOf(currentDate.dayOfMonth().getMaximumValue() + 1));
                assertFalse("day: " + year + "-" + month + "-" + day1, validator.getMonthOfBirthErrorMessages().isEmpty());

                String day2 = String.valueOf(currentDate.dayOfMonth().getMaximumValue() + 2);
                validator.setDayOfBirth(String.valueOf(currentDate.dayOfMonth().getMaximumValue() + 2));
                assertFalse("day: " + year + "-" + month + "-" + day2, validator.getMonthOfBirthErrorMessages().isEmpty());
            }
        }
    }

    @Test
    public void testDayOfBirth() {

        testDayOfBirth(null, null, null);
        testDayOfBirth("", "", "");
        testDayOfBirth("", "", "10");
        testDayOfBirth("year", "month", "10");
        testDayOfBirth("year", "month", "day");
        testDayOfBirth("", "", "");

    }

    private void testDayOfBirth(String year, String month, String day) {

        validator.setYearOfBirth(year);
        validator.setMonthOfBirth(month);
        validator.setDayOfBirth(day);

        assertFalse("DayOfBirth:" + year + "-" + month + "-" + day, validator.getMonthOfBirthErrorMessages().isEmpty());

    }

    @Test
    public void testGender() {

        validator.setGender("");
        assertFalse("Gender empty", validator.getGenderErrorMessages().isEmpty());

        validator.setGender("Female or Male");
        assertFalse("Gender not empty", validator.getGenderErrorMessages().isEmpty());

        validator.setGender("Male");
        assertTrue("Gender Male", validator.getGenderErrorMessages().isEmpty());

        validator.setGender("Female");
        assertTrue("Gender Female", validator.getGenderErrorMessages().isEmpty());


    }
}

