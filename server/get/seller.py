import requests
from flask import jsonify

class Seller:

    api_base = "https://api.zoop.ws/v1/"
    headers = { 'Authorization': "Basic enBrX3Rlc3Rfb2dtaTNUSm5WMzNVRGxqZE40bjhhUml0Og==" }
    marketplace_id = "3249465a7753536b62545a6a684b0000"
    url_marketplaces = f"{api_base}marketplaces/{marketplace_id}"
    ur_sellers = f"{api_base}marketplaces/{marketplace_id}/sellers"

    def get_balances(self, seller_id=None):
        
        if seller_id is None:
            seller_id = "02f1add4edad4802bbb8afa1518224e9"

        url = f"{self.ur_sellers}/{seller_id}/balances"
        response = requests.request("GET", url, data="", headers=self.headers)
        response = response.json()
        current = 0
        account = 0

        if response.get('items'):
            items = response.get('items')
            current = items.get('current_balance')
            account = items.get('account_balance')

        return jsonify({
            "current_balance": current,
            "account_balance": account
        })

    def get_seller_by_document(self, document=None):

        if document is None:
            document = "13386205763"

        url = f"{self.ur_sellers}/search?taxpayer_id={document}"
        response = requests.request("GET", url, data="", headers=self.headers)

        return jsonify(response.json())

    def get_seller_by_id(self, id):

        url = f"{self.ur_sellers}/{id}"
        response = requests.request("GET", url, data="", headers=self.headers)

        return jsonify(response.json())

    def add_seller_individuals(self, seller):

        if seller is None:
            seller = jsonify({
                "first_name": "Renan",
                "last_name": "Vieira Chagas",
                "email": "renanvieira@live.com",
                "phone_number": "+5521994629098",
                "ssn_last4_digits": "5763",
                "birthdate": "1990-11-21",
                "taxpayer_id": "13386205763"
            })

        url = f"{self.ur_sellers}/individuals"
        response = requests.request("POST", url, data=seller, headers=self.headers)

        print(response)

        return "TESTE"
