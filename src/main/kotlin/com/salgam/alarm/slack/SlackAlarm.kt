package com.salgam.com.salgam.alarm.slack

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class SlackAlarm(private val webhookUrl: String) {


  fun sendMessage(message: String) {
    val jsonPayload = JSONObject()
    jsonPayload.put("text", message)

    // 요청 본문 생성
    val requestBody = jsonPayload.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

    // HTTP 클라이언트 생성
    val client = OkHttpClient()

    // 요청 생성
    val request = Request.Builder()
      .url(webhookUrl)
      .post(requestBody)
      .build()

    // 요청 실행
    client.newCall(request).execute().use { response ->
      if (!response.isSuccessful) throw IOException("Unexpected code $response")

      println("Message sent successfully: ${response.body?.string()}")
    }


  }
}