import json
import requests
requisicao = requests.get("https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL")
print(requisicao)
print(requisicao.json())
dir_requisicao = requisicao.json()
print(dir_requisicao['USDBRL']['bid'])
json_object = json.dumps(dir_requisicao, indent=4)
with open("arquivo.json","w") as outfile:
    outfile.write(json_object)