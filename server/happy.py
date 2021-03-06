import os
from get.seller import Seller
from flask import Flask, jsonify, request
import json

# internal imports
from post.login import login, get_user_by_id

from post.token import Token
from post.buyer import Buyer

app = Flask(__name__)
modelSeller = Seller()
token = Token()
buyer = Buyer()

@app.route('/')
def home():
    return jsonify({
        "id": 0,
    })

@app.route('/seller', methods=['GET'])
def seller():
    document = request.args.get('taxpayer_id')
    return modelSeller.get_seller_by_document(document)

@app.route('/seller/<path:subpath>', methods=['GET'])
def balances(subpath):
    return modelSeller.get_balances()

@app.route('/sellers/<id>', methods=['GET'])
def seller_id(id):
    return modelSeller.get_seller_by_id(id)

@app.route('/sellers/individuals', methods=['POST'])
def add_seller():
    seller = request.get_json()
    return modelSeller.add_seller_individuals(seller)


# login post request
@app.route('/users/new', methods=['POST'])
def login_post():
    payload = json.loads(request.data)
    if (payload.get('first_name') and
            payload.get('last_name') and payload.get('taxpayer_id')):
        return jsonify(login(json.dumps(payload)).json())
    return jsonify({'status': 400})


@app.route('/login/<userId>', methods=['GET'])
def getUserById(userId):
    return jsonify(get_user_by_id(userId))

@app.route('/cards/<userId>', methods=['POST'])
def registerToken(userId):
    payload = json.loads(request.data)
    card = token.register_token_to_buyer(payload)
    user = buyer.register_token_to_buyer(userId, card)
    return user

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 3000))
    app.run(host='0.0.0.0', port=port)
