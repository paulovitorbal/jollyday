package de.focus_shift.jollyday.tests.country;

import de.focus_shift.jollyday.core.Holiday;
import de.focus_shift.jollyday.core.HolidayManager;
import de.focus_shift.jollyday.core.ManagerParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Set;

import static de.focus_shift.jollyday.core.HolidayCalendar.JERSEY;
import static de.focus_shift.jollyday.core.HolidayType.OFFICIAL_HOLIDAY;
import static de.focus_shift.jollyday.core.ManagerParameters.create;
import static java.time.Month.MAY;
import static org.assertj.core.api.Assertions.assertThat;

class HolidayJETest extends AbstractCountryTestBase {

  private static final String ISO_CODE = "je";

  @Test
  void ensuresThatKingsCoronationForKingCharlesIIIIn2023() {
    final HolidayManager holidayManager = HolidayManager.getInstance(create(JERSEY));

    final Set<Holiday> holidays2022 = holidayManager.getHolidays(2022);
    assertThat(holidays2022)
      .isNotEmpty()
      .extracting(Holiday::getPropertiesKey)
      .doesNotContain("KINGS_CORONATION");

    final Set<Holiday> holidays2023 = holidayManager.getHolidays(2023);
    assertThat(holidays2023)
      .contains(new Holiday(LocalDate.of(2023, MAY, 8), "KINGS_CORONATION", OFFICIAL_HOLIDAY));

    final Set<Holiday> holidays2024 = holidayManager.getHolidays(2024);
    assertThat(holidays2024)
      .isNotEmpty()
      .extracting(Holiday::getPropertiesKey)
      .doesNotContain("KINGS_CORONATION");
  }

  @ParameterizedTest
  @ValueSource(ints = {2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024})
  void testManagerJEStructure(final int year) {
    validateCalendarData(ISO_CODE, year, true);
  }

  @Test
  void testManagerJEChristmasMovingDaysWhenChristmasOnSunday() {
    doChristmasContainmentTest(2011, 26, 27);
  }

  @Test
  void testManagerJEChristmasMovingDaysWhenChristmasOnSaturday() {
    doChristmasContainmentTest(2010, 27, 28);
  }

  @Test
  void testManagerJEChristmasMovingDaysWhenChristmasOnFriday() {
    doChristmasContainmentTest(2009, 25, 28);
  }

  private void doChristmasContainmentTest(int year, int dayOfChristmas, int dayOfBoxingday) {
    final LocalDate christmas = LocalDate.of(year, 12, dayOfChristmas);
    final LocalDate boxingday = LocalDate.of(year, 12, dayOfBoxingday);
    final HolidayManager holidayManager = HolidayManager.getInstance(ManagerParameters.create(JERSEY));
    final Set<Holiday> holidays = holidayManager.getHolidays(year);
    assertThat(contains(christmas, holidays)).isTrue();
    assertThat(contains(boxingday, holidays)).isTrue();
  }

  private boolean contains(LocalDate localDate, Set<Holiday> holidays) {
    for (Holiday h : holidays) {
      if (localDate.equals(h.getDate())) {
        return true;
      }
    }
    return false;
  }
}
