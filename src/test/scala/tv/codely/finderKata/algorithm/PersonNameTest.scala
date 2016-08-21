package tv.codely.finderKata.algorithm

import org.scalatest.Matchers._
import org.scalatest.WordSpec

class PersonNameTest extends WordSpec {

  "PersonName" should {
    "not allow empty names" in {
      an [IllegalArgumentException] should be thrownBy PersonName("")
    }

    "not allow names containing only digits" in {
      an [IllegalArgumentException] should be thrownBy PersonName("123")
    }
  }
}
