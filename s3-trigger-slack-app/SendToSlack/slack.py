import json
import urllib.parse
import boto3
from botocore.vendored import requests

def sent_slack_message(data):
    JSON_HEADER = {'Content-Type': 'application/json'}
    url = AddUrlHook
    
    response = requests.post(url, data=json.dumps(data), headers=JSON_HEADER)
    
    return response
