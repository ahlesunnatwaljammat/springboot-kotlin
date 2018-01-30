package edu.learn.config

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class GenericExceptionMapper : ExceptionMapper<Throwable> {
    override fun toResponse(exception: Throwable): Response {
        val error = "MyCustomException - " + exception.message
        return Response.serverError().entity(error).build()
    }
}
