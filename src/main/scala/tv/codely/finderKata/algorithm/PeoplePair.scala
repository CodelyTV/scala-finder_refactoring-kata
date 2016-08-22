package tv.codely.finderKata.algorithm

object PeoplePair {
  val numberOfPeopleInAPair = 2
}

final case class PeoplePair(younger: Person, older: Person) {
  val birthDatesDistanceInSeconds: Long = {
    older.birthDate.getMillis - younger.birthDate.getMillis
  }
}
