package de.focus_shift.jollyday.tests.country;

import de.focus_shift.jollyday.core.Holiday;
import de.focus_shift.jollyday.core.HolidayManager;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.time.api.constraints.YearRange;

import java.time.LocalDate;
import java.time.Year;
import java.util.Set;

import static de.focus_shift.jollyday.core.HolidayCalendar.CZECH_REPUBLIC;
import static de.focus_shift.jollyday.core.HolidayType.PUBLIC_HOLIDAY;
import static de.focus_shift.jollyday.core.ManagerParameters.create;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;
import static org.assertj.core.api.Assertions.assertThat;

class HolidayCZTest extends AbstractCountryTestBase {

  @Property
  void ensuresThatNewYearConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), JANUARY, 1), "NEW_YEAR", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatLabourDayConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), MAY, 1), "LABOUR_DAY", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatLiberationConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), MAY, 8), "LIBERATION", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatCyrusMethodiusConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), JULY, 5), "CYRUS_METHODIUS", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatHusConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), JULY, 6), "HUS", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatWencelasConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), SEPTEMBER, 28), "WENCELAS", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatIndependenceDayConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), OCTOBER, 28), "INDEPENDENCE_DAY", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatFreedomDemocracyConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), NOVEMBER, 17), "FREEDOM_DEMOCRACY", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatChristmasEveConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), DECEMBER, 24), "CHRISTMAS_EVE", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatChristmasConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), DECEMBER, 25), "CHRISTMAS", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatStephensConfigured(@ForAll @YearRange Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .contains(new Holiday(LocalDate.of(year.getValue(), DECEMBER, 26), "STEPHENS", PUBLIC_HOLIDAY));
  }

  @Property
  void ensuresThatGoodFridayIsConfiguredSince2016(@ForAll @YearRange(min = 2016) Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .extracting(Holiday::getPropertiesKey)
      .contains("christian.GOOD_FRIDAY");
  }

  @Property
  void ensuresThatGoodFridayIsNotConfiguredUntil2015(@ForAll @YearRange(max = 2015) Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .extracting(Holiday::getPropertiesKey)
      .doesNotContain("christian.GOOD_FRIDAY");
  }

  @Property
  void ensuresThatEasterMondaySince1942(@ForAll @YearRange(min = 1942) Year year) {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(CZECH_REPUBLIC));
    final Set<Holiday> holidays = holidayManager.getHolidays(year.getValue());
    assertThat(holidays)
      .isNotEmpty()
      .extracting(Holiday::getPropertiesKey)
      .contains("christian.EASTER_MONDAY");
  }
}
