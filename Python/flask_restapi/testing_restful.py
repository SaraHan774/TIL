# -*- coding: utf-8 -*-
"""
Created on Sun Sep  1 15:28:27 2019

@author: sarah
"""

from flask import Flask, request 
from flask_restful import Resource, Api
#Resource is the main building block of restful 

app = Flask(__name__)
api = Api(app)
#we now have an api that is build on top of the app 

class HelloWorld(Resource):
 #it is much cleaner than decorating with many 'route's
    def get(self):
        return {"about" : "Hello Restful"}
    
    def post(self):
        some_json = request.get_json()
        return {"you sent" : some_json}, 201
    

class Multi(Resource):
    def get(self, num):
        return {"result" : num*10}
    

api.add_resource(HelloWorld, '/') #bound it to the route '/'
api.add_resource(Multi, '/multi/<int:num>') 

if __name__ == '__main__':
    app.run()