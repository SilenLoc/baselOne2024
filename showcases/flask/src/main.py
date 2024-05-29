from flask import Flask
app = Flask(__name__)

@app.route('/api/healthz')
def healthz():
    return 'Hello'


if __name__ == '__main__':
    app.run(host="0.0.0.0", port=8003, debug=True)