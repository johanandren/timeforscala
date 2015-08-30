# time for scala

A minimal library of factories and implicit decorators for the Java 8 time API
to make it more user friendly and concise to use from Scala.

## Requirements
Java 8, Scala 2.11+

## Using
TODO - publish to maven central

## Examples

### Creating instances
Factory objects making constructing common classes simpler/more concise/more readable:

```scala
import com.markatta.timeforscala._

// java.time.Duration
val d1 = Duration(seconds = 20, nanos = 1)
val d2 = Hours(10)
val d3 = Minutes(10)
val d4 = Seconds(10) 
val d5 = Millis(10)
val d6 = Nanos(10)

// java.time.Perod
val p1 = Period(years = 1, months = 2, days = 3)
val p2 = Days(10)
val p3 = Weeks(10)
val p4 = Months(10)
val p5 = Years(10)

// java.time.LocalDate
val ld1 = LocalDate(2015, 1, 1)
val ld2 = LocalDate(2015, January, 1)
val ld3 = LocalDate("2015-01-01")

// java.time.LocalTime
val lt1 = LocalTime(20, 30)
val lt2 = LocalTime(hour = 20, minute = 30, second = 12, nano = 5)

// java.time.LocalDate
val ld1 = LocalDate(2015, 1, 1)
val ld2 = LocalDate(2015, January, 1)
val ld3 = LocalDate("2015-01-01")

// java.time.LocalDateTime
val ldt1 = LocalDateTime(2015, 1, 1, 20, 30, 5)
val ldt3 = LocalDateTime(2015, January, 1, 20, 30, 5)
val ldt4 = LocalDateTime(LocalDate(2015, 1, 1), LocalTime(20, 30, 5))
val ldt5 = LocalDateTime("2015-01-01T20:30:05")

// java.time.ZonedDateTime
val zdt1 = ZonedDateTime(LocalDate(2015, 1, 1), LocalTime(20, 30, 10), ZoneId.of("GMT"))

// java.time.YearMonth
val ym1 = YearMonth(2015, 1)
val ym2 = YearMonth(2015, January)
```

### Comparing
Ordered is implemented for LocalDateTime, LocalDate, LocalTime, ZonedDateTime, Instant, Duration, Period and YearMonth
so that those can be compared using '<' '>' etc.

```Scala
import com.markatta.timeforscala._

val first = LocalTime(20, 30)
val last = LocalTime(20, 31)

assert(first < last)
assert(last > first)
assert(last != first)
```

### arithmetic
Most decorators provide + and - with other types considered sane.

```scala
import com.markatta.timeforscala._

// java.time.Duration
assert(Minutes(20) - Minutes(10) == Minutes(10))
assert(Duration(10) + Duration(10) == Duration(20))
assert(Duration(20) / 5 = Duration(4))
assert(Duration(10) * 5 = Duration(50))

// java.time.Period
assert(Days(1) + Days(1) == Days(2))
assert(Months(2) - Months(1) == Months(1))

// java.time.LocalTime
assert(LocalTime(20, 30) + Minutes(5) == LocalTime(20, 35))
assert(LocalTime(20, 30) - Minutes(5) == LocalTime(20, 25))

// java.time.LocalDate
assert(LocalDate(2015, January, 1) + Months(2) == LocalDate(2015, March, 1))
assert(LocalDate(2015, March, 1) - Months(2) == LocalDate(2015, January, 1))

// and so on
```

### other useful things
Transform a `java.time.Duration` into a `scala.concurrent.FiniteDuration`

```scala
import com.markatta.timeforscala._
import scala.concurrent.duration._

assert(Seconds(2).toFiniteDuration == Duration(2.seconds))
```


## License
Apache License, Version 2.0

