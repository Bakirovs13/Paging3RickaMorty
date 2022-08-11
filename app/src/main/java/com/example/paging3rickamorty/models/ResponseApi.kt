package com.example.paging3rickamorty.models

data class ResponseApi(
    val info: Info = Info(),
    val results: List<Result> = listOf()
) {
    data class Info(
        val count: Int = 0,
        val next: String = "",
        val pages: Int = 0,
        val prev: Any = Any()
    )

    data class Result(
        val created: String = "",
        val episode: List<String> = listOf(),
        val gender: String = "",
        val id: Int = 0,
        val image: String = "",
        val location: Location = Location(),
        val name: String = "",
        val origin: Origin = Origin(),
        val species: String = "",
        val status: String = "",
        val type: String = "",
        val url: String = ""
    ) {
        data class Location(
            val name: String = "",
            val url: String = ""
        )

        data class Origin(
            val name: String = "",
            val url: String = ""
        )
    }
}