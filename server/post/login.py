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

def get_user_by_id(id):
    user = ''
    if (id == '5d1b6cd746c348fbabb46ad728bafabf'):
        myurl = f"{url}/{id}"
        user = requests.request("GET", myurl, data="", headers=headers)
        user = user.json()
        user['proratedvalues'] = [
            {
                'id': "97a5205a62ae4d2f9bd13e19a0349b7b",
                "user": {
                    'id': "97a5205a62ae4d2f9bd13e19a0349b7b"
                },
                "value": 500,
                "paid": False
            }
        ]
    
    return user