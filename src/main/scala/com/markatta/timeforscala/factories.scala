/*
 * Copyright 2015 Johan Andrén
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.markatta.timeforscala

import java.util.Locale

import scala.concurrent.duration.FiniteDuration

// factory methods for the most common use cases to be able to get away with just one import
// in most cases

object FormatStyle {
  val Full = java.time.format.FormatStyle.FULL
  val Long = java.time.format.FormatStyle.LONG
  val Medium = java.time.format.FormatStyle.MEDIUM
  val Short = java.time.format.FormatStyle.SHORT
}

object Month {

  val January = java.time.Month.JANUARY
  val February = java.time.Month.FEBRUARY
  val March = java.time.Month.MARCH
  val May = java.time.Month.MAY
  val April = java.time.Month.APRIL
  val June = java.time.Month.JUNE
  val July = java.time.Month.JULY
  val August = java.time.Month.AUGUST
  val September = java.time.Month.SEPTEMBER
  val October = java.time.Month.OCTOBER
  val November = java.time.Month.NOVEMBER
  val December = java.time.Month.DECEMBER

  def apply(month: Int): Month = java.time.Month.of(month)

  def apply(accessor: TemporalAccessor): Month =
    java.time.Month.from(accessor)

  def unapply(month: Month): Option[Int] = Some(month.getValue)
}

object Year {

  final val MinValue = java.time.Year.MIN_VALUE

  final val MaxValue = java.time.Year.MAX_VALUE

  def apply(): Year = java.time.Year.now()

  def apply(clock: Clock): Year = java.time.Year.now(clock)

  def apply(zoneId: ZoneId): Year = java.time.Year.now(zoneId)

  def apply(year: Int): Year = java.time.Year.of(year)

  def apply(accessor: TemporalAccessor): Year =
    java.time.Year.from(accessor)

  def apply(iso8601Year: String): Year =
    java.time.Year.parse(iso8601Year)

  def apply(dateTimeString: String, formatter: DateTimeFormatter): Year =
    java.time.Year.parse(dateTimeString, formatter)

  def unapply(year: Year): Option[Int] = Some(year.getValue)
}

object DayOfWeek {
  def apply(dayOfWeek: Int): DayOfWeek = java.time.DayOfWeek.of(dayOfWeek)

  def apply(accessor: TemporalAccessor): DayOfWeek =
    java.time.DayOfWeek.from(accessor)

  def unapply(dayOfWeek: DayOfWeek): Option[Int] = Some(dayOfWeek.getValue)
}

object Instant {

  final val Epoch: Instant = java.time.Instant.EPOCH

  final val Min: Instant = java.time.Instant.MIN

  final val Max: Instant = java.time.Instant.MAX

  def apply(): Instant = java.time.Instant.now()

  def apply(clock: Clock): Instant = java.time.Instant.now(clock)

  def apply(text: String): Instant = java.time.Instant.parse(text)

  def apply(accessor: TemporalAccessor): Instant =
    java.time.Instant.from(accessor)
}

object Duration {

  final val Zero = java.time.Duration.ZERO

  def apply(seconds: Long, nanos: Long = 0): Duration = java.time.Duration.ofSeconds(seconds, nanos)

  def apply(duration: FiniteDuration): Duration = java.time.Duration.ofSeconds(duration.toSeconds)

  def apply(amount: Long, unit: TemporalUnit): Duration = java.time.Duration.of(amount, unit)

  def apply(accessor: TemporalAmount): Duration = java.time.Duration.from(accessor)

  /** @see java.time.Duration.parse(CharSequence) */
  def apply(duration: String): Duration = java.time.Duration.parse(duration)

  def between(startInclusive: Temporal, endExclusive: Temporal): Duration =
    java.time.Duration.between(startInclusive, endExclusive)

  def unapply(duration: Duration): Option[(Long, Int)] =
    Some((duration.getSeconds, duration.getNano))

}

object Hours {
  def apply(n: Long): Duration = java.time.Duration.ofHours(n)
}

object Minutes {
  def apply(n: Long): Duration = java.time.Duration.ofMinutes(n)
}

object Seconds {
  def apply(n: Long): Duration = java.time.Duration.ofSeconds(n)
}

object Millis {
  def apply(n: Long): Duration = java.time.Duration.ofMillis(n)
}

object Nanos {
  def apply(n: Long): Duration = java.time.Duration.ofNanos(n)
}


object Period extends {

  final val Zero = java.time.Period.ZERO

  def apply(years: Int, months: Int, days: Int): Period =
    java.time.Period.of(years, months, days)

  def apply(amount: TemporalAmount): Period =
    java.time.Period.from(amount)

  def between(startInclusive: LocalDate, endExclusive: LocalDate): Period =
    java.time.Period.between(startInclusive, endExclusive)

  def unapply(period: Period): Option[(Int, Int, Int)] =
    Some((period.getYears, period.getMonths, period.getDays))
}

object Days {
  def apply(n: Int): Period = java.time.Period.ofDays(n)
}

object Months {
  def apply(n: Int): Period = java.time.Period.ofMonths(n)
}

object Weeks {
  def apply(n: Int): Period = java.time.Period.ofWeeks(n)
}

object Years {
  def apply(n: Int): Period = java.time.Period.ofYears(n)
}

object LocalTime {

  final val Min: LocalTime = java.time.LocalTime.MIN

  final val Max: LocalTime = java.time.LocalTime.MAX

  final val Midnight: LocalTime = java.time.LocalTime.MIDNIGHT

  final val Noon: LocalTime = java.time.LocalTime.NOON

  def apply(hour: Int, minute: Int, second: Int = 0, nano: Int = 0): LocalTime =
    java.time.LocalTime.of(hour, minute, second, nano)

  def apply(): LocalTime =
    java.time.LocalTime.now()

  def apply(clock: Clock): LocalTime =
    java.time.LocalTime.now(clock)

  def apply(zone: ZoneId): LocalTime =
    java.time.LocalTime.now(zone)

  def unapply(lt: LocalTime): Option[(Int, Int, Int, Int)] =
    Some((lt.getHour, lt.getMinute, lt.getSecond, lt.getNano))

}


object LocalDate {

  final val Min: LocalDate = java.time.LocalDate.MIN

  final val Max: LocalDate = java.time.LocalDate.MAX

  def apply(year: Int, month: Month, dayOfMonth: Int): LocalDate =
    java.time.LocalDate.of(year, month, dayOfMonth)

  def apply(year: Int, month: Int, dayOfMonth: Int): LocalDate =
    java.time.LocalDate.of(year, month, dayOfMonth)

  def apply(accessor: TemporalAccessor): LocalDate =
    java.time.LocalDate.from(accessor)

  def unapply(l: LocalDate): Option[(Int, Month, Int)] = Some((l.year, l.month, l.dayOfMonth))

  /**
   * @param date The date part of iso8660, for example "2007-12-03"
   * @see java.time.LocalDate.parse(String)
   */
  def apply(date: String): LocalDate =
    java.time.LocalDate.parse(date)

  def apply(date: String, formatter: DateTimeFormatter): LocalDate =
    java.time.LocalDate.parse(date, formatter)

  /** @return now according to the system clock */
  def apply(): LocalDate = java.time.LocalDate.now()
  /** @return now according to the given clock */
  def apply(clock: Clock): LocalDate = java.time.LocalDate.now(clock)
  /** @return now in the given time zone */
  def apply(zone: ZoneId): LocalDate = java.time.LocalDate.now(zone)

}

object LocalDateTime {

  final val Min: LocalDateTime = java.time.LocalDateTime.MIN

  final val Max: LocalDateTime = java.time.LocalDateTime.MAX

  def apply(date: LocalDate, time: LocalTime): LocalDateTime =
    java.time.LocalDateTime.of(date, time)

  def apply(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int): LocalDateTime =
    java.time.LocalDateTime.of(year, month, dayOfMonth, hour, minute, second)

  def apply(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int): LocalDateTime =
    java.time.LocalDateTime.of(year, month, dayOfMonth, hour, minute, second)

  def apply(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int): LocalDateTime =
    java.time.LocalDateTime.of(year, month, dayOfMonth, hour, minute)

  def apply(accessor: TemporalAccessor): LocalDateTime =
    java.time.LocalDateTime.from(accessor)

  /**
   * @param iso8601DateTime A date on the format '2007-12-03T10:15:30'
   */
  def apply(iso8601DateTime: String): LocalDateTime =
    java.time.LocalDateTime.parse(iso8601DateTime)

  def apply(dateTimeString: String, formatter: DateTimeFormatter): LocalDateTime =
    java.time.LocalDateTime.parse(dateTimeString, formatter)

  /** @return now according to the system clock */
  def apply(): LocalDateTime = java.time.LocalDateTime.now()
  /** @return now according to the given clock */
  def apply(clock: Clock): LocalDateTime = java.time.LocalDateTime.now(clock)
  /** @return now in the given time zone */
  def apply(zone: ZoneId): LocalDateTime = java.time.LocalDateTime.now(zone)

  def unapply(dt: LocalDateTime): Option[(LocalDate, LocalTime)] =
    Some((dt.toLocalDate, dt.toLocalTime))

}

object ZonedDateTime {

  /** @see java.time.ZonedDateTime.of(LocalDateTime, ZoneId) */
  def apply(dateTime: LocalDateTime, zone: ZoneId): ZonedDateTime =
    java.time.ZonedDateTime.of(dateTime, zone)

  /** @see java.time.ZonedDateTime.of(LocalDate, LocalTime, ZoneId) */
  def apply(date: LocalDate, time: LocalTime, zone: ZoneId): ZonedDateTime =
    java.time.ZonedDateTime.of(date, time, zone)

  /** @see java.time.ZonedDateTime.from(TemporalAccessor) */
  def apply(accessor: TemporalAccessor): ZonedDateTime =
    java.time.ZonedDateTime.from(accessor)

  def unapply(z: ZonedDateTime): Option[(LocalDateTime, ZoneId)] =
    Some((z.toLocalDateTime, z.getZone))

  /**
   * @param iso8601DateTime A date on the format '2007-12-03T10:15:30+01:00[Europe/Paris]', see
   *                        [[java.time.ZonedDateTime.parse()]]
   * @see java.time.ZonedDateTime.parse(String)
   */
  def apply(iso8601DateTime: String): ZonedDateTime =
    java.time.ZonedDateTime.parse(iso8601DateTime)

  def apply(dateTimeString: String, formatter: DateTimeFormatter): ZonedDateTime =
    java.time.ZonedDateTime.parse(dateTimeString, formatter)

  /** @return now according to the system clock */
  def apply(): ZonedDateTime = java.time.ZonedDateTime.now()
  /** @return now according to the given clock */
  def apply(clock: Clock): ZonedDateTime = java.time.ZonedDateTime.now(clock)
  /** @return now in the given time zone */
  def apply(zone: ZoneId): ZonedDateTime = java.time.ZonedDateTime.now(zone)

  def apply(instant: Instant, zone: ZoneId): ZonedDateTime = java.time.ZonedDateTime.ofInstant(instant, zone)

  def apply(localDateTime: LocalDateTime, offset: ZoneOffset, zone: ZoneId): ZonedDateTime =
    java.time.ZonedDateTime.ofInstant(localDateTime, offset, zone)

}

object YearMonth {

  /** @see java.time.YearMonth.of(Int, Int) */
  def apply(year: Int, month: Int): YearMonth =
    java.time.YearMonth.of(year, month)

  /** @see java.time.YearMonth.of(Int, Month) */
  def apply(year: Int, month: Month): YearMonth =
    java.time.YearMonth.of(year, month)

  /** @see java.time.YearMonth.from(TemporalAccessor) */
  def apply(temporal: TemporalAccessor): YearMonth =
    java.time.YearMonth.from(temporal)

  def unapply(ym: YearMonth): Option[(Int, Month)] =
    Some((ym.getYear, ym.getMonth))

  /**
   * @param yearMonth A year and month in the format '2015-01'
   * @see java.time.YearMonth.parse(String)
   */
  def apply(yearMonth: String): YearMonth = java.time.YearMonth.parse(yearMonth)

  def apply(yearMonth: String, formatter: DateTimeFormatter): YearMonth = java.time.YearMonth.parse(yearMonth, formatter)

  /** @return now according to the system clock */
  def apply(): YearMonth = java.time.YearMonth.now()
  /** @return now according to the given clock */
  def apply(clock: Clock): YearMonth = java.time.YearMonth.now(clock)
  /** @return now in the given time zone */
  def apply(zone: ZoneId): YearMonth = java.time.YearMonth.now(zone)

}

object DateTimeFormatter {
  final val IsoLocalDate: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE

  final val IsoOffsetDate: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_OFFSET_DATE

  final val IsoDate: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_DATE

  final val IsoLocalTime: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_LOCAL_TIME

  final val IsoOffsetTime: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_OFFSET_TIME

  final val IsoTime: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_TIME

  final val IsoLocalDateTime: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME

  final val IsoOffsetDateTime: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME

  final val IsoZonedDateTime: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME

  final val IsoDateTime: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_DATE_TIME

  final val IsoOrdinalDate: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_ORDINAL_DATE

  final val IsoWeekDate: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_WEEK_DATE

  final val IsoInstant: DateTimeFormatter = java.time.format.DateTimeFormatter.ISO_INSTANT

  final val BasicIsoDate: DateTimeFormatter = java.time.format.DateTimeFormatter.BASIC_ISO_DATE

  final val Rfc1123DateTime: DateTimeFormatter = java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME

  def apply(pattern: String): DateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(pattern)

  def apply(dateTimeStyle: FormatStyle): DateTimeFormatter =
    java.time.format.DateTimeFormatter.ofLocalizedDateTime(dateTimeStyle)

  def apply(dateStyle: FormatStyle, timeStyle: FormatStyle): DateTimeFormatter =
    java.time.format.DateTimeFormatter.ofLocalizedDateTime(dateStyle)

  def apply(dateStyle: Option[FormatStyle], timeStyle: Option[FormatStyle]): Option[DateTimeFormatter] = {
    (dateStyle, timeStyle) match {
      case (Some(dateStyleV), None) => Some(java.time.format.DateTimeFormatter.ofLocalizedDate(dateStyleV))
      case (None, Some(timeStyleV)) => Some(java.time.format.DateTimeFormatter.ofLocalizedTime(timeStyleV))
      case (Some(dateStyleV), Some(timeStyleV)) => Some(apply(dateStyleV, timeStyleV))
      case _ => None
    }
  }

  def apply(pattern: String, locale: Locale): DateTimeFormatter =
    java.time.format.DateTimeFormatter.ofPattern(pattern, locale)

}

object ZoneId {

  import collection.JavaConverters._

  final val ShortIds: Map[String, String] = java.time.ZoneId.SHORT_IDS.asScala.toMap

  final val `GMT` = "GMT"
  final val `UTC` = "UTC"
  final val `UT` = "UT"
  final val `Z` = "Z"

  final val GmtZoneId: ZoneId = java.time.ZoneId.of(GMT)
  final val UtcZoneId: ZoneId = java.time.ZoneId.of(UTC)
  final val UtZoneId: ZoneId = java.time.ZoneId.of(UT)
  final val ZZoneId: ZoneId = java.time.ZoneId.of(Z)


  def apply(zoneId: String): ZoneId = java.time.ZoneId.of(zoneId)

  def apply(zoneId: String, aliasMap: Map[String, String]): ZoneId = java.time.ZoneId.of(zoneId, aliasMap.asJava)

  def apply(prefix: String, offset: ZoneOffset): ZoneId = java.time.ZoneId.ofOffset(prefix, offset)

  def apply(temporal: TemporalAccessor): ZoneId = java.time.ZoneId.from(temporal)


}

object ZoneOffset {

  final val UTC: ZoneOffset = java.time.ZoneOffset.UTC

  final val Min: ZoneOffset = java.time.ZoneOffset.MIN

  final val Max: ZoneOffset = java.time.ZoneOffset.MAX

  def apply(offsetId: String): ZoneOffset = java.time.ZoneOffset.of(offsetId)

  def apply(hours: Int): ZoneOffset = java.time.ZoneOffset.ofHours(hours)

  def apply(hours: Int, minutes: Int): ZoneOffset = java.time.ZoneOffset.ofHoursMinutes(hours, minutes)

  def apply(hours: Int, minutes: Int, seconds: Int): ZoneOffset =
    java.time.ZoneOffset.ofHoursMinutesSeconds(hours, minutes, seconds)

  /** @see java.time.ZoneOffset.from(TemporalAccessor) */
  def apply(accessor: TemporalAccessor): ZoneOffset =
    java.time.ZoneOffset.from(accessor)
}

object TimeUnit {

  final val NanoSeconds: TimeUnit = java.util.concurrent.TimeUnit.NANOSECONDS

  final val MicroSeconds: TimeUnit = java.util.concurrent.TimeUnit.MICROSECONDS

  final val MilliSeconds: TimeUnit = java.util.concurrent.TimeUnit.MILLISECONDS

  final val Seconds: TimeUnit = java.util.concurrent.TimeUnit.SECONDS

  final val Minutes: TimeUnit = java.util.concurrent.TimeUnit.MINUTES

  final val Hours: TimeUnit = java.util.concurrent.TimeUnit.HOURS

  final val Days: TimeUnit = java.util.concurrent.TimeUnit.DAYS

}
