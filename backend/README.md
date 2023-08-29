# Backend

This is a REST API built using Java, Spring, H2 Database, Spring Security and JWT.

## Table of Contents

- [Setup instructions](#setup-instructions)
- [Authentication](#authentication)
- [API Endpoints](#api-endpoints)

###

## Setup instructions

### Build project

```
mvn clean package
```

### Run project

```
 java -jar target/survey-app-0.0.1-SNAPSHOT.jar
```

## Authentication

This application uses JWT for authentication and authorization.

The JWT token is returned by the **POST /auth/login** endpoint and need to be inserted as a Bearer token (with a "Bearer" prefix) in every subsequent request made to the api.

<table>
<tr>
<td> Role </td> <td> Functions </td>
</tr>

<tr>
<td> Coordinator </td> <td> Managing surveys. </td>
</tr>

<tr>
<td> Respondent </td> <td> Responding surveys. </td>
</tr>

</table>

## API Endpoints

### POST /auth/register

<table>
<tr>
<td> Usage </td> <td> Example of request body </td>
</tr>
<tr>
<td> Register a new user. </td>
<td>

```json
{
  "name": "André",
  "email": "andrefc36@gmail.com",
  "username": "andrefcordeiro",
  "password": "12345",
  "role": "COORDINATOR"
}
```

</td>
</tr>
</table>

### POST /auth/login

<table>
<tr>
<td> Usage </td> <td> Example of request body </td>
</tr>
<tr>
<td> Login into the application. </td>
<td>

```json
{
  "username": "andrefcordeiro",
  "password": "12345"
}
```

</td>
</tr>
</table>

### POST /surveys

<table>
<tr>
<td> Usage </td> <td> Example of request body </td>
</tr>
<tr>
<td> Create a new survey. </td>
<td>

```json
{
  "title": "Music-related questions",
  "timeframe": "2023-08-13",
  "questions": [
    {
      "text": "How much a dollar cost?",
      "options": ["1", "infinite", "everything", "too much", "nothing"]
    }
  ]
}
```

</td>
</tr>
</table>

### GET /surveys

<table>
<tr>
<td> Usage </td>
</tr>
<tr>
<td> Get all surveys. </td>
</tr>
</table>

### GET /surveys/{id}

<table>
<tr>
<td> Usage </td>
</tr>
<tr>
<td> Get survey by id. </td>
</tr>
</table>

### GET /surveys?coordinator={coordinatorId}

<table>
<tr>
<td> Usage </td>
</tr>
<tr>
<td> Get all surveys by coordinator id. </td>
</tr>
</table>

### GET /surveys/{id}/statistics

<table>
<tr>
<td> Usage </td>
</tr>
<tr>
<td> Get survey and it's question statistics by survey id. </td>
</tr>
</table>

</tr>
</table>

### POST /surveys/{surveyId}/responses

<table>
<tr>
<td> Usage </td> <td> Example of request body </td>
</tr>
<tr>
<td> Submit a survey response. </td>
<td>

```json
{
  "questionsResponses": [
    {
      "questionId": 1,
      "optionSelected": 2
    },
    {
      "questionId": 2,
      "optionSelected": 1
    }
  ]
}
```

</td>
</tr>
</table>

### GET /surveys/{surveyId}/responses?respondent={respondentId}

<table>
<tr>
<td> Usage </td>
</tr>
<tr>
<td> Get a survey response by a respondent. </td>
</tr>
</table>
