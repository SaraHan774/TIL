# -*- coding: utf-8 -*-
"""
Created on Sun Sep  1 15:00:23 2019

@author: sarah
"""

from flask import Flask, jsonify, request

app = Flask(__name__)

@app.route('/', methods = ['GET', 'POST'])
def index():
    if(request.method == 'POST'):
        some_json = request.get_json()
        return jsonify({'you_sent' : some_json}), 201
    else:
        #default request will be 'GET'
        return jsonify({"about" : "Hello World !"})
    
@app.route('/multi/<int:num>', methods=['GET'])
def get_multiply10(num):
    return jsonify({'result' : num*10})

if __name__ == '__main__':
    app.run()
    
    