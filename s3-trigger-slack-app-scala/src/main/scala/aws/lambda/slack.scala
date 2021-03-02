package aws.lambda

import scalaj.http.{Http, HttpOptions}


object slack {

  def sent_slack_message(data: String):Int = {
    val url = "SlackHook"

    val result = Http(url).postData(data)
      .header("Content-Type", "application/json")
     // .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString
    result.code

  }

}
