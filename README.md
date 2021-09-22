<h1>📋Respostas das questões do desafio</h1>

<h5>⌨️Resposta da primeira questão: https://github.com/blendagaspar/CepApi/tree/master/luizalabss</h5>
<h5>⌨️Documentação da API :https://github.com/blendagaspar/CepApi/blob/master/API%20-%20Documenta%C3%A7%C3%A3o%20Swagger.pdf</h5>
<h5>⌨️Resposta da segunda questão: https://github.com/blendagaspar/CepApi/blob/master/quest%C3%A3o%202%20.pdf </h5>

<h1>🚀🚀Inicio</h1>
<p>As instruções te ajudaraão a obter uma cópia do projeto no seu computador de forma fácil para avaliar.</p>

<h1>📋Pré-requisitos</h1>
Você precisa ter na sua máquina o MySQL, Postman e SpringBoot ou eclipse sugiro o spring.Caso não tenha, siga os passos abaixo:
<p>⚪ <a href="https://docs.google.com/document/d/e/2PACX-1vSGoGt77gmhWp01eV9GNTUgcs3vYYd83kseM6JPLN6WIxUg55PKAzsMu4DrQY6iAA/pub">MySQL</a> </p>
<p>⚪ <a href="https://docs.google.com/document/d/e/2PACX-1vQeeXhM_m3kYGt4-rx-UCchlOXB3e-EuuYq0khTJPJJ-SCpnkjTAryosu4JA-txcA/pub">Postman</a> </p>
<p>⚪ <a href="https://docs.google.com/document/d/e/2PACX-1vQ3hZCbI_t3glJV2lAK25UcqD467MFV8B9O0EqdX43GHnH7Yr8GlMuRsGWkfjR5Fw/pub">Eclipse</a> </p>

<h1>🔧 Execução do projeto </h1>
Com tudo instalado agora é hora de executar o projeto :
<p>1- Clone o projeto para a sua máquina pelo git clone, e execute o projeto no Spring ou Eclipse através do Run As </p>
<p>2- Como aplicação está com a segurança cadastre um usuario pelo postman e será gravado no banco de dados formato Json:</p>

```
{
    "usuario" : "luiza",
    "senha" : "1111"

}
```

<p>3-No seu browser digite http://localhost:8080/swagger-ui/ e será solicitado um usuario e uma senha adicione a senha e o usuario que foram cadastrados a pouco tempo </p>

<p>3.1- Caso queira fazer os testes pelo postman em vez do swagger, depois de cadastrar faça login e o token que for gerado precisa
ser adicionado ao header de todas requisições , caso contrário não funcionará.
Caso opte pelo postman a porta para as requisições é  http://localhost:8080/endereco  troque os verbos HTTPS 
conforme a necessidade e siga os endpoints disponiveis da  controller Endereço e Usuario.

<p>4-Caso continue no Swagger Cadastre um endereço sugiro o endereço da Sé no formato Json :
Modelo do objeto que está sendo salvo no banco:</p>

```
{
    "cep": "01001000",
    "rua": "Praça da Sé",
    "bairro": "Sé",
    "cidade": "São Paulo",
    "estado": "São Paulo",

}
```
<p>5- Em seguida consulte o Cep que foi cadastrado anteriormente no endpoint do swagger "getByCepUsingGET" e terá o resto dos outros dados do endereço</p>

 <h1>✒️Autora</h1>
 <p>⚪ Blenda Gaspar - Desenvolvedora Java Jr</p>
 
 <p>Agradeço pela oportunidade😀! </p>
 



