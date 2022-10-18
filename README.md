# ceb-api

Compte est bon REST api

## Docker

### Push

```sh
docker build -t ceb-api .
docker tag ceb-api garrou/ceb-api
docker push garrou/ceb-api
```

### Pull & Run

```sh
docker pull garrou/ceb-api
docker run -p 8080:8080 --name ceb-api garrou/ceb-api 
```

### Build & Run

[Docker Hub](https://hub.docker.com/r/garrou/ceb-api)

```sh
docker build -t ceb-api .
docker run -p 8080:8080 --name ceb-api ceb-api 
```

## POST

```powershell
Invoke-WebRequest -UseBasicParsing "http://localhost:8080/api/compute" `
                    -ContentType "application/json" `
                    -Method POST `
                    -Body '{ "operands": [25,6,6,5,2,3], "goal":764 }'
```

## Response

```json
{
  "timeInSecs": 1.329,
  "nbSolutions": 6,
  "solutions": [
    {
      "operations": [
        "25 x 5 = 125",
        "6 - 2 = 4",
        "3 + 125 = 128",
        "6 x 128 = 768",
        "768 - 4 = 764"
      ]
    },
    {
      "operations": [
        "25 x 5 = 125",
        "6 / 3 = 2",
        "2 + 125 = 127",
        "6 x 127 = 762",
        "2 + 762 = 764"
      ]
    },
    {
      "operations": [
        "25 x 5 = 125",
        "3 + 125 = 128",
        "6 x 128 = 768",
        "2 + 768 = 770",
        "770 - 6 = 764"
      ]
    },
    {
      "operations": [
        "25 x 5 = 125",
        "3 + 125 = 128",
        "6 x 128 = 768",
        "768 - 6 = 762",
        "2 + 762 = 764"
      ]
    },
    {
      "operations": [
        "25 - 2 = 23",
        "6 x 6 = 36",
        "36 - 3 = 33",
        "23 x 33 = 759",
        "5 + 759 = 764"
      ]
    },
    {
      "operations": [
        "25 - 3 = 22",
        "6 x 22 = 132",
        "132 - 5 = 127",
        "6 x 127 = 762",
        "2 + 762 = 764"
      ]
    }
  ]
}
```
