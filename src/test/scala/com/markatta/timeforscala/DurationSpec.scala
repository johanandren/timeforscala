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

import java.time.temporal.ChronoUnit

import scala.concurrent.duration.{FiniteDuration, SECONDS}

class DurationSpec extends BaseSpec {

  "the duration enrichment" should {

    "create instances" in {
      Duration(20) shouldEqual Duration(20, 0)
      Hours(10).hours shouldEqual 10
      Minutes(10).minutes shouldEqual 10
      Seconds(10).seconds shouldEqual 10
      Millis(10).millis shouldEqual 10
      Nanos(10).nanos shouldEqual 10
      Duration(FiniteDuration(10, SECONDS)).seconds shouldEqual 10
      Duration(10, ChronoUnit.MINUTES).minutes shouldEqual 10
      Duration(Duration(10)).seconds shouldEqual 10
    }

    "calculate duration" in {
      Duration(15) + Duration(5) shouldEqual Duration(20)
      Duration(15) - Duration(5) shouldEqual Duration(10)
      Duration(10) / 2l shouldEqual Duration(5)
      Duration(10) * 2l shouldEqual Duration(20)
    }

    "compare instances" in {
      Minutes(2) > Minutes(1) should be (true)
      Duration(20) > Duration(19) should be (true)
      Duration(19) < Duration(20) should be (true)
      Duration(20) == Duration(20) should be (true)
      Duration(20) != Duration(21) should be (true)
    }

    "transform durations in to scala finite durations" in {
      val finite = Duration(20).toFiniteDuration

      import scala.concurrent.duration._
      finite should equal (20.seconds)
    }

    "transform durations with nanosecond to scala finite duration" in {
      val finite = Duration(20, Duration(1).toNanos / 10).toFiniteDuration

      import scala.concurrent.duration._
      finite should equal (20.1.seconds)
    }

    "unapply" in {
      val result = Duration(10, 20) match {
        case Duration(second, nano) => (second, nano)
      }

      result should equal ((10, 20))
    }
  }



}
