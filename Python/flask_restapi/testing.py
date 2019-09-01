# -*- coding: utf-8 -*-
"""
Created on Sun Sep  1 14:46:37 2019

@author: sarah
"""

from flask import Flask, jsonify
app = Flask(__name__)

#this annotation converts this method into url endpoint 
@app.route("/")
def hello():
    return jsonify({"about" : "Hello"})

if __name__ == '__main__':
    app.run(debug=True)