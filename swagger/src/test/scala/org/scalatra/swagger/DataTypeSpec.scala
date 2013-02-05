package org.scalatra
package swagger

import org.specs2.mutable.Specification

case class Person(id: Int, name: String)
class DataTypeSpec extends Specification {

  "DataType.apply[T]" should {

    "return a correct unit datatype" in {
      DataType[Unit] must_== DataType.Void
    }
    "return a correct string datatype" in {
      DataType[String] must_== DataType.String
      DataType[java.lang.String] must_== DataType.String
    }
    "return a correct Int datatype" in {
      DataType[java.lang.Integer] must_== DataType.Int
      DataType[Int] must_== DataType.Int
      DataType[java.lang.Short] must_== DataType.Int
      DataType[Short] must_== DataType.Int
      DataType[BigInt] must_== DataType.Int
      DataType[java.math.BigInteger] must_== DataType.Int
    }

    "return correct Long datatype" in {
      DataType[java.lang.Long] must_== DataType.Long
      DataType[Long] must_== DataType.Long
    }

    "return correct Byte datatype" in {
      DataType[java.lang.Byte] must_== DataType("byte")
      DataType[Byte] must_== DataType("byte")
    }

    "return a correct Decimal datatype" in {
      val dd = DataType("double")
      DataType[java.lang.Double] must_== dd
      DataType[Double] must_== dd
      DataType[BigDecimal] must_== dd
      DataType[java.math.BigDecimal] must_== dd
    }

    "return a correct Decimal datatype" in {
      val dd = DataType("float")
      DataType[java.lang.Float] must_== dd
      DataType[Float] must_== dd
    }

    "return a correct Date datatype" in {
      DataType[java.util.Date] must_== DataType.Date
      DataType[org.joda.time.DateTime] must_== DataType.Date
    }

    "return a correct Boolean datatype" in {
      DataType[Boolean] must_== DataType.Boolean
      DataType[java.lang.Boolean] must_== DataType.Boolean
    }

    "return a correct Map datatype" in {
      DataType[Map[String, String]] must_== DataType.GenMap(DataType.String, DataType.String)
    }

    "return a correct Collection datatype" in {
      DataType[Traversable[String]] must_== DataType.GenList(DataType.String)
      DataType[java.util.List[String]] must_== DataType.GenList(DataType.String)
      DataType[collection.immutable.Seq[String]] must_== DataType.GenList(DataType.String)
      DataType[collection.immutable.List[String]] must_== DataType.GenList(DataType.String)
      DataType[collection.immutable.Set[String]] must_== DataType.GenList(DataType.String)
      DataType[collection.mutable.Seq[String]] must_== DataType.GenList(DataType.String)
      DataType[collection.mutable.Buffer[String]] must_== DataType.GenList(DataType.String)
      DataType[collection.mutable.ListBuffer[String]] must_== DataType.GenList(DataType.String)
      DataType[collection.mutable.Set[String]] must_== DataType.GenList(DataType.String)
    }

    "return a correct model datatype" in {
      DataType[Person] must_== DataType("Person")
    }

  }
}