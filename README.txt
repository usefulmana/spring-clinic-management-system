
Author: Nguyen Le Bao Anh
Course: COSC2440 - SADI
Assignment: 2
Description: Back-end components for a patient management system using SpringMVC & Hibernate



Patient APIs
Data:
           {"name": "Chris Hemsworth",
          "birthday": "1990-09-09",
          "gender": "Male",
          "address": "1 Nguyen Hue",
          "visits": [{"visitDate" : "2019-09-03 15:00:00", "problems":"Puking, coughing"}

Purpose                     Endpoint                           Method
Get all patients            /patients/all                      GET
Get a patient by visitId         /patients/visitId                       GET
Get patients by name        /patients                          GET
Delete a patient            /patients                          DELETE
Add a patient               /patients                          POST
Update a patient's info     /patients                          PUT
Get a patient's log         /patients/visit                    GET

Drugs APIs
Data:

{"name": "Novocaine"}

Purpose                     Endpoint                           Method
Get all drugs               /drugs/all                         GET
Get a drug by visitId            /drugs/visitId                          GET
Get drugs by name           /drugs                             GET
Delete a drug               /drugs                             DELETE
Add a patient               /drugs                             POST
Update a drugs              /drugs                             PUT


Prescription APIs

Diagnosis APIs

Patient Creation process

Create a patient;
{"name": "Chris Hemsworth",
          "birthday": "1990-09-09",
          "gender": "Male",
          "address": "1 Nguyen Hue",
          "visits": [{"visitDate" : "2019-09-03 15:00:00", "problems":"Puking, coughing"}]}

Diagnose;
{
}
