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

class LocalTimeSpec extends BaseSpec {

  "the local time enrichment" should {

    "create local times" in {
      LocalTime(20, 30) shouldEqual LocalTime(20, 30, 0, 0)
    }

    "unapply" in {
      val result = LocalTime(20, 30, 1, 2) match {
        case LocalTime(h, m, s, n) => (h, m, s, n)
      }
      result shouldEqual (20, 30, 1, 2)
    }

    "add with a duration" in {
      val result = LocalTime(20, 30) + Minutes(2)
      result shouldEqual LocalTime(20, 32)
    }

    "subtract with a duration" in {
      val result = LocalTime(20, 32) - Minutes(2)
      result shouldEqual LocalTime(20, 30)
    }

    "should compare" in {
      val first = LocalTime(20, 30)
      val last = LocalTime(20, 31)

      (first < last) shouldBe true
      (last > first) shouldBe true
      (last != first) shouldBe true
    }

  }

}
