package org.jamieallen.akka.streams

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.OneForOneStrategy
import akka.dispatch.sysmsg.Resume
import akka.actor.SupervisorStrategy
import akka.actor.SupervisorStrategy.Stop
import akka.actor.Props
import scala.concurrent.duration._

object TestSupervision extends App {
  val system = ActorSystem()
  system.actorOf(Props[MySupervisor])
  system.awaitTermination()
}

case object MyMessage
case object BlowUp

class MySupervisor extends Actor {
  override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy() {
    case _: NullPointerException => Stop
  }
  
  val child = context.actorOf(Props[MyChild])
  
  def receive = {
    case _ => 
  }
  
  import context.dispatcher
  context.system.scheduler.schedule(1 second, 1 second, child, MyMessage)
  context.system.scheduler.scheduleOnce(5 second, child, BlowUp)
}

class MyChild extends Actor {
  
  def receive = {
    case MyMessage => 
      println("got message!")
    case BlowUp =>
      throw new ClassCastException
  }
}