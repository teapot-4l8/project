from flask import Flask, request, jsonify
import uuid

app = Flask(__name__)


@app.route('/', methods=['GET', 'POST'])
def auth():
    # 获取数据
    print(request.data)  # 原始格式
    # print(request.json)
    # print(request.form)
    # username = request.form.get('user')
    # password = request.form.get('pwd')
    # sign = request.form.get('sign')
    # print(username, password, sign)
    print(request.headers)
    return jsonify({'code':200, 'data':'success', 'token':uuid.uuid4()})

# http://10.115.156.92:5000/api/v1/post
@app.route('/api/v1/post', methods=['POST'])
def v1():
    print(request.data)
    return jsonify({'code': 200, 'data': 'success', 'token': uuid.uuid4()})


if __name__ == '__main__':
    # 电脑的IP
    app.run(host='0.0.0.0')
