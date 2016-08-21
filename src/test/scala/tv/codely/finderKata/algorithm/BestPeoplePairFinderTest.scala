package tv.codely.finderKata.algorithm

import java.util.ArrayList

import com.github.nscala_time.time.Imports._
import org.scalatest._
import org.scalatest.Matchers._

final class BestPeoplePairFinderTest extends WordSpec {

  val from1950: Person = Person("Sue", DateTime.parse("1950-01-01"))
  val from1952: Person = Person("Greg", DateTime.parse("1952-05-01"))
  val from1982: Person = Person("Sarah", DateTime.parse("1982-01-01"))
  val from1979: Person = Person("Mike", DateTime.parse("1979-01-01"))

  "Finder" should {
    "Return empty results when given empty list" in {
      val people = new ArrayList[Person]()

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      peoplePairFound.person1 shouldBe null
      peoplePairFound.person2 shouldBe null
    }

    "Return empty results when given one person" in {
      val people = new ArrayList[Person]()
      people.add(from1950)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      peoplePairFound.person1 shouldBe null
      peoplePairFound.person2 shouldBe null
    }

    "Return closest two for two people" in {
      val people = new ArrayList[Person]()
      people.add(from1950)
      people.add(from1952)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      peoplePairFound.person1 shouldBe from1950
      peoplePairFound.person2 shouldBe from1952
    }

    "Return furthest two for two people" in {
      val people = new ArrayList[Person]()
      people.add(from1979)
      people.add(from1952)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.FurthestBirthDate)

      peoplePairFound.person1 shouldBe from1952
      peoplePairFound.person2 shouldBe from1979
    }

    "Return furthest two for four people" in {
      val people = new ArrayList[Person]()
      people.add(from1950)
      people.add(from1982)
      people.add(from1979)
      people.add(from1952)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.FurthestBirthDate)

      peoplePairFound.person1 shouldBe from1950
      peoplePairFound.person2 shouldBe from1982
    }

    "Return closest two for four people" in {
      val people = new ArrayList[Person]()
      people.add(from1950)
      people.add(from1982)
      people.add(from1979)
      people.add(from1952)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      peoplePairFound.person1 shouldBe from1950
      peoplePairFound.person2 shouldBe from1952
    }
  }
}

