package sample_mn_app_01

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Delete

import io.micronaut.http.annotation.QueryValue

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.MediaType
import io.micronaut.serde.annotation.Serdeable

@Controller("/hello")
class HelloWorld {
    @Get
    fun response(
        @QueryValue param1: String,
        param2: String,
        param3: String
    ) = "Hello World param1=$param1, param2=$param2, param3=$param3"

    @Put
    fun put_response() = "Hello World PUT"

    @Serdeable
    data class RequestBody(val name: String)

    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Post
    fun post_response(
        @Body body: RequestBody
    ) = "Hello World POST name=${body.name}"

    @Delete
    fun delete_response() = "Hello World DELETE"
}
