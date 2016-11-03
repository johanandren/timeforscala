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

class PeriodSpec extends BaseSpec {

  "the duration enrichment" should {

    "create instances" in {
      val p = Period(years = 1, months = 2, days = 3)
      p.years shouldEqual (1)
      p.months shouldEqual (2)
      p.days shouldEqual  3

      Days(10).days shouldEqual 10
      Weeks(10).days shouldEqual 70
      Months(10).months shouldEqual 10
      Years(10).years shouldEqual 10
    }

    "add with another duration" in {
      (Days(1) + Days(1)) shouldEqual Days(2)
    }

    "subtract" in {
      (Days(2) - Days(1)) shouldEqual Days(1)
    }

    "compare instances" in {
      Days(20) > Days(19) should be (true)
    }

    "transform durations in to scala finite durations" in {
      val finite = Duration(20).toFiniteDuration

      import scala.concurrent.duration._
      finite should equal (20.seconds)
    }

  }



}
