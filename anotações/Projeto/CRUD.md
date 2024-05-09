
| Creat | Rread | Update    | Delet   |
| ----- | ----- | --------- | ------- |
| Criar | Ler   | Atualizar | Excluir |




1. **Create (Criar)**:
    
    - Defina rotas para receber solicitações HTTP POST que contêm dados para criar um novo recurso.
    - No manipulador de rota associado, processe os dados recebidos e salve-os no banco de dados.
    - Responda à solicitação com uma mensagem indicando o sucesso da criação ou, em caso de erro, uma mensagem de erro apropriada.
2. **Read (Ler)**:
    
    - Defina rotas para receber solicitações HTTP GET para recuperar recursos existentes.
    - No manipulador de rota associado, consulte o banco de dados para recuperar os recursos solicitados.
    - Responda à solicitação com os dados recuperados, geralmente em formato JSON, para que possam ser consumidos pelo cliente.
3. **Update (Atualizar)**:
    
    - Defina rotas para receber solicitações HTTP PUT ou PATCH que contêm dados para atualizar um recurso existente.
    - No manipulador de rota associado, processe os dados recebidos e atualize o recurso correspondente no banco de dados.
    - Responda à solicitação com uma mensagem indicando o sucesso da atualização ou, em caso de erro, uma mensagem de erro apropriada.
4. **Delete (Excluir)**:
    
    - Defina rotas para receber solicitações HTTP DELETE para excluir recursos existentes.
    - No manipulador de rota associado, localize e exclua o recurso correspondente no banco de dados.
    - Responda à solicitação com uma mensagem indicando o sucesso da exclusão ou, em caso de erro, uma mensagem de erro apropriada.
