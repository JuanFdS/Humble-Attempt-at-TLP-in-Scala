package tlp.booleans
import Boolean._
import org.scalatest._
import scala.reflect.runtime.universe._

class BooleansTest extends FlatSpec with Matchers {

  def areSameType[TypeA, TypeB](implicit typeA: WeakTypeTag[TypeA], typeB: WeakTypeTag[TypeB]) =
    typeA.tpe =:= typeB.tpe

  "True and False" should "not be of the same type" in {
    areSameType[True, False] shouldBe false
  }

  "True and True" should "be the same type" in {
    areSameType[True, True] shouldBe true
  }

  "False and False" should "be the same type" in {
    areSameType[True, True] shouldBe true
  }

  "False and the Not type on True" should "be the same type" in {
    areSameType[True#Not, False] shouldBe true
  }

  "True and the Not type on False" should "be the same type" in {
    areSameType[False#Not, True] shouldBe true
  }

  "True and the Not type on True" should "not be the same type" in {
    areSameType[True#Not, True] shouldBe false
  }

  "False and the Not type on False" should "not be the same type" in {
    areSameType[False#Not, False] shouldBe false
  }

  type IntOrString[Container[_ <: C, _ <: C, C]] = Container[Int, String, Any]

  "int or string" should "be int if true" in {
    areSameType[IntOrString[True#If],Int] shouldBe true
  }
  
  "int or string" should "be string if false" in {
    areSameType[IntOrString[False#If],String] shouldBe true
  }
  
  "int or string" should "be different for false and true" in {
    areSameType[IntOrString[True#If],IntOrString[False#If]] shouldBe false
  }

}