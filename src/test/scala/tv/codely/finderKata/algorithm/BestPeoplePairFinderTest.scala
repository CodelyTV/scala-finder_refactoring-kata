package tv.codely.finderKata.algorithm

import java.util.ArrayList

import com.github.nscala_time.time.Imports._
import org.scalatest._
import org.scalatest.Matchers._

final class BestPeoplePairFinderTest extends WordSpec with BeforeAndAfterEach {

  var from1950: Person = new Person()
  var from1952: Person = new Person()
  var from1982: Person = new Person()
  var from1979: Person = new Person()

  override def beforeEach(): Unit = {
    from1950.name = "Sue"
    from1950.birthDate = DateTime.parse("1950-01-01")

    from1952.name = "Greg"
    from1952.birthDate = DateTime.parse("1952-05-01")

    from1982.name = "Sarah"
    from1982.birthDate = DateTime.parse("1982-01-01")

    from1979.name = "Mike"
    from1979.birthDate = DateTime.parse("1979-01-01")
  }

  "Finder" should {
    "Return empty results when given empty list" in {
      val list = new ArrayList[Person]()

      val finder = new BestPeoplePairFinder(list)

      val result = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      result.person1 shouldBe null
      result.person2 shouldBe null
    }

    "Return empty results when given one person" in {
      val list = new ArrayList[Person]()
      list.add(from1950)

      val finder = new BestPeoplePairFinder(list)

      val result = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      result.person1 shouldBe null
      result.person2 shouldBe null
    }

    "Return closest two for two people" in {
      val list = new ArrayList[Person]()
      list.add(from1950)
      list.add(from1952)

      val finder = new BestPeoplePairFinder(list)

      val result = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      result.person1 shouldBe from1950
      result.person2 shouldBe from1952
    }

    "Return furthest two for two people" in {
      val list = new ArrayList[Person]()
      list.add(from1979)
      list.add(from1952)

      val finder = new BestPeoplePairFinder(list)

      val result = finder.Find(PeoplePairCriterion.FurthestBirthDate)

      result.person1 shouldBe from1952
      result.person2 shouldBe from1979
    }

    "Return furthest two for four people" in {
      val list = new ArrayList[Person]()
      list.add(from1950)
      list.add(from1982)
      list.add(from1979)
      list.add(from1952)

      val finder = new BestPeoplePairFinder(list)

      val result = finder.Find(PeoplePairCriterion.FurthestBirthDate)

      result.person1 shouldBe from1950
      result.person2 shouldBe from1982
    }

    "Return closest two for four people" in {
      val list = new ArrayList[Person]()
      list.add(from1950)
      list.add(from1982)
      list.add(from1979)
      list.add(from1952)

      val finder = new BestPeoplePairFinder(list)

      val result = finder.Find(PeoplePairCriterion.ClosestBirthDate)


      result.person1 shouldBe from1950
      result.person2 shouldBe from1952
    }
  }
}
