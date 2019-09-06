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

class LocalDateSpec extends BaseSpec {

  "the local date enrichment" should {

    "create local dates" in {
      LocalDate(2015, 1, 1) should equal (LocalDate(2015, January, 1))
      LocalDate("2015-05-23") should equal (LocalDate(2015, May, 23))
    }

    "calculate period between two dates" in {
      val result = LocalDate(2015, 2, 1) - LocalDate(2015, 1, 1)
      result.getMonths should be (1)
    }

    "unapply" in {
      val result = LocalDate(2015, 1, 2) match {
        case LocalDate(y, m, d) => (y, m, d)
      }
      result should equal (2015, January, 2)
    }

    "add with a period" in {
      val result = LocalDate(2015, 1, 1) + Days(2)
      result should equal (LocalDate(2015, January, 3))
    }

    "subtract with a period" in {
      val result = LocalDate(2015, 1, 1) - Days(2)
      result should equal (LocalDate(2014, December, 30))
    }

    "compare local dates" in {
      LocalDate(2019, 1, 1) >= LocalDate(2015, 1, 1) should equal (true)
    }
  }

}
