# Transportadora

Sistema que informa qual a melhor transportadora com base nas informações fornecidas ao sistema.


Código desenvoldido por: Leonado Freitas Baltar de Carvalho.


07/03/2020

Para testar as funcionalidades, por favor adicione os registros abaixo de transportadoras filiais. Para isso use o metodo post na seguinte url "localhost:8080/filial/adiciona".


	{
        "nome": "Transportadora 1",
        "terrestre": true,
        "aereo": false,
        "tempoMedioAereo": 0,
        "tempoMedioTerrestre": 60,
        "valorAereo": 0.00,
        "valorTerrestre": 50.00
    }
    {
        "nome": "Transportadora 2",
        "terrestre": true,
        "aereo": true,
        "tempoMedioAereo": 30,
        "tempoMedioTerrestre": 59,
        "valorAereo": 200.00,
        "valorTerrestre": 75.00
    },
    {
        "nome": "Transportadora 3",
        "terrestre": true,
        "aereo": true,
        "tempoMedioAereo": 33,
        "tempoMedioTerrestre": 63,
        "valorAereo": 180.00,
        "valorTerrestre": 55.00
    },
    {
        "nome": "Transportadora 4",
        "terrestre": false,
        "aereo": true,
        "tempoMedioAereo": 30,
        "tempoMedioTerrestre": 0,
        "valorAereo": 175.00,
        "valorTerrestre": 0.00
    }
    
Para listas acesse a url "localhost:8080/filial/filiais" pelo método get.

para buscar uma transportadora filial em especídifo acesso a url "localhost:8080/filial/busca/{id}" pelo metodo get.

Para deletar uma transportadora filial acesse a url "localhost:8080/filial/deleta/{id}" pelo metodo delete.

Para alterar uma transportadora filial acesse a url "localhost:8080/filial/atualiza/{id}" pelo metodo put.

Para  buscar a melhor filial para transporte acesse a url "localhost:8080/filial/service/transportadora" com o corpo da requisição com o objeto de exemplo abaixo pelo metodo get.

	{
	"origem":"Campinas - SP",
	"destino":"Petrópolis - RJ",
	"distancia":513,
	"prioridade":"preco",
	"tipoTransporte":"terrestre"
	}