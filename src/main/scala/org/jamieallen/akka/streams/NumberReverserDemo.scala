package org.jamieallen.akka.streams

import akka.actor.ActorSystem
import akka.stream.ActorFlowMaterializer
import akka.stream.scaladsl.{Source, Sink, Flow}

object NumberReverserDemo extends App{
  implicit val sys = ActorSystem("file-io")
  implicit val mat = ActorFlowMaterializer()

  val printingSink = Sink.foreach(println)
  val numberReverserFlow: Flow[Int, String, Unit] = 
    Flow[Int].map(reverseDigit)
    
  Source(100 to 200).via(numberReverserFlow).to(printingSink).run()

  def reverseDigit(myInt: Int) = myInt.toString.reverse
}
