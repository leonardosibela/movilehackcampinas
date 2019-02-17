import os
from get.seller import Seller
from flask import Flask, jsonify, request
import json

# internal imports
from post.login import login

app = Flask(__name__)
modelSeller = Seller()


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


@app.route('/getUser/<userId>')
def getUserById(userId):
    return jsonify({
        "id": 0,
    })

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port=port)
