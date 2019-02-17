import requests
import json
import sys
from flask import jsonify
from keys import *

with open("./data/bills.json", "r") as read_file:
    bills = json.load(read_file)

with open("./data/bills_user.json", "r") as read_file:
    bills_user = json.load(read_file)

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

def get_user_by_id(id):
    if (id == '5d1b6cd746c348fbabb46ad728bafabf'):
        return bills
    
    return bills_user