# JUMMP
Micro frame Java Desktop para sistemas de CRUD.


@Author Andre Cristen
Help.

Para a estrutura funcionar corretamente, deve se importar estes dois arquivos 
localizado em JUMMP/imports.

- javax.persistence.jar
- postgresql-42.2.2.jar

O nome da unidade de persistencia deve ser definido em Main/Home na constante 
PERSISTENCE_NAME.

Todos controllers devem extender ao BaseController.
Todos forms devem extender ao BaseForm.
Todos grids devem extender ao AbstractGrid.

Os icones a serem usadas nas actions devem inseridos na pasta JUMMP.icons, e 
ao definir para a action, usar apenas o nome da imagem.

# Aplicação Exemplo

O projeto Trans Udesc é um exemplo que visa fornecer uma aplicação em Java Desktop, para o gerenciamento de pequenas transportadoras de carga, com a finalidade de demonstrar as utilizações do JUMMP.

## Módulo Aplicação Exemplo:
O sistema contará com os seguintes módulos.
 - **Cliente**: Fornece uma interface para consulta de todos as entregas que estão associadas a um cliente.
 - **Motorista**: Fornece ferramentas para o motoristas gerir as cargas contidas em seu veículo.
 - **Administrador**: Forncece ferramentas para funcionários que trabalham em centros de despacho da tranportadora, com consultas de cargas, clientes, veiculos, motoristas, entregas, volumes e afins.
 - **Mecânico**: Fornece uma interface para verificar veiculos que estão em reparo ou aguardando reparo.
 - **Gestor**: Fornece visualizações destinadas ao gerente da empresa, com consultas e gráficos relacionadas a empresa.
 
 ## Status: Em desenvolvimento



