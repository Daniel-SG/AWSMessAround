import json

import requests
import urllib.parse
import boto3

import datetime
import slack
s3 = boto3.client('s3')

def lambda_handler(event, context):
    #print("Received event: " + json.dumps(event, indent=2))
    
    # Get the object from the event and show its content type
    bucketName = event['Records'][0]['s3']['bucket']['name']
    fileName = urllib.parse.unquote_plus(event['Records'][0]['s3']['object']['key'], encoding='utf-8')
    currentDate = datetime.datetime.now()
    
    try:
       
        print("File added ->: " + event['Records'][0]['s3']['object']['key'])
        data = {'text': fileName+ " added in " +bucketName +"-> " +str(currentDate) } 
        
        #Sent Slack message
        response = slack.sent_slack_message(data)
      
        
        return response.status_code
        
    except Exception as e:
        print(e)
        print('Error getting object {} from bucket {}. Make sure they exist and your bucket is in the same region as this function.'.format(key, bucket))
        raise e

    

    
