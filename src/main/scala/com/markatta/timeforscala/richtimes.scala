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

import java.util.concurrent.TimeUnit

import scala.concurrent.duration.FiniteDuration

final class RichLocalDateTime private[timeforscala](l: LocalDateTime) extends Ordered[LocalDateTime] {
  def year: Int = l.getYear
  def dayOfMonth: Int = l.getDayOfMonth
  def month: Month = l.getMonth
  def monthValue: Int = l.getMonthValue
  def dayOfWeek: DayOfWeek = l.getDayOfWeek
  def dayOfYear: Int = l.getDayOfYear
  def hour: Int = l.getHour
  def minute: Int = l.getMinute
  def second: Int = l.getSecond
  def nano: Int = l.getNano
  def chronology: Chronology = l.getChronology

  def +(amount: Period): LocalDateTime = l.plus(amount)
  def -(amount: Period): LocalDateTime = l.minus(amount)
  def +(amount: Duration): LocalDateTime = l.plus(amount)
  def -(amount: Duration): LocalDateTime= l.minus(amount)

  def -(other: LocalDateTime): Duration = Duration.between(l, other)

  override def compare(that: LocalDateTime): Int = l.compareTo(that)
}

final class RichLocalDate private[timeforscala](l: LocalDate) extends Ordered[LocalDate] {
  def year: Int = l.getYear
  def dayOfMonth: Int = l.getDayOfMonth
  def month: Month = l.getMonth
  def monthValue: Int = l.getMonthValue
  def dayOfWeek: DayOfWeek = l.getDayOfWeek
  def dayOfYear: Int = l.getDayOfYear
  def chronology: Chronology = l.getChronology

  def +(amount: Period): LocalDate = l.plus(amount)
  def -(amount: Period): LocalDate = l.minus(amount)

  /**
   * @return the period from this date until other, exclusive end date
   * @see java.time.LocalDate.until(ChronoLocalDate)
   */
  def -(other: LocalDate): Period = l.until(other)

  override def compare(that: LocalDate): Int = l.compareTo(that)
}

final class RichLocalTime private[timeforscala](l: LocalTime) extends Ordered[LocalTime] {
  def hour: Int = l.getHour
  def minute: Int = l.getMinute
  def second: Int = l.getSecond
  def nano: Int = l.getNano

  def +(duration: Duration): LocalTime = l.plus(duration)
  def -(duration: Duration): LocalTime = l.minus(duration)

  override def compare(that: LocalTime): Int = l.compareTo(that)
}

final class RichZonedDateTime private[timeforscala](z: ZonedDateTime) extends Ordered[ZonedDateTime] {
  def year: Int = z.getYear
  def dayOfMonth: Int = z.getDayOfMonth
  def month: Month = z.getMonth
  def monthValue: Int = z.getMonthValue
  def dayOfWeek: DayOfWeek = z.getDayOfWeek
  def dayOfYear: Int = z.getDayOfYear
  def hour: Int = z.getHour
  def minute: Int = z.getMinute
  def second: Int = z.getSecond
  def nano: Int = z.getNano
  def zone: ZoneId = z.getZone
  def offset: ZoneOffset = z.getOffset

  def localDate: LocalDate = z.toLocalDate
  def localTime: LocalTime = z.toLocalTime
  def localDateTime: LocalDateTime = z.toLocalDateTime


  def +(amount: Period): ZonedDateTime = z.plus(amount)
  def -(amount: Period): ZonedDateTime = z.minus(amount)
  def +(amount: Duration): ZonedDateTime = z.plus(amount)
  def -(amount: Duration): ZonedDateTime = z.minus(amount)

  def -(other: ZonedDateTime): Duration = Duration.between(z, other)

  def chronology: Chronology = z.getChronology
  override def compare(other: ZonedDateTime): Int = z.compareTo(other)
}

final class RichInstant private[timeforscala](i: Instant) extends Ordered[Instant] {
  def nano: Int = i.getNano
  def epochSecond: Long = i.getEpochSecond
  override def compare(that: Instant): Int = i.compareTo(that)
}

final class RichDuration private[timeforscala](d: Duration) extends Ordered[Duration] {

  def nanos: Long = d.toNanos
  def millis: Long = d.toMillis
  def seconds: Long = d.getSeconds
  def minutes: Long = d.toMinutes
  def hours: Long = d.toHours
  def days: Long = d.toDays

  def -(other: Duration): Duration = d.minus(other)
  def +(other: Duration): Duration = d.plus(other)
  def /(divisor: Long): Duration = d.dividedBy(divisor)
  def *(scalar: Long): Duration = d.multipliedBy(scalar)

  def toFiniteDuration: FiniteDuration = {
    val seconds = FiniteDuration(d.getSeconds, TimeUnit.SECONDS)
    val nanos = d.getNano
    if (nanos == 0) seconds
    else seconds + FiniteDuration(d.getNano, TimeUnit.NANOSECONDS)
  }

  override def compare(other: Duration): Int = d.compareTo(other)
}

final class RichPeriod private[timeforscala](p: Period) extends Ordered[Period] {

  def days: Int = p.getDays
  def months: Int = p.getMonths
  def years: Int = p.getYears
  def chronology: IsoChronology = p.getChronology

  def -(other: TemporalAmount): Period = p.minus(other)
  def +(other: TemporalAmount): Period = p.plus(other)
  def *(scalar: Int): Period = p.multipliedBy(scalar)

  override def compare(that: Period): Int = p.minus(that).getDays
}

final class RichYearMonth private[timeforscala](ym: YearMonth) extends Ordered[YearMonth] {
  def year: Int = ym.getYear
  def month: Month = ym.getMonth
  def monthValue: Int = ym.getMonthValue
  
  def -(amount: Period): YearMonth = ym.minus(amount)
  def +(amount: Period): YearMonth = ym.plus(amount)

  override def compare(other: YearMonth): Int = ym.compareTo(other)
}
