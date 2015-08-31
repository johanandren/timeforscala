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

import java.time.{Period, Duration}

/**
 * Provides implicit decoration for ints and longs so that durations and periods can be created
 * much like the `scala.concurrent.duration` mini-dsl.
 *
 * Example:
 * {{{
 *   import com.markatta.timeforscala.TimeExpressions._
 *   val duration = 5 seconds
 *   val period = 1 week
 * }}}
 */
object TimeExpressions {


  final implicit class RichInt(val n: Int) extends AnyVal {
    def hour: Duration = Hours(n)
    def hours: Duration = Hours(n)
    def minute: Duration = Minutes(n)
    def minutes: Duration = Minutes(n)
    def second: Duration = Seconds(n)
    def seconds: Duration = Seconds(n)
    def milli: Duration = Millis(n)
    def millis: Duration = Millis(n)
    def nano: Duration = Nanos(n)
    def nanos: Duration = Nanos(n)



    def day: Period = Days(n)
    def days: Period = Days(n)
    def week: Period = Weeks(n)
    def weeks: Period = Weeks(n)
    def month: Period = Months(n)
    def months: Period = Months(n)
    def year: Period = Years(n)
    def years: Period = Years(n)
  }

}
