package org.jamieallen.akka.streams;


/**
 * @author Stephane Maldini
 *         Original credit and code Roland Kuhn:
 *         https://github.com/rkuhn/ReactiveStreamsInterop
 *         /blob/master/src/main/java/com/rolandkuhn/rsinterop/JavaMain.java
 */
public class AkkaStreamsJavaDemo {
//
//	static public void main(String... args) throws Exception {
//    final ActorSystem system = ActorSystem.create("InteropTest");
//    final FlowMaterializer mat = ActorFlowMaterializer.create(system);
//    Environment.initialize().assignErrorJournal();
//
//    final int chunks = 20;
//
//    // RxJava Observable
//    final Observable<Integer> intObs = Observable.range(1, chunks);
//
//    // Reactive Streams Publisher
//    final Publisher<Integer> intPub = RxReactiveStreams.toPublisher(intObs);
//
//    // Akka Streams Source
//    final Source<String, BoxedUnit> stringSource = Source
//        .from(intPub)
//        .map(Object::toString)
//        .scan("", (prev, next) -> prev+next);
//
//    // Reactive Streams Publisher
//    final Publisher<String> stringPub = stringSource.runWith(Sink.fanoutPublisher(1, 1), mat);
//
//    // Reactor Stream starting with START on the subscriber thread, then emits Akka Source with some log
//    final Stream<String> linesStream = Streams
//        .wrap(stringPub)
//        .log("reactor.map")
//        .map(i -> i + "!");
//
//
//    //A Ratpack http server
//    RatpackServer server = RatpackServer.of(spec -> spec
//            .handlers(chain -> chain
//                    .get(":name", ctx ->
//                            // and now render the HTTP response
//                            ctx.render(ResponseChunks.stringChunks(ctx.stream(linesStream)))
//                    )
//            )
//    );
//
//    server.start();
//
//
//    //A Reactor http client
//    HttpClient<String, String> client = NetStreams.httpClient(conf ->
//            conf.connect("localhost", 5050).codec(new StringCodec())
//    );
//
//    //Fire a get request that will only ping "anchorMan"
//    Promise<List<String>> result = client.get("/anchorMan")
//            //flatten the chunked results amd aggregate into a single List "Promise"
//            .flatMap(replies ->
//                    replies
//                    .log("reactor.replies")
//                    .toList()
//            );
//
//    //Subscribe result with RxJava ReactiveStreams bridge
//    RxReactiveStreams
//        .toObservable(result)
//        .flatMap(Observable::from)
//        .toBlocking()
//        .forEach(System.out::println);
//
//    //shutdown server
//    server.stop();
//
//    //shutdown actors
//    system.shutdown();
//  }
}
