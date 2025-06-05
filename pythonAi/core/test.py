import sys
from google import genai

API_KEY = sys.argv[1] if len(sys.argv) > 1 else None
TOKEN_PROMPT = sys.argv[2] if len(sys.argv) > 2 else None
if API_KEY is None or TOKEN_PROMPT is None:
    raise ValueError("API key and or Token String is required as a command line argument.")
client = genai.Client(api_key=API_KEY)

response = client.models.generate_content(
    model="gemini-2.0-flash", contents=TOKEN_PROMPT)
print(response.text)