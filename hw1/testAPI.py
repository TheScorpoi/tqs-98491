import requests

url = "https://covid-193.p.rapidapi.com/statistics"

querystring = {"country":"Portugal"}

headers = {
	"X-RapidAPI-Host": "covid-193.p.rapidapi.com",
	"X-RapidAPI-Key": "b17dd8ee0emsh978d6befbd7713ep1ef035jsnf0474879bd38"
}

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)