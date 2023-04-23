import time
import requests
import hashlib
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
from urllib.parse import quote_plus
import base64
import json
import random


def create_android_id():
    data_list = []
    for i in range(1, 9):
        part = "".join(random.sample("0123456789ABCDEF", 2))
        data_list.append(part)
    return "".join(data_list).lower()


def md5(data_bytes):
    hash_object = hashlib.md5()
    hash_object.update(data_bytes)
    return hash_object.hexdigest()


def aes_encrypt(data_string):
    key = "d245a0ba8d678a61"
    aes = AES.new(
        key=key.encode('utf-8'),
        mode=AES.MODE_ECB,
    )
    raw = pad(data_string.encode('utf-8'), 16)
    return aes.encrypt(raw)


uid = create_android_id()
ctime = str(int(time.time() * 1000))

# param_dict = {"loginToken": "", "platform": "android", "timestamp": ctime, "uuid": uid, "v": "4.84.0"}
param_dict = {"loginToken": "", "platform": "android", "timestamp": ctime, "uuid": uid, "v": "5.0.6"}

ordered_string = "".join(["{}{}".format(key, param_dict[key]) for key in sorted(param_dict.keys())])
# ordered_string = "loginTokenplatformandroidtimestamp1682251969586uuid64a3204904436ea9v5.0.6"
aes_byte = aes_encrypt(ordered_string)
# print(aes_byte)
aes_string = base64.encodebytes(aes_byte)
# print("b64", aes_string)
aes_string = aes_string.replace(b"\n", b"")
# print(aes_string)
sign = md5(aes_string)
param_dict['newSign'] = sign
# print(sign)
res = requests.post(
    url="https://app.dewu.com/api/v1/app/user_core/users/getVisitorUserId",
    headers={
        "duuuid": uid,
        # "duimei": "",
        "duplatform": "android",
        "appId": "duapp",
        # "duchannel": "pp",
        # "humeChannel": "",
        # "duv": "4.84.0",
        "duv": "5.0.6",
        "duloginToken": "",
        # "dudeviceTrait": "MI+6+Plus",
        # "dudeviceBrand": "Xiaomi",
        "timestamp": ctime,
        "shumeiid": "20210807163758afabf6d66401eb2e4f234dbe68af5705014c79067d50b114",  # 随便改 但必须有
        # "oaid": "",
        # "User-Agent": "duapp/5.0.6(android;6.0.1)",
        # "X-Auth-Token": "",
        # "isRoot": "0",
        # "emu": "1",
        # "isProxy": "0",
        "Content-Type": "application/json; charset=utf-8"
    },
    json=param_dict,
    # verify=False
)

print(res.text)
x_auth_token = res.headers['X-Auth-Token']


reply_param_dict = {
    # "contentId": "83662484",
    "contentId": "91820099",
    "contentType": "0",
    "anchorReplyId": "0",
    "lastId": "",
    "source": "",
    "limit": "5",
    # "newSign": "teydhdfghsrhr"
    # "newSign": "80c378ba571fd250385a4a9d5cb120b6"
}

import copy

new_dict = copy.deepcopy(reply_param_dict)
new_dict.update(
    # {"loginToken": "", "platform": "android", "timestamp": str(int(time.time() * 1000)), "uuid": uid, "v": "4.84.0"})
    {"loginToken": "", "platform": "android", "timestamp": str(int(time.time() * 1000)), "uuid": uid, "v": "5.0.6"})
ordered_string = "".join(["{}{}".format(key, new_dict[key]) for key in sorted(new_dict.keys())])

aes_string = aes_encrypt(ordered_string)
aes_string = base64.encodebytes(aes_string)
aes_string = aes_string.replace(b"\n", b"")
sign_string = md5(aes_string)
reply_param_dict['newSign'] = sign_string

res = requests.get(
    url="https://app.dewu.com/sns-itr/v1/reply/content-reply-list",
    params=reply_param_dict,
    headers={
        "X-Auth-Token": x_auth_token,
        "User-Agent": "duapp/5.0.6(android;10)"
    },
    # verify=False
)
print(res.text)