# kotlin-restapi

This is a sample project about how to make rest api with kotlin language.

## Prerequisites
Make sure you have installed all of the following prerequisites on your development machine:

- IntelliJ IDEA - [Download and Install IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows), and make sure you have installed Ktor Plugin. You are use Intellij IDEA as your IDE.
- Postman - [Download and Install Postman](https://www.getpostman.com/downloads/), you use Postman to test your Rest API.

## Cloning the github repository

The way to get project is to use git to directly clone the repository.

```bash
$git clone https://github.com/johansutrisno/kotlin-restapi.git kotlin-restpi
```

This will clone the latest version of the project repository to a kotlin-restpi folder.


## Quick Install

- Open the project with IntelliJ IDEA, and make sure you have imported gradle.
- Run the project.
- Open Postman and try request with it.

## Sample Request
#### POST User
```bash
localhost:8080/user/
```

```bash
{
    "name": "Fulan Bin Fulanah",
    "phone": "083764972764",
    "email": "fulanoy@gmail.com"
}
```
#### GET All User
```bash
localhost:8080/user/
```
#### GET User By Id
```bash
localhost:8080/user/{id}
```
#### DELETE User By Id
```bash
localhost:8080/user/{id}
```
