package edu.learn.webflux.ws

import edu.learn.webflux.beans.Event
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.SynchronousSink
import java.time.Duration
import java.util.*
import java.util.stream.Stream

@RestController
@RequestMapping( "/api")
class ReactiveService {

    @GetMapping(path = ["/event/{id}"], produces = ["application/json"])
    fun getEventById(@PathVariable id: Long) : Mono<Event> {
        val event = Event(id,Date())
        println(event)
        return Mono.just(event)
    }

    @GetMapping(path = ["/events"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getAllEvents() : Flux<Event> {
        val eventFlux = Flux.fromStream(Stream.generate { Event(System.currentTimeMillis(), Date()) })
        val durationFlux = Flux.interval(Duration.ofSeconds(1))
        return Flux.zip(eventFlux, durationFlux).map { it -> it.t1 }
    }

    @GetMapping(path = ["/events1"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun events(id: String) = Flux
            .generate({ sink: SynchronousSink<Event> -> sink.next(Event(System.currentTimeMillis(), Date())) })
            .delayElements(Duration.ofSeconds(1L))
}
