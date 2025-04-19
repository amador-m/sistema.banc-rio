# Sistema Bancário em Java

Este projeto é um sistema bancário simples desenvolvido em **Java**, que permite realizar operações como depósitos, saques, pagamentos de boletos e gerenciamento do cheque especial  

## Funcionalidades
- Consultar saldo 
- Consultar cheque especial disponível  
- Depositar dinheiro na conta
- Sacar dinheiro, incluindo uso de cheque especial
- Pagar boletos diretamente pelo sistema
- Verificar se o cliente está utilizando o cheque especial
- Criar uma nova conta no banco

## Estrutura do Projeto
- **`Conta.java`** → Representa uma conta bancária, gerenciando saldo, cheque especial e atualizações financeiras
- **`Operacoes.java`** → Lida com as operações disponíveis, como saque, depósito e pagamento de boletos  
- **`Main.java`** → Interface para o usuário com um menu interativo 

## Regras de negócio do cheque especial
- Se o depósito inicial for R$500,00 ou menos, o cheque especial será R$50,00
- Se o depósito inicial for acima de R$500,00, o cheque especial será 50% do valor depositado
- Quando o cheque especial for utilizado, o sistema cobrará automaticamente 20% do valor utilizado no primeiro depósito após sua ativação

## Contribuições
Se quiser contribuir com melhorias ou sugerir novas funcionalidades, fique à vontade para abrir uma issue ou enviar um pull request :)
