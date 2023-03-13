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
    return jsonify({'code':200, 'data':'success', 'token':uuid.uuid4(), 'activity': 1, 'status': True})

# http://10.115.156.92:5000/api/v1/post
@app.route('/api/v1/post', methods=['POST'])
def v1():
    # TODO: 后端接收不到retrofit传的东西，抓包可以抓到
    print(request.data)
    return jsonify({'code': 200, 'data': 'success', 'token': uuid.uuid4(), 'activity': 2, 'status': True})


if __name__ == '__main__':
    # 电脑的IP
    app.run(host='0.0.0.0')
