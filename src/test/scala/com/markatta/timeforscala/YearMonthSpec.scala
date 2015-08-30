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

class YearMonthSpec extends BaseSpec {

  "the year month enrichment" should {

    "create a year month instance" in {
      val instance = YearMonth(2015, 1)
      instance.year shouldEqual 2015
      instance.month shouldEqual January
     }

    "unapply" in {
      val result = YearMonth(2015, 1) match {
        case YearMonth(y, m) => (y, m)
      }
      result should equal (2015, January)
    }

    "add with a period" in {
      val result = YearMonth(2015, 1) + Months(1)
      result should equal (YearMonth(2015, 2))
    }

  }

}
