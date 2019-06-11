# JUMMP HELP.
Micro frame Java Desktop para sistemas de CRUD.

## Requerimentos:

Para a estrutura funcionar corretamente, deve se importar estes dois arquivos 
localizado em JUMMP/imports.

- javax.persistence.jar
- postgresql-42.2.2.jar

- Adicionar biblioteca padrão EclipseLink (JPA 2.1);

## JUMMP.authorization
 Requerimentos para funcionamento do authorization:
 
 - Modelo chamado Usuario, com id, login, senha e TipoUsuario;
 - Enum TipoUsuario, com todos os tipos de usuários que o sistema comporta;
 - Named Query com nome de validarLogin, dentro do modelo de Usuario Exemplo: 
      * @NamedQueries(@NamedQuery(name="validarLogin",query="SELECT user FROM Usuario user WHERE user.login = ?1 AND user.senha = ?2")).

## Configurações:

- O nome da unidade de persistencia deve ser definido em Main/Home na constante PERSISTENCE_NAME;
- O nome do sistema deve ser definido em Main/Home na constante SYSTEM_NAME;

## Regras implementação:

- Todos controllers devem extender ao BaseController;
- Todos forms devem extender ao BaseForm;
- Todos grids devem extender ao AbstractGrid;
- Os icones a serem usadas nas actions devem inseridos na pasta JUMMP.icons, e ao definir para a action, usar apenas o nome da imagem.

## Erros previstos:
- **Form em branco ao abrir**: Remover métodos getLayout() e setLayout(); 

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
