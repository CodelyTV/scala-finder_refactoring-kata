package tv.codely.finderKata.algorithm

object ClosestBirthDateCriterion extends Ordering[PeoplePair] {
  def compare(base: PeoplePair, candidate: PeoplePair): Int =
    candidate.birthDatesDistanceInSeconds.compare(base.birthDatesDistanceInSeconds)
}

object FurthestBirthDateCriterion extends Ordering[PeoplePair] {
  def compare(base: PeoplePair, candidate: PeoplePair): Int =
    base.birthDatesDistanceInSeconds.compare(candidate.birthDatesDistanceInSeconds)
}