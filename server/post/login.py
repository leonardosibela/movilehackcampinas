import requests
import json
from flask import jsonify
from keys import *

url = baseUrl+'/v1/marketplaces/'+marketPlaceId+'/buyers'

headers = {
    'Content-Type': "application/json",
    'Authorization': autorizationKey,
    'cache-control': "no-cache",
}


def login(payload):
    return requests.request(
        "POST", url,
        data=payload,
        headers=headers)