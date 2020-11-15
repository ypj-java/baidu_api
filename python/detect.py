# -*- coding: utf-8 -*-

def getToken():
    ak = '官方获取的ak'
    sk = '官方获取的sk'
    host = f'https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id={ak}&client_secret={sk}'
    response = requests.get(host)
    return response.json().get("access_token")

def img_to_base64(file_path):
    with open(file_path, 'rb') as f:
        base_64_data = base64.b64encode(f.read())
        s = base_64_data.decode()
        return s

def FaceDetect(token_, base_64_data):
    params = {}
    request_url = "https://aip.baidubce.com/rest/2.0/face/v3/detect"
    params["image"] = base_64_data
    params["image_type"] = "BASE64"
    params["face_field"] = "age,beauty"
    access_token = token_
    request_url = request_url + "?access_token=" + access_token
    headers = {'content-type': 'application/json'}
    response = requests.post(request_url, data=params, headers=headers)
    if response:
        print(response.json())
        print(response.json()["result"]["face_list"][0]["age"])
        print(response.json()["result"]["face_list"][0]["beauty"])


import requests
import base64
import json
if __name__ == "__main__":
    base_64 = img_to_base64("zhangsan.jpg")
    token  = getToken()
    FaceDetect(token, base_64)
