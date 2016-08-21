package tv.codely.finderKata.algorithm

import java.util
import java.util.ArrayList

import scala.collection.JavaConverters._

import tv.codely.finderKata.algorithm.PeoplePairCriterion.PeoplePairCriterion

class BestPeoplePairFinder(private val _p: util.List[Person]) {

  def Find(pairCriterion: PeoplePairCriterion): PeoplePair = {
    val tr = new ArrayList[PeoplePair]()

    for (i <- 0 until _p.size - 1; j <- i + 1 until _p.size) {
      val r: PeoplePair = new PeoplePair()

      if (_p.get(i).birthDate.getMillis < _p.get(j).birthDate.getMillis) {
        r.person1 = _p.get(i)
        r.person2 = _p.get(j)
      } else {
        r.person1 = _p.get(j)
        r.person2 = _p.get(i)
      }

      r.birthDatesDistanceInSeconds = r.person2.birthDate.getMillis - r.person1.birthDate.getMillis
      tr.add(r)
    }

    if (tr.size < 1) {
      return new PeoplePair()
    }

    var answer: PeoplePair = tr.get(0)

    for (result: PeoplePair <- tr.asScala) pairCriterion match {
      case PeoplePairCriterion.ClosestBirthDate => if (result.birthDatesDistanceInSeconds < answer.birthDatesDistanceInSeconds) {
        answer = result
      }
      case PeoplePairCriterion.FurthestBirthDate => if (result.birthDatesDistanceInSeconds > answer.birthDatesDistanceInSeconds) {
        answer = result
      }
    }

    answer
  }
}
