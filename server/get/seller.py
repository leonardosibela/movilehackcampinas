import requests
from flask import jsonify

class Seller:

    def get_balances(self, marketplace_id="3249465a7753536b62545a6a684b0000", seller_id="02f1add4edad4802bbb8afa1518224e9"):
        api_base = "https://api.zoop.ws/v1/"
        url = f"{api_base}marketplaces/{marketplace_id}/sellers/{seller_id}/balances"
        headers = { 'Authorization': "Basic enBrX3Rlc3Rfb2dtaTNUSm5WMzNVRGxqZE40bjhhUml0Og==" }
        response = requests.request("GET", url, data="", headers=headers)

        return response.json()