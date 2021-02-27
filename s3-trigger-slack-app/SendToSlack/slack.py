import json
import urllib.parse
import boto3
from botocore.vendored import requests

def sent_slack_message(data):
    JSON_HEADER = {'Content-Type': 'application/json'}
    url = "https://hooks.slack.com/services/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"
    
    response = requests.post(url, data=json.dumps(data), headers=JSON_HEADER)
    
    return response
