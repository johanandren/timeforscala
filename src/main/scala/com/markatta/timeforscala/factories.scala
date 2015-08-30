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

import java.time._
import java.time.temporal.TemporalAccessor

import scala.concurrent.duration.FiniteDuration

// factory methods for the most common use cases to be able to get away with just one import
// in most cases

object Duration {
  def apply(seconds: Long, nanos: Long = 0): Duration = java.time.Duration.ofSeconds(seconds, nanos)
  def apply(duration: FiniteDuration): Duration = java.time.Duration.ofSeconds(duration.toSeconds)
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


object Period {
  def apply(years: Int, months: Int, days: Int): Period =
    java.time.Period.of(years, months, days)
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

  /** @return now according to the system clock */
  def apply(): LocalDate = java.time.LocalDate.now()
  /** @return now according to the given clock */
  def apply(clock: Clock): LocalDate = java.time.LocalDate.now(clock)
  /** @return now in the given time zone */
  def apply(zone: ZoneId): LocalDate = java.time.LocalDate.now(zone)

}

object LocalDateTime {

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

  /** @return now according to the system clock */
  def apply(): LocalDateTime = java.time.LocalDateTime.now()
  /** @return now according to the given clock */
  def apply(clock: Clock): LocalDateTime = java.time.LocalDateTime.now(clock)
  /** @return now in the given time zone */
  def apply(zone: ZoneId): LocalDateTime = java.time.LocalDateTime.now(zone)

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

  /** @return now according to the system clock */
  def apply(): ZonedDateTime = java.time.ZonedDateTime.now()
  /** @return now according to the given clock */
  def apply(clock: Clock): ZonedDateTime = java.time.ZonedDateTime.now(clock)
  /** @return now in the given time zone */
  def apply(zone: ZoneId): ZonedDateTime = java.time.ZonedDateTime.now(zone)

}

object YearMonth {

  /** @see java.time.YearMonth.of(Int, Int) */
  def apply(year: Int, month: Int): YearMonth =
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

  /** @return now according to the system clock */
  def apply(): YearMonth = java.time.YearMonth.now()
  /** @return now according to the given clock */
  def apply(clock: Clock): YearMonth = java.time.YearMonth.now(clock)
  /** @return now in the given time zone */
  def apply(zone: ZoneId): YearMonth = java.time.YearMonth.now(zone)

}
