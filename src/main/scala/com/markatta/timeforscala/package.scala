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

package com.markatta

package object timeforscala {

  import scala.language.implicitConversions
  implicit def richInstant(instant: Instant): RichInstant = new RichInstant(instant)
  implicit def richDuration(duration: Duration): RichDuration = new RichDuration(duration)
  implicit def richYearMonth(yearMonth: YearMonth): RichYearMonth = new RichYearMonth(yearMonth)
  implicit def richLocalDateTime(ldt: LocalDateTime): RichLocalDateTime = new RichLocalDateTime(ldt)
  implicit def richLocalTime(l: LocalTime): RichLocalTime = new RichLocalTime(l)
  implicit def richLocalDate(ld: LocalDate): RichLocalDate = new RichLocalDate(ld)
  implicit def richZonedDateTime(zdt: ZonedDateTime): RichZonedDateTime = new RichZonedDateTime(zdt)
  implicit def richPeriod(p: Period): RichPeriod = new RichPeriod(p)

  def minimum[T](one: T, another: T)(implicit order: Ordering[T]): T = if(order.compare(one, another) <= 0) one else another
  def maximum[T](one: T, another: T)(implicit order: Ordering[T]): T = if(order.compare(one, another) <= 0) another else one

  @deprecated("Please, use [[com.markatta.timeforscala.Month.January]] instead", "com.markatta.timeforscala 1.4")
  val January = Month.January
  @deprecated("Please, use [[com.markatta.timeforscala.Month.February]] instead", "com.markatta.timeforscala 1.4")
  val February = Month.February
  @deprecated("Please, use [[com.markatta.timeforscala.Month.March]] instead", "com.markatta.timeforscala 1.4")
  val March = Month.March
  @deprecated("Please, use [[com.markatta.timeforscala.Month.May]] instead", "com.markatta.timeforscala 1.4")
  val May = Month.May
  @deprecated("Please, use [[com.markatta.timeforscala.Month.June]] instead", "com.markatta.timeforscala 1.4")
  val June = Month.June
  @deprecated("Please, use [[com.markatta.timeforscala.Month.July]] instead", "com.markatta.timeforscala 1.4")
  val July = Month.July
  @deprecated("Please, use [[com.markatta.timeforscala.Month.August]] instead", "com.markatta.timeforscala 1.4")
  val August = Month.August
  @deprecated("Please, use [[com.markatta.timeforscala.Month.September]] instead", "com.markatta.timeforscala 1.4")
  val September = Month.September
  @deprecated("Please, use [[com.markatta.timeforscala.Month.October]] instead", "com.markatta.timeforscala 1.4")
  val October = Month.October
  @deprecated("Please, use [[com.markatta.timeforscala.Month.November]] instead", "com.markatta.timeforscala 1.4")
  val November = Month.November
  @deprecated("Please, use [[com.markatta.timeforscala.Month.December]] instead", "com.markatta.timeforscala 1.4")
  val December = Month.December

  type Clock = java.time.Clock
  type Month = java.time.Month
  type Year = java.time.Year
  type DayOfWeek = java.time.DayOfWeek
  type LocalTime = java.time.LocalTime
  type Instant = java.time.Instant
  type YearMonth = java.time.YearMonth
  type Duration = java.time.Duration
  type LocalDate = java.time.LocalDate
  type LocalDateTime = java.time.LocalDateTime
  type ZonedDateTime = java.time.ZonedDateTime
  type Period = java.time.Period
  type ZoneId = java.time.ZoneId
  type ZoneOffset = java.time.ZoneOffset
  type TimeUnit = java.util.concurrent.TimeUnit

  type IsoChronology = java.time.chrono.IsoChronology
  type Chronology = java.time.chrono.Chronology

  type DateTimeFormatter = java.time.format.DateTimeFormatter
  type FormatStyle = java.time.format.FormatStyle

  type Temporal = java.time.temporal.Temporal
  type TemporalUnit = java.time.temporal.TemporalUnit
  type TemporalAccessor = java.time.temporal.TemporalAccessor
  type TemporalAmount = java.time.temporal.TemporalAmount
  type ChronoUnit = java.time.temporal.ChronoUnit
}
