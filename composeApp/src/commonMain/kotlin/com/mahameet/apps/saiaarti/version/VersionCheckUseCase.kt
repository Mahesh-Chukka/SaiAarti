package com.mahameet.apps.saiaarti.version

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class VersionCheckUseCase(
    private val client: HttpClient = createHttpClient()
) {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    suspend fun fetchVersionConfig(url: String): VersionConfig {
        val text = client.get(url).bodyAsText()
        return json.decodeFromString<VersionConfig>(text)
    }
}