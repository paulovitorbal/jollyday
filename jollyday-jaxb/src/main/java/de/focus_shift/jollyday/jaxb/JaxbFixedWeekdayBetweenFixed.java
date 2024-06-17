package de.focus_shift.jollyday.jaxb;

import de.focus_shift.jollyday.core.HolidayType;
import de.focus_shift.jollyday.core.spi.Fixed;
import de.focus_shift.jollyday.core.spi.FixedWeekdayBetweenFixed;
import de.focus_shift.jollyday.core.spi.YearCycle;

import java.time.DayOfWeek;
import java.time.Year;


public class JaxbFixedWeekdayBetweenFixed implements FixedWeekdayBetweenFixed {

  private final de.focus_shift.jollyday.jaxb.mapping.FixedWeekdayBetweenFixed fixedWeekdayBetweenFixed;

  public JaxbFixedWeekdayBetweenFixed(de.focus_shift.jollyday.jaxb.mapping.FixedWeekdayBetweenFixed fixedWeekdayInMonth) {
    this.fixedWeekdayBetweenFixed = fixedWeekdayInMonth;
  }

  @Override
  public Fixed from() {
    return new JaxbFixed(fixedWeekdayBetweenFixed.getFrom());
  }

  @Override
  public Fixed to() {
    return new JaxbFixed(fixedWeekdayBetweenFixed.getTo());
  }

  @Override
  public DayOfWeek weekday() {
    return DayOfWeek.valueOf(fixedWeekdayBetweenFixed.getWeekday().name());
  }

  @Override
  public String descriptionPropertiesKey() {
    return fixedWeekdayBetweenFixed.getDescriptionPropertiesKey();
  }

  @Override
  public HolidayType officiality() {
    return fixedWeekdayBetweenFixed.getLocalizedType() == null
      ? HolidayType.PUBLIC_HOLIDAY
      : HolidayType.valueOf(fixedWeekdayBetweenFixed.getLocalizedType().name());
  }

  @Override
  public Year validFrom() {
    return fixedWeekdayBetweenFixed.getValidFrom() == null
      ? null
      : Year.of(fixedWeekdayBetweenFixed.getValidFrom());
  }

  @Override
  public Year validTo() {
    return fixedWeekdayBetweenFixed.getValidTo() == null
      ? null
      : Year.of(fixedWeekdayBetweenFixed.getValidTo());
  }

  @Override
  public YearCycle cycle() {
    return fixedWeekdayBetweenFixed.getEvery() == null
      ? YearCycle.EVERY_YEAR
      : YearCycle.valueOf(fixedWeekdayBetweenFixed.getEvery().name());
  }
}
