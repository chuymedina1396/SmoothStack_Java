import random
from flask import Flask, request, make_response # include the flask library 
from flask import render_template

app = Flask(__name__) 

@app.route("/") 
def index(): 
    random_number = random.randint(1, 1000)
    context={
        "name": "Jesus Medina",
        "id": random_number,
        "cookie": request.cookies.get('userID')
    }
    return render_template("index.html", context=context)

@app.route("/home") 
def home():
    random_number = random.randint(1, 1000)
    context={
        "name": "Jesus Medina",
        "id": random_number
    }
    return render_template("form.html", context=context)

@app.route('/setcookie', methods = ['POST', 'GET'])
def setcookie():
   if request.method == 'POST':
       user = request.form['nm']
       resp = make_response(render_template('form.html'))
       resp.set_cookie('userID', user)
   return resp

@app.route('/getcookie')
def getcookie():
   name = request.cookies.get('userID')
   return '<h1>welcome ' + name + '</h1>'


# print("Hello there")
# input("What role are you?")
# options = [ "Adminstrator", "Customer", "Agent"]
# for option in options:
#     print(option)

if __name__ == '__main__': 
   app.run(port=5000, debug=True)
