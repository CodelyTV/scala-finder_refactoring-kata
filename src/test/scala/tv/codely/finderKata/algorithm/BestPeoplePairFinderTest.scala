package tv.codely.finderKata.algorithm

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
      val people = Seq.empty[Person]

      val peoplePairFound = (new BestPeoplePairFinder).find(people, ClosestBirthDateCriterion)

      peoplePairFound shouldBe None
    }

    "return none when given one person" in {
      val people = Seq(from1950)

      val peoplePairFound = (new BestPeoplePairFinder).find(people, ClosestBirthDateCriterion)

      peoplePairFound shouldBe None
    }

    "return closest two for two people" in {
      val people = Seq(from1950, from1952)

      val peoplePairFound = (new BestPeoplePairFinder).find(people, ClosestBirthDateCriterion)

      peoplePairFound shouldBe defined
      peoplePairFound.value.younger shouldBe from1950
      peoplePairFound.value.older shouldBe from1952
    }

    "return furthest two for two people" in {
      val people = Seq(from1979, from1952)

      val peoplePairFound = (new BestPeoplePairFinder).find(people, FurthestBirthDateCriterion)

      peoplePairFound shouldBe defined
      peoplePairFound.value.younger shouldBe from1952
      peoplePairFound.value.older shouldBe from1979
    }

    "return furthest two for four people" in {
      val people = Seq(from1950, from1982, from1979, from1952)

      val peoplePairFound = (new BestPeoplePairFinder).find(people, FurthestBirthDateCriterion)

      peoplePairFound shouldBe defined
      peoplePairFound.value.younger shouldBe from1950
      peoplePairFound.value.older shouldBe from1982
    }

    "return closest two for four people" in {
      val people = Seq(from1950, from1982, from1979, from1952)

      val peoplePairFound = (new BestPeoplePairFinder).find(people, ClosestBirthDateCriterion)

      peoplePairFound shouldBe defined
      peoplePairFound.value.younger shouldBe from1950
      peoplePairFound.value.older shouldBe from1952
    }
  }
}

