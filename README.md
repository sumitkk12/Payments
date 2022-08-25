# Payments System 💸💸

The REST-API for Payments.
A payment system consists of the amount and method by which customers pay their bills. Managers can generate bills. Account holder can use autoPayment service to pay bills. All the trasactions will be stored and mail will be sent to user when amount is deducted from his account. Account holder can export all the payment details in excel sheet format. Account holder can see the pending or paid bills for all or particuler biller. 

## Schema Design 
![Schema](https://github.com/sumitkk12/Payments/blob/master/images/DB%20Design.png)

## Technology used
<div align="center"><img width="55" src="https://github.com/sumitkk12/Payments/blob/master/images/spring-icon-svgrepo-com.svg"/><img width="55" src="https://github.com/sumitkk12/Payments/blob/master/images/mysql-icon.svg"/><img width="55" src="https://github.com/sumitkk12/Payments/blob/master/images/java-icon.svg"/><img width="55" src="https://github.com/sumitkk12/Payments/blob/master/images/trello-icon.svg"/><img width="55" src="https://github.com/sumitkk12/Payments/blob/master/images/git-icon-logo-svgrepo-com.svg"/><img width="55" src="https://github.com/sumitkk12/Payments/blob/master/images/getpostman-icon.svg"/></div>

## Create/import database

Create a database by importing `mysql-dump.sql`.

## SETUP 🔧

## Endpoints 🔗

GET {{url}}/view-sheduled-bill-payments/{accountNo}

GET {{url}}/view-payments-done-for-all/{accountNo}

GET {{url}}/RegisteredBillers/{accountNo}

GET {{url}}/view-payments-done-for-selected-biller/{accountNo}/{consumerNo}

POST {{url}}/RegisteredBillers
```JSON
{
  "bllerSeqId": 10,
  "accountNo": 2,
  "billerCode": "B002",
  "consumerNo": "9000",
  "autoPay": 1,
  "autopayLimit": 5000
}
```

POST {{url}}/createNewBill
```JSON
{
  "billerCode": "B001",
  "consumerNo": "9987",
  "amount": 1000,
  "dueDate": "2022-08-29",
  "status": "PENDING"
}
```

POST {{url}}/paymentManual/
```JSON
{
  "billSequenceId": 35,
  "accountNo": 1,
  "description": "raj paid jio"
}
```

GET {{url}}/CSV/1

POST {{url}}/login
```JSON
{
  "user": "101",
  "pass": "abc"
}
```

