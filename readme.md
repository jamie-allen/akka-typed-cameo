# Using Akka Typed to implement the Cameo Pattern from Effective Akka

## Overview
In the Effective Akka book, I showed how to use ephemeral actors to represent a context or transaction that aggregated multiple external interactions and allowed the developer to create domain-specific behavior for it.  In this project, I am trying to implement the [Cameo Pattern](https://github.com/jamie-allen/effective_akka/blob/master/src/main/scala/org/jamieallen/effectiveakka/pattern/cameo/Cameo.scala) using the Akka Typed API, allowing for more assurance of correctness at compile time.

## What is Akka Typed?
[Akka Typed](http://doc.akka.io/docs/akka/2.4.0-RC1/scala/typed.html) is an effort to statically check actor message protocols at compile time by making sure an actor is capable of handling a specific type of message.  This ensures that a developer could never attempt to send a message that an actor could never receive, which is the case with the current Akka Actor implementation.

The one caveat is that there is no way to statically check **time**.  We can be certain that at least one of the receive blocks in the typed actor will handle the message, but we cannot be certain that the receive block that can handle it will be in effect at the time the message is received.  This is, in fact, a bummer.  However, Akka Typed represents such a huge step forward in statically checked correctness of actor interactions that I can totally live with this.

## Note
The Akka Typed project is experimental and in its infancy.  Changes are likely to come quickly as more is learned from trying out this project.

## Mad Props
To [Roland Kuhn](https://github.com/rkuhn) for devising how to statically type check actor message interactions.