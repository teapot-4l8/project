from flask import Flask, jsonify

app = Flask(__name__)


@app.route('/index')
def index():
    return jsonify({"code": 1000, 'message': "success"})


if __name__ == '__main__':
    app.run()
