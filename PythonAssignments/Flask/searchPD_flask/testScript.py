import requests

print("What airport do you want to get from the database running on our Spring Boot API")
airportCode = input("Enter the 3 character airport code")

# Get input
#SEND INPUT TO FLASK endpoint???


# We need to pass the airportCode to the API endpoint somehow
r = requests.get("http://localhost:8091/flights")
print(r.json())