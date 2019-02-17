import os
from get.seller import Seller
from flask import Flask, jsonify, request

app = Flask(__name__)

@app.route('/')
def home():
    return jsonify(
    {
        "id": 0,
    })

@app.route('/seller/balances')
def balances():
    seller = Seller()
    response = seller.get_balances()
    if response.get('items'):
        items = response.get('items')
        current = items.get('current_balance')
        account = items.get('account_balance')
        return jsonify({
            "current_balance": current,
            "account_balance": account
        })
    return 'Tes'

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port=port)