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

@app.route('/seller', methods=['POST', 'GET'])
def seller():
    document = request.args.get('taxpayer_id')
    print(document)
    return modelSeller.get_seller_by_document(document)

@app.route('/seller/<path:subpath>')
def balances(subpath):
    return modelSeller.get_balances()

# login post requesr
@app.route('/login', methods=['POST'])
def login_post():
    payload = json.loads(request.data)
    if (payload.get('first_name') and
            payload.get('last_name') and payload.get('taxpayer_id')):
        return jsonify(login(json.dumps(payload)).json())
    return jsonify({'status': 400})


if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port=port)
