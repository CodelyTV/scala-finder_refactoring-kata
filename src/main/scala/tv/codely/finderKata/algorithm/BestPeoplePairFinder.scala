package tv.codely.finderKata.algorithm

final class BestPeoplePairFinder() {
  def find(people: Seq[Person], peoplePairCriterion: Ordering[PeoplePair]): Option[PeoplePair] = {
    if (people.size < 2) {
      None
    } else {
      val peoplePairs = people.combinations(PeoplePair.numberOfPeopleInAPair).map { peopleCombination =>
        val sortedPeopleCombination = peopleCombination.sorted

        PeoplePair(sortedPeopleCombination.head, sortedPeopleCombination(1))
      }

      val bestPeoplePair = peoplePairs.reduce { (bestPeoplePair, candidatePeoplePair) =>
        if (peoplePairCriterion.compare(bestPeoplePair, candidatePeoplePair) < 0) {
          candidatePeoplePair
        } else {
          bestPeoplePair
        }
      }

      Some(bestPeoplePair)
    }
  }
}
