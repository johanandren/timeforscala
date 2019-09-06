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

class LocalDateTimeSpec extends BaseSpec {

  "the local date enrichment" should {

    "create local dates" in {
      LocalDateTime("2015-05-23T20:30:05") should equal (LocalDateTime(2015, May, 23, 20, 30, 5))
    }

    "add a period" in {
      val result = LocalDateTime(LocalDate(2015, 1, 1), LocalTime(20, 30, 5)) + Days(2)
      result shouldEqual LocalDateTime(2015, January, 3, 20, 30, 5)
    }

    "subtract a period" in {
      val result = LocalDateTime(2015, 1, 1, 20, 30, 5) - Days(2)
      result shouldEqual LocalDateTime(2014, December, 30, 20, 30, 5)
    }

    "add a duration" in {
      val result = LocalDateTime(2015, 1, 1, 20, 30, 0) + Hours(2)
      result shouldEqual LocalDateTime(2015, January, 1, 22, 30)
    }

    "subtract a duration" in {
      val result = LocalDateTime(2015, 1, 1, 20, 30, 5) - Hours(2)
      result shouldEqual LocalDateTime(2015, January, 1, 18, 30, 5)
    }

    "create a duration between two date times" in {
      val result = LocalDateTime("2015-05-24T22:30:25") - LocalDateTime("2015-05-23T20:30:05")
      result.seconds shouldEqual (26 * 60 * 60 + 20)
    }

    "compare local date times" in {
      LocalDateTime(2015, 1, 1, 23, 0, 0) >= LocalDateTime(2015, 1, 1, 12, 0, 0) shouldEqual true
    }
  }

}
