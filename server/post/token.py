import requests
from flask import jsonify

class Token:

    api_base = "https://api.zoop.ws/v1/"
    headers = { 'Authorization': "Basic enBrX3Rlc3Rfb2dtaTNUSm5WMzNVRGxqZE40bjhhUml0Og==" }
    marketplace_id = "3249465a7753536b62545a6a684b0000"
    marketplaces = f"{api_base}marketplaces/{marketplace_id}"

    def register_token_to_buyer(self, token):

        if not token:
            token = {
                "holder_name":"ZOOP SQUAD QA FACA NA CAVEIRA",
                "expiration_month": "09",
                "expiration_year": "2020",
                "security_code": "654",
                "card_number": "4929256328394091"
            }
        
        url = f"{self.marketplaces}/cards/tokens"
        response = requests.request("POST", url, data=token, headers=self.headers)
        response = response.json()

        return response