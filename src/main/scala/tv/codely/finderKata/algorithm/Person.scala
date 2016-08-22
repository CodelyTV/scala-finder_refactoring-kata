package tv.codely.finderKata.algorithm

import com.github.nscala_time.time.Imports._

final case class PersonName(rawName: String) {
  require(!rawName.isEmpty, "Person name can't be empty.")
  require(!rawName.forall(_.isDigit), "Person name can't be all digits.")
}

final case class Person(name: PersonName, birthDate: DateTime) extends Ordered[Person] {
  override def compare(candidate: Person): Int = birthDate.compare(candidate.birthDate)
}
