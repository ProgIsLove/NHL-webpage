# NHL-webpage

## Working with Recipe book in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 8 or newer
* Spring Tools Suite
* Maven
* Lombok
* H2-database, you dont need to install
* Git command line tool (https://help.github.com/articles/set-up-git)
* Your preffered IDEA
  * Eclipse
  * IntelliJ IDEA

 ### Steps:
 
 1) On the command line
    ```
    git clone https://github.com/ProgIsLove/NHL-webpage.git
    ```
 2) Open terminal
    ```
    ${yourPath}/nhl>mvnw clean install
    
    ${yourPath}/nhl>mvn spring-boot:run
    
    ```
  Visit http://localhost:8080/nhl in your browser Or visit H2 db => http://localhost:8080/h2-console/
  
  3) Open Postman or Insomnia rest and try these commands
     ```
     GET localhost:8080/api/nhl/team
     
     GET localhost:8080/api/nhl/players/list
     
     GET localhost:8080/api/teamstatistic
     
     GET localhost:8080/api/nhl/playerstatistic/list
     
     POST localhost:8080/api/nhl/player/new => in Body section, tick raw, select JSON and write
     
     {
        "name": "name",
        "surname": "surname",
        "nationality": "nat",
        "playerUrl": "",
        "position": {
            "id" :2
        }
     }
     
     PUT localhost:8080/api/nhl/player/42/update => in Body section, tick raw, select JSON and write
     
     {
        "id": 42,
        "name": "name",
        "surname": "surname",
        "nationality": "nat",
        "position": {
            "id": 1
        }
     }
     
     POST localhost:8080/api/nhl/playerandteam/new => in Body section, tick raw, select JSON and write
     
     {
        "playerContractStart": "yyyy-mm-dd",
        "playerContractEnd": "yyyy-mm-dd",
        "player":{
            "id": 62,
            "name": "name",
            "surname": "surname",
             "nationality": "nat"
        },
        "team":{
            "id":31,
            "teamName": "teamName"
        }    
     }
     
     POST localhost:8080/api/nhl/playerstatistic/new => in Body section, tick raw, select JSON and write
     
         {   
        "player": {
            "id": 30,
            "name": "name",
            "surname": "surname",
            "nationality": "nat"
        },
        "playerAndTeam": {
            "id": 40,
            "playerContractStart": "YYYY-MM-DD",
            "playerContractEnd": "YYYY-MM-DD"
        },
        "startSeason": "YYYY-MM-DD",
        "endSeason": "YYYY-MM-DD",
        "goals": 140,
        "assists": 80,
        "points": 220,
        "plusMinus": 90,
        "goalsAgainst": null,
        "shutouts": null,
        "saves": null
     }
     
    POST localhost:8080/api/nhl/playerstatistic/16/update => in Body section, tick raw, select JSON and write
     
    {"id": 16,
      "player": {
        "id": 16,
        "name": "name",
        "surname": "surname",
        "nationality": "nat"
    },
    "playerAndTeam": {
        "id": 16,
        "playerContractStart": "YYYY-MM-DD",
        "playerContractEnd": "YYYY-MM-DD"
    },
    "startSeason": "YYYY-MM-DD",
    "endSeason": "YYYY-MM-DD",
    "goals": 55,
    "assists": 13,
    "points": 68,
    "plusMinus": 10,
    "goalsAgainst": null,
    "shutouts": null,
    "saves": null
    }

    POST localhost:8080/api/nhl/playerandteam/16/update => in Body section, tick raw, select JSON and write
     
     {        
       "id":16,
       "playerContractStart": "YYYY-MM-DD",
        "playerContractEnd": "YYYY-MM-DD",
        "player":{
            "id": 16,
            "name": "name",
            "surname": "surname",
             "nationality": "nat"
        },
        "team":{
            "id":20,
            "team":	"team name"
        }
    }  
     
     ```
     
 5) Enjoy <3
