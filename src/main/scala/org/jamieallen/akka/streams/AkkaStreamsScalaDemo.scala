package org.jamieallen.akka.streams

import akka.stream.ActorFlowMaterializer
import akka.actor.ActorSystem
import akka.stream.scaladsl.Sink
import akka.stream.scaladsl.Source

object AkkaStreamsScalaDemo extends App{
  implicit val sys = ActorSystem("scalar-sys")
  implicit val mat = ActorFlowMaterializer()

  Source(1 to 3).runWith(Sink.foreach(println))

  // sugar for runWith
  Source(1 to 3).runForeach(println)
  
  import java.io.File
  
}