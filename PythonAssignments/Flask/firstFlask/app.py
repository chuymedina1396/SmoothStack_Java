# File name: hello_webapp.py 
from flask import Flask # include the flask library 
from flask import render_template

app = Flask(__name__) 

@app.route("/") 
def index(): 
   return "Hello, World!!" 

@app.route("/home") 
def home():
   context={
      "name": "Jesus Medina"
   }
   return render_template("index.html", context=context)

print("Hello there")

if __name__ == '__main__': 
   app.run(port=5000, debug=True)