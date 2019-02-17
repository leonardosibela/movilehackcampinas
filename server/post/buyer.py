import requests
from flask import jsonify

class Buyer:

    api_base = "https://api.zoop.ws/v1/"
    headers = { 'Authorization': "Basic enBrX3Rlc3Rfb2dtaTNUSm5WMzNVRGxqZE40bjhhUml0Og==" }
    marketplace_id = "3249465a7753536b62545a6a684b0000"
    marketplaces = f"{api_base}marketplaces/{marketplace_id}"

    def register_token_to_buyer(self, user, card):
        print(card.get('id'))
        data = {
            "token": card.get('id'),
            "custome": user
        }
        url = f"{self.marketplaces}/cards"
        response = requests.request("POST", url, data=data, headers=self.headers)
        response = response.json()

        return jsonify(response)