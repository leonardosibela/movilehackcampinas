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

bills = [
    {
        'groupId': "1237468",
        'fisrt_name': "Aluguel",
        "created_at": "2019-02-17T07:24:07+00:00",
        'proratedvalues': [
            {
                'id': "97a5205a62ae4d2f9bd13e19a0349b7b",
                "user": {
                    "id": "97a5205a62ae4d2f9bd13e19a0349b7b",
                    "status": "active",
                    "resource": "buyer",
                    "account_balance": "0.00",
                    "current_balance": "0.00",
                    "first_name": "Joaquim",
                    "last_name": "Mariano",
                    "taxpayer_id": "80811217060",
                    "description": "Morador Rep Campinas",
                    "email": "joaquimamariano@gmail.com"
                },
                "value": 500,
                "paid": False
            }
        ]
    }
]


def login(payload):
    return requests.request(
        "POST", url,
        data=payload,
        headers=headers)

def get_user_by_id(id):
    if (id == '5d1b6cd746c348fbabb46ad728bafabf'):
        return bills
    
    return []