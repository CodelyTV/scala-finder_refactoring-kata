package tv.codely.finderKata.algorithm

import java.util.ArrayList

import com.github.nscala_time.time.Imports._
import org.scalatest._
import org.scalatest.Matchers._
import org.scalatest.OptionValues._

final class BestPeoplePairFinderTest extends WordSpec {

  val from1950 = Person(PersonName("Sue"), DateTime.parse("1950-01-01"))
  val from1952 = Person(PersonName("Greg"), DateTime.parse("1952-05-01"))
  val from1982 = Person(PersonName("Sarah"), DateTime.parse("1982-01-01"))
  val from1979 = Person(PersonName("Mike"), DateTime.parse("1979-01-01"))

  "Finder" should {
    "return none when given empty list" in {
      val people = new ArrayList[Person]()

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      peoplePairFound shouldBe None
    }

    "return none when given one person" in {
      val people = new ArrayList[Person]()
      people.add(from1950)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      peoplePairFound shouldBe None
    }

    "return closest two for two people" in {
      val people = new ArrayList[Person]()
      people.add(from1950)
      people.add(from1952)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      peoplePairFound shouldBe defined
      peoplePairFound.value.person1 shouldBe from1950
      peoplePairFound.value.person2 shouldBe from1952
    }

    "return furthest two for two people" in {
      val people = new ArrayList[Person]()
      people.add(from1979)
      people.add(from1952)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.FurthestBirthDate)

      peoplePairFound shouldBe defined
      peoplePairFound.value.person1 shouldBe from1952
      peoplePairFound.value.person2 shouldBe from1979
    }

    "return furthest two for four people" in {
      val people = new ArrayList[Person]()
      people.add(from1950)
      people.add(from1982)
      people.add(from1979)
      people.add(from1952)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.FurthestBirthDate)

      peoplePairFound shouldBe defined
      peoplePairFound.value.person1 shouldBe from1950
      peoplePairFound.value.person2 shouldBe from1982
    }

    "return closest two for four people" in {
      val people = new ArrayList[Person]()
      people.add(from1950)
      people.add(from1982)
      people.add(from1979)
      people.add(from1952)

      val finder = new BestPeoplePairFinder(people)

      val peoplePairFound = finder.Find(PeoplePairCriterion.ClosestBirthDate)

      peoplePairFound shouldBe defined
      peoplePairFound.value.person1 shouldBe from1950
      peoplePairFound.value.person2 shouldBe from1952
    }
  }
}

