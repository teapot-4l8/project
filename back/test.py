from flask import Flask, request, jsonify

app = Flask(__name__)


@app.route('/', methods=['GET', 'POST'])
def auth():
    username = request.form.get('user')
    password = request.form.get('pwd')
    sign = request.form.get('sign')
    print(username, password, sign)
    return "ok"


if __name__ == '__main__':
    # 电脑的IP
    app.run(host='0.0.0.0')
