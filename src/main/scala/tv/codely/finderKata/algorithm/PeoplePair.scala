package tv.codely.finderKata.algorithm

final case class PeoplePair(person1: Person, person2: Person) {
  val birthDatesDistanceInSeconds: Long = {
    person2.birthDate.getMillis - person1.birthDate.getMillis
  }
}
