> # Insurance Management(backend)
Clone project and configure Application properties. <br>
Setup MySQL and configuration in spring.

## Client APIs
### Add Client <br>
POST/ API: http://localhost:9999/api/clients <br>
input: <br>
 ```
  {
    "name":"Ramesh",
    "dob":"1999-11-14",
    "address":"new delhi",
    "contact":98882773
}
 ```
### Get client by ID <br>
GET/ API: http://localhost:9999/api/clients/{id}<br>
Output: <br>
 ```
{
        "id": 1,
        "name": "Nitish",
        "dateOfBirth": "1999-11-14",
        "contact": "98882773",
        "policyList": [
            {
                "policyID": 1,
                "policyType": "Motor"
            },
            {
                "policyID": 2,
                "policyType": "Motor"
            }
        ],
        "address": "new delhi"
    }
 ```
### Get All the clients <br>
GET/ API: http://localhost:9999/api/clients<br>
Output: <br>
 ```
   [
    {
        "id": 1,
        "name": "Nitish",
        "dateOfBirth": "1999-11-14",
        "contact": "98882773",
        "policyList": [
            {
                "policyID": 1,
                "policyType": "Motor"
            },
            {
                "policyID": 2,
                "policyType": "Motor"
            }
        ],
        "address": "new delhi"
    },
    {
        "id": 2,
        "name": "Nitish",
        "dateOfBirth": "1999-11-14",
        "contact": "98882773",
        "policyList": [],
        "address": "new delhi"
    },
    {
        "id": 3,
        "name": "Nitish",
        "dateOfBirth": "1999-11-14",
        "contact": "98882773",
        "policyList": [
            {
                "policyID": 3,
                "policyType": "Motor"
            }
        ],
        "address": "new delhi"
    }
]

 ```
### Update client detail by ID <br>
PUT/ API: http://localhost:9999/api/clients/{id}<br>
input: <br>
 ```
 {
    "name":"ramesh",
    "dob":"1999-11-24",
    "address":"new delhi",
    "contact":98882772

}
 ```
### Delete client detail by ID <br>
DELETE/ API: http://localhost:9999/api/clients/{id}<br>

## Insurance Policy APIs
### Add Insurance Policy to Client <br>
POST/ API: http://localhost:9999/api/policies <br>
input: <br>
 ```
  {
    "clientId":3,
    "type":"Motor",
    "amount":20000.00,
    "premium":1000.00,
    "startDate":"2012-11-23",
    "endDate":"2012-11-23"
}
 ```
### Get Insurance by ID <br>
GET/ API: http://localhost:9999/api/policies/{id}<br>
Output: <br>
 ```
  {
    "name":"Ramesh",
    "dob":"1999-11-14",
    "address":"new delhi",
    "contact":98882773{
    "policyId": 3,
    "type": "Motor",
    "amount": 20000.0,
    "premium": 1000.0,
    "startDate": "2012-11-23",
    "endDate": "2012-11-23",
    "claimStatus": "NotClaimed",
    "clientName": "Nitish"
}

 ```
### Get All the clients <br>
GET/ API: http://localhost:9999/api/policies<br>
Output: <br>
 ```
[
  {
    "name":"Ramesh",
    "dob":"1999-11-14",
    "address":"new delhi",
    "contact":98882773{
    "policyId": 3,
    "type": "Motor",
    "amount": 20000.0,
    "premium": 1000.0,
    "startDate": "2012-11-23",
    "endDate": "2012-11-23",
    "claimStatus": "NotClaimed",
    "clientName": "Nitish"
}
]
 ```
### Update Update Insurance Policy by ID <br>
PUT/ API: http://localhost:9999/api/policies/{id}<br>
input: <br>
 ```
 {
    "clientId":3,
    "type":"Health",
    "amount":20000.00,
    "premium":1000.00,
    "startDate":"2012-11-23",
    "endDate":"2012-11-23"
}
 ```
### Delete client detail by ID <br>
DELETE/ API: http://localhost:9999/api/policies/{id}<br>

## Claims APIs
### Add Claims to insurance policies <br>
POST/ API: http://localhost:9999/api/claims <br>
input: <br>
 ```
{
    "policyId":2,
    "description":"Urgency",
    "claimStatus":"ClaimedButApprovalPending",
    "date":"2023-05-02"
}
 ```
### Get claim by ID <br>
GET/ API: http://localhost:9999/api/claims/{id}<br>
Output: <br>
 ```
    {
    "policyId": 2,
    "policyType": "Motor",
    "claimId": 2,
    "date": "2023-05-02",
    "claimStatus": "ClaimedButApprovalPending",
    "description": "Urgency"
}
 ```
### Get claim by ID <br>
GET/ API: http://localhost:9999/api/claims<br>
Output: <br>
 ```
[
  {
    "policyId": 2,
    "policyType": "Motor",
    "claimId": 2,
    "date": "2023-05-02",
    "claimStatus": "ClaimedButApprovalPending",
    "description": "Urgency"
}
]
 ```
### Update claims by ID <br>
PUT/ API: http://localhost:9999/api/claims<br>
input: <br>
 ```
 {
    {
    "policyId":2,
    "description":"Urgency",
    "claimStatus":"ClaimedButApprovalPending",
    "date":"2023-05-02"

}
 ```
### Delete claims detail by ID <br>
DELETE/ API: http://localhost:9999/api/policies/{id}<br>
 
 
