package tv.codely.finderKata.algorithm

import com.github.nscala_time.time.Imports._

class Thing {

  var name: String = _

  var birthDate: DateTime = _

  def getName(): String = name

  def setName(name: String) {
    this.name = name
  }

  def getBirthDate(): DateTime = birthDate

  def setBirthDate(birthDate: DateTime) {
    this.birthDate = birthDate
  }
}
