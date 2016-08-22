package tv.codely.finderKata.algorithm

import tv.codely.finderKata.algorithm.PeoplePairCriterion.PeoplePairCriterion

class BestPeoplePairFinder(people: Seq[Person]) {

  def Find(peoplePairOrdering: PeoplePairCriterion): Option[PeoplePair] = {
    if (people.size < 2) {
      None
    } else {
      val peoplePairs = people.combinations(PeoplePair.numberOfPeopleInAPair).map { peopleCombination =>
        val sortedPeopleCombination = peopleCombination.sorted

        PeoplePair(sortedPeopleCombination.head, sortedPeopleCombination(1))
      }

      val bestPeoplePair = peoplePairs.reduce { (bestPeoplePair, candidatePeoplePair) =>
        peoplePairOrdering match {
          case PeoplePairCriterion.ClosestBirthDate =>
            if (candidatePeoplePair.birthDatesDistanceInSeconds < bestPeoplePair.birthDatesDistanceInSeconds) {
              candidatePeoplePair
            } else {
              bestPeoplePair
            }
          case PeoplePairCriterion.FurthestBirthDate =>
            if (candidatePeoplePair.birthDatesDistanceInSeconds > bestPeoplePair.birthDatesDistanceInSeconds) {
              candidatePeoplePair
            } else {
              bestPeoplePair
            }
        }
      }

      Some(bestPeoplePair)
    }
  }
}
