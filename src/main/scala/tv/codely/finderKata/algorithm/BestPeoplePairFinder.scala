package tv.codely.finderKata.algorithm

final class BestPeoplePairFinder() {
  def find(people: Seq[Person], peoplePairCriterion: Ordering[PeoplePair]): Option[PeoplePair] = {
    val canFindPeoplePairs = people.size < 2

    if (canFindPeoplePairs) {
      None
    } else {
      val peoplePairs = people.combinations(PeoplePair.numberOfPeopleInAPair).map { peopleCombination =>
        val sortedPeopleCombination = peopleCombination.sorted

        PeoplePair(sortedPeopleCombination.head, sortedPeopleCombination(1))
      }

      val bestPeoplePair = peoplePairs.reduce { (bestPeoplePair, candidatePeoplePair) =>
        val isBetterCandidate = peoplePairCriterion.compare(bestPeoplePair, candidatePeoplePair) < 0

        if (isBetterCandidate) candidatePeoplePair else bestPeoplePair
      }

      Some(bestPeoplePair)
    }
  }
}
