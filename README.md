This is the Dice API using Springboot:

Given the requirements, the API contains the following:
- Separate packages for model, dto, controller, service, and repository.
- Database configuration for Postgres

The following are the endpoints and their description:

"/diceapi/simulation/run"
- Validates the request body and throws a validation exception if invalid
- Accepts the following request body in JSON format:
{
    "numberOfDice": value,
    "sidesOfDie": value,
    "numberOfRolls": value
}
- Returns the distribution information the simulation as a response in JSON format:
[
  {
    "id": 1125,
    "diceSimulationId": 97,
    "totalOfDiceValues": 1,
    "frequency": 1
  },
  {...}
 ]

"/diceapi/simulation/all"
- Returns the list of all simulations made  as a response in JSON format:
[
  {
    "id": 97,
    "sidesOfDie": 6,
    "numberOfDice": 1,
    "numberOfRolls": 6,
    "distribution": [
      {
        "id": 1125,
        "diceSimulationId": 97,
        "totalOfDiceValues": 1,
        "frequency": 1
      },
      {...}
      ]
   },
  {...}
 ]
 
 "/diceapi/simulation/{id}"
 - Returns the information of a specific simulation as a response in JSON format:
{
  "id": 67,
  "sidesOfDie": 6,
  "numberOfDice": 1,
  "numberOfRolls": 6,
  "distribution": [
    {
      "id": 837,
      "diceSimulationId": 67,
      "totalOfDiceValues": 1,
      "frequency": 2
    },
    {...}
  ],
  "details": [
      {
        "id": 2772,
        "diceSimulationId": 84,
        "rollNumber": 1,
        "diceNumber": 1,
        "diceValue": 4
      },
      {...}
   ]
}
"/diceapi/simulation/statistics/total"
 - Validates the request body and throws a validation exception if invalid
 - Accepts the following request body in JSON format:
{
    "numberOfDice": 3,
    "sidesOfDie": 6
}
 - Returns the simulation information for requested dice combination in JSON format:
 {
   "totalRolls": 10,
   "simulations": 1
 }
 
 "/diceapi/simulation/statistics/distribution"
  - Validates the request body and throws a validation exception if invalid
  - Accepts the following request body in JSON format:
 {
     "numberOfDice": 3,
     "sidesOfDie": 6
 }
  - Returns the distribution information for a requested dice combination in JSON format:
{
  "sidesOfDie": 6,
  "numberOfDice": 3,
  "simulations": 1,
  "totalRolls": 10,
  "numberOfSumResult": 18,
  "distribution": [
    {
      "totalOfDiceValues": 1,
      "frequency": 0,
      "percentage": "0%"
    },
    {...}
  ]
}
 
