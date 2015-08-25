package org.jamieallen.akka.streams

import akka.actor.ActorSystem
import akka.stream.ActorFlowMaterializer
import akka.stream.io.SynchronousFileSource
import akka.stream.scaladsl.{Source, Sink}
import akka.stream.scaladsl.Flow

object FileIODemo extends App{
  implicit val sys = ActorSystem("file-io")
  implicit val mat = ActorFlowMaterializer()

  import java.io.File
  val myFile = new File("/Users/jamie/Desktop/todo")
  val source = SynchronousFileSource.create(myFile, 10)
  val printingSink = Sink.foreach(println)
  source.runWith(printingSink, mat) 
}
