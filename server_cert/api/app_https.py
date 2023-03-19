import os
import ssl
from flask import Flask, jsonify

app = Flask(__name__)


@app.route('/index')
def index():
    return jsonify({"code": 1000, 'message': "success"})


if __name__ == '__main__':
    server_cer = os.path.join("server", "server-cert.cer")
    server_key = os.path.join("server", "server-key.key")
    client_cer = os.path.join("client", "client-cert.cer")
    # 创建ssl上下文
    ssl_context = ssl.SSLContext(protocol=ssl.PROTOCOL_TLSv1_2)
    # 选择认证模式：作为服务端，此选项为服务端必须校验客户端的证书，双向认证
    ssl_context.verify_mode = ssl.CERT_REQUIRED
    ssl_context.load_verify_locations(client_cer)
    ssl_context.load_cert_chain(certfile=server_cer, keyfile=server_key)

    # http://192.168.1.1:80
    # https://192.168.1.1:443
    app.run(host="0.0.0.0", port=443, ssl_context=ssl_context)
