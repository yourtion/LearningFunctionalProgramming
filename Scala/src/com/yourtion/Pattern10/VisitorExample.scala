package com.yourtion.Pattern10

/**
  * Created by Yourtion on 29/03/2017.
  */
object VisitorExample {

  trait Person {
    def fullName: String
    def firstName: String
    def lastName: String
    def houseNum: Int
    def street: String
  }

  class SimplePerson(val firstName: String, val lastName: String,
                     val houseNum: Int, val street: String) extends Person {
    def fullName = firstName + " " + lastName
  }

  class ComplexPerson(name: Name, address: Address) extends Person {
    def fullName = name.firstName + " " + name.lastName

    def firstName = name.firstName
    def lastName = name.lastName
    def houseNum = address.houseNum
    def street = address.street
  }
  class Address(val houseNum: Int, val street: String)
  class Name(val firstName: String, val lastName: String)

  implicit class ExtendedPerson(person: Person) {
    def fullAddress = person.houseNum + " " + person.street
  }


  trait PerimeterShapes {
    trait Shape {
      def perimeter: Double
    }

    class Circle(radius: Double) extends Shape {
      def perimeter = 2 * Math.PI * radius
    }

    class Rectangle(width: Double, height: Double) extends Shape {
      def perimeter = 2 * width + 2 * height
    }
  }

  object FirstShapeExample extends PerimeterShapes {
    val aCircle = new Circle(4)
    val aRectangle = new Rectangle(2, 2)
  }

  trait AreaShapes extends PerimeterShapes {
    trait Shape extends super.Shape {
      def area: Double
    }

    class Circle(radius: Double) extends super.Circle(radius) with Shape {
      def area = Math.PI * radius * radius
    }

    class Rectangle(width: Double, height: Double)
      extends super.Rectangle(width, height) with Shape {
      def area = width * height
    }
  }

  object SecondShapeExample extends AreaShapes {
    val someShapes = Vector(new Circle(4), new Rectangle(2, 2))
  }

  trait MorePerimeterShapes extends PerimeterShapes {
    class Square(side: Double) extends Shape {
      def perimeter = 4 * side
    }
  }

  trait MoreAreaShapes extends AreaShapes with MorePerimeterShapes {
    class Square(side: Double) extends super.Square(side) with Shape {
      def area = side * side
    }
  }

  object ThirdShapeExample extends MoreAreaShapes {
    val someMoreShapes = Vector(new Circle(4), new Rectangle(2, 2), new Square(4))
  }

  def run(): Unit = {
    println("SimplePerson :")

    val simplePerson = new SimplePerson("Yourtion", "Guo", 123, "Fake. St.")
    println(simplePerson)
    println("FullName:" + simplePerson.fullName)
    println("FullAddress:" + simplePerson.fullAddress)
    println()

    println("ComplexPerson :")
    val name = new Name("yourtion", "guo")
    val address = new Address(456, "Fake2. St.")
    val complexPerson = new ComplexPerson(name, address)
    println("FullName:" + complexPerson.fullName)
    println("FullAddress:" + complexPerson.fullAddress)
    println()


    println("FirstShapeExample :")
    println(FirstShapeExample.aCircle.perimeter)
    println(FirstShapeExample.aRectangle.perimeter)
    println()

    println("SecondShapeExample :")
    println(for(shape <- SecondShapeExample.someShapes) yield shape.perimeter)
    println(for(shape <- SecondShapeExample.someShapes) yield shape.area)
    println()

    println("ThirdShapeExample :")
    println(for(shape <- ThirdShapeExample.someMoreShapes) yield shape.perimeter)
    println(for(shape <- ThirdShapeExample.someMoreShapes) yield shape.area)
    println()
  }

}
