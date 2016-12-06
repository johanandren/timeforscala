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

import java.time._

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

  val January = Month.JANUARY
  val February = Month.FEBRUARY
  val March = Month.MARCH
  val May = Month.MAY
  val June = Month.JUNE
  val July = Month.JULY
  val August = Month.AUGUST
  val September = Month.SEPTEMBER
  val October = Month.OCTOBER
  val November = Month.NOVEMBER
  val December = Month.DECEMBER

  type LocalTime = java.time.LocalTime
  type Instant = java.time.Instant
  type YearMonth = java.time.YearMonth
  type Duration = java.time.Duration
  type LocalDate = java.time.LocalDate
  type LocalDateTime = java.time.LocalDateTime
  type ZonedDateTime = java.time.ZonedDateTime
  type Period = java.time.Period

  type DateTimeFormatter = java.time.format.DateTimeFormatter

}
