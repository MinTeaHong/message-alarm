package com.salgam.alarm.slack

import com.salgam.com.salgam.alarm.slack.SlackAlarm
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class SlackTest {
  @Test
  fun 슬랙테스트() {

    val webhookUrl = System.getenv("WEBHOOK_URL")
    assertNotNull(webhookUrl)
    val slackAlarm = SlackAlarm(webhookUrl)
    slackAlarm.sendMessage("test")
  }
}