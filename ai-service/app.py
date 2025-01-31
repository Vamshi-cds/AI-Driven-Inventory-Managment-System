from flask import Flask, request, jsonify
import pandas as pd
from sklearn.ensemble import RandomForestRegressor
import joblib
import os

app = Flask(__name__)

# Ensure the models directory exists
MODELS_DIR = "models"
MODEL_PATH = os.path.join(MODELS_DIR, "demand_model.pkl")

if not os.path.exists(MODELS_DIR):
    os.makedirs(MODELS_DIR)

# Train initial model (run once)
if not os.path.exists(MODEL_PATH):
    # Example training data
    dummy_data = pd.DataFrame({
        'month': range(1, 13),
        'sales': [100, 120, 90, 150, 200, 180, 210, 190, 220, 240, 300, 280]
    })
    model = RandomForestRegressor(n_estimators=100)
    model.fit(dummy_data[['month']], dummy_data['sales'])
    joblib.dump(model, MODEL_PATH)

@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    model = joblib.load(MODEL_PATH)
    prediction = model.predict([[data['month']]])
    return jsonify({'prediction': prediction[0].item()})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)