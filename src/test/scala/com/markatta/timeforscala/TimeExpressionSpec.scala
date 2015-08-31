package com.markatta.timeforscala

class TimeExpressionSpec extends BaseSpec {

  "the time expressions" should {

    import TimeExpressions._
    "create instances" in {
      1.nano shouldEqual Nanos(1)
      2.nanos shouldEqual Nanos(2)
      1.milli shouldEqual Millis(1)
      2.millis shouldEqual Millis(2)
      1.second shouldEqual Seconds(1)
      2.seconds shouldEqual Seconds(2)
      1.minute shouldEqual Minutes(1)
      2.minutes shouldEqual Minutes(2)
      1.hour shouldEqual Hours(1)
      2.hours shouldEqual Hours(2)
      1.day shouldEqual Days(1)
      2.days shouldEqual Days(2)
      1.week shouldEqual Weeks(1)
      2.weeks shouldEqual Weeks(2)
      1.month shouldEqual Months(1)
      2.months shouldEqual Months(2)
      1.year shouldEqual Years(1)
      2.years shouldEqual Years(2)
    }

  }
}
