package com.yourtion.Pattern21

import scala.collection.JavaConverters._
import scala.io.Source

/**
  * Created by Yourtion on 07/04/2017.
  */

object ExtendedExample {
  case class CommandResult(status: Int, output: String, error: String)

  class Command(commandParts: List[String]) {
    def run = {
      val processBuilder = new ProcessBuilder(commandParts.asJava)
      val process = processBuilder.start()
      val status = process.waitFor()
      val outputAsString = Source.fromInputStream(process.getInputStream()).mkString("")
      val errorAsString = Source.fromInputStream(process.getErrorStream()).mkString("")
      CommandResult(status, outputAsString, errorAsString)
    }

  }

  implicit class CommandVector(existingCommands: Vector[String]) {
    def run = {
      val pipedCommands = existingCommands.mkString(" | ")
      Command("/bin/sh", "-c", pipedCommands).run
    }
    def pipe(nextCommand: String): Vector[String] = {
      existingCommands :+ nextCommand
    }
  }
  object Command {
    def apply(commandString: String) = new Command(commandString.split("\\s").toList)
    def apply(commandParts: String*) = new Command(commandParts.toList)
  }

  implicit class CommandString(firstCommandString: String) {
    def run = Command(firstCommandString).run
    def pipe(secondCommandString: String) =
      Vector(firstCommandString, secondCommandString)
  }

  def run(): Unit = {
    println("Command Extended :")
    println("ls -al" pipe "grep ." pipe "wc" run)
  }
}

object DSLExample {
  case class CommandResult(status: Int, output: String, error: String)

  class Command(commandParts: List[String]) {
    def run() = {
      val processBuilder = new ProcessBuilder(commandParts.asJava)
      val process = processBuilder.start()
      val status = process.waitFor()
      val outputAsString =
        Source.fromInputStream(process.getInputStream()).mkString("")
      val errorAsString =
        Source.fromInputStream(process.getErrorStream()).mkString("")
      CommandResult(status, outputAsString, errorAsString)
    }
  }

  object Command {
    def apply(commandString: String) = new Command(commandString.split("\\s").toList)
  }

  implicit class CommandString(commandString: String) {
    def run() = Command(commandString).run
  }

  def run(): Unit = {
    println("Command ls :")
    println(Command("ls -al").run())
    println()
    println("Command ls as String :")
    println("ls -al" run)

    ExtendedExample.run()
  }
}
