package tv.codely.finderKata.algorithm

import java.util
import java.util.ArrayList

import scala.collection.JavaConverters._

import tv.codely.finderKata.algorithm.PeoplePairCriterion.PeoplePairCriterion

class BestPeoplePairFinder(private val allPeople: util.List[Person]) {

  def Find(pairCriterion: PeoplePairCriterion): Option[PeoplePair] = {
    val allPeoplePairs = new ArrayList[PeoplePair]()

    for (currentPersonIteration <- 0 until allPeople.size - 1;
         personToPairIteration <- currentPersonIteration + 1 until allPeople.size) {

      val peoplePair = if (allPeople.get(currentPersonIteration).birthDate.getMillis
          < allPeople.get(personToPairIteration).birthDate.getMillis) {

        val currentPerson = allPeople.get(currentPersonIteration)
        val personToPair = allPeople.get(personToPairIteration)

        PeoplePair(currentPerson, personToPair)
      } else {

        val currentPerson = allPeople.get(currentPersonIteration)
        val personToPair = allPeople.get(personToPairIteration)

        PeoplePair(personToPair, currentPerson)
      }

      allPeoplePairs.add(peoplePair)
    }

    if (allPeoplePairs.size < 1) {
      None
    } else {
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

      Some(bestPeoplePair)
    }
  }
}
