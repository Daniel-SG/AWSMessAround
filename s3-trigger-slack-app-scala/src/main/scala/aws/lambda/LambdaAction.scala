package aws.lambda

import java.util.Calendar

import com.amazonaws.services.lambda.runtime.events.S3Event
import net.liftweb.json._
import net.liftweb.json.Serialization.write

object LambdaAction extends App{


  def getInfoBucket(event: S3Event): Int = {

    val bucketName = event.getRecords.get(0).getS3.getBucket.getName
    val fileName = event.getRecords.get(0).getS3.getObject.getKey
    val currentDate = Calendar.getInstance().getTime()

    case class Data(text: String)

    val d = Data(fileName +" - "+bucketName+" -> "+"Lambda using Scala :O")
    // create a JSON string from the Person, then print it
    implicit val formats = DefaultFormats
    val jsonString = write(d)

    slack.sent_slack_message(jsonString)

  }
}
