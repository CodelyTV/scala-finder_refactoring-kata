package tv.codely.finderKata.algorithm

import java.util
import java.util.ArrayList

import scala.collection.JavaConverters._

import tv.codely.finderKata.algorithm.PeoplePairCriterion.PeoplePairCriterion

class BestPeoplePairFinder(private val allPeople: util.List[Person]) {

  def Find(pairCriterion: PeoplePairCriterion): PeoplePair = {
    val allPeoplePairs = new ArrayList[PeoplePair]()

    for (currentPersonIteration <- 0 until allPeople.size - 1;
         personToPairIteration <- currentPersonIteration + 1 until allPeople.size) {
      val peoplePair: PeoplePair = new PeoplePair()

      if (allPeople.get(currentPersonIteration).birthDate.getMillis
          < allPeople.get(personToPairIteration).birthDate.getMillis) {
        peoplePair.person1 = allPeople.get(currentPersonIteration)
        peoplePair.person2 = allPeople.get(personToPairIteration)
      } else {
        peoplePair.person1 = allPeople.get(personToPairIteration)
        peoplePair.person2 = allPeople.get(currentPersonIteration)
      }

      peoplePair.birthDatesDistanceInSeconds =
        peoplePair.person2.birthDate.getMillis - peoplePair.person1.birthDate.getMillis

      allPeoplePairs.add(peoplePair)
    }

    if (allPeoplePairs.size < 1) {
      return new PeoplePair()
    }

    var bestPeoplePair: PeoplePair = allPeoplePairs.get(0)

    for (peoplePair: PeoplePair <- allPeoplePairs.asScala) pairCriterion match {
      case PeoplePairCriterion.ClosestBirthDate =>
        if (peoplePair.birthDatesDistanceInSeconds < bestPeoplePair.birthDatesDistanceInSeconds) {
        bestPeoplePair = peoplePair
      }
      case PeoplePairCriterion.FurthestBirthDate =>
        if (peoplePair.birthDatesDistanceInSeconds > bestPeoplePair.birthDatesDistanceInSeconds) {
        bestPeoplePair = peoplePair
      }
    }

    bestPeoplePair
  }
}
