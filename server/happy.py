import os
from get.seller import Seller
from flask import Flask, jsonify, request
import json

# internal imports
from post.login import login

app = Flask(__name__)


@app.route('/')
def home():
    return jsonify({
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


# login post request
@app.route('/users/new', methods=['POST'])
def login_post():
    payload = json.loads(request.data)
    if (payload.get('first_name') and
            payload.get('last_name') and payload.get('taxpayer_id')):
        return jsonify(login(json.dumps(payload)).json())
    return jsonify({'status': 400})


@app.route('/getUser/<userId>')
def getUserById(userId):
    return jsonify({
        "id": 0,
    })

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port=port)
