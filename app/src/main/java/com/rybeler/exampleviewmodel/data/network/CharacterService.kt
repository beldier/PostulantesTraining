package com.rybeler.exampleviewmodel.data.network

import com.rybeler.exampleviewmodel.data.models.ApiResponse
import com.rybeler.exampleviewmodel.data.models.Character
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {


    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ApiResponse<Character>
}