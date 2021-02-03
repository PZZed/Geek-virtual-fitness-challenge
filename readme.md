gvfc
====

Base URL: /gvfc/, Version: 0.0.1-SNAPSHOT

Schemes: http

Summary
-------

|Path|Operation|Description|
|:---|:--------|:----------|
|[/challenge](#path--challenge)|[GET](#operation--challenge-get)||
|[/challenge/create](#path--challenge-create)|[POST](#operation--challenge-create-post)||
|[/challenge/create/{name}/{maxPlayer}/{description}/{url}](#path--challenge-create--name---maxPlayer---description---url-)|[GET](#operation--challenge-create--name---maxPlayer---description---url--get)||
|[/challenge/{id}](#path--challenge--id-)|[GET](#operation--challenge--id--get)||
|[/challenge/{id}/modify/description/{description}](#path--challenge--id--modify-description--description-)|[GET](#operation--challenge--id--modify-description--description--get)||
|[/challenge/{id}/modify/image/{url}](#path--challenge--id--modify-image--url-)|[GET](#operation--challenge--id--modify-image--url--get)||
|[/challenge/{id}/modify/parameters](#path--challenge--id--modify-parameters)|[POST](#operation--challenge--id--modify-parameters-post)||
|[/challenge/{id}/remove/checkpoint/{idc}](#path--challenge--id--remove-checkpoint--idc-)|[GET](#operation--challenge--id--remove-checkpoint--idc--get)||
|[/challenge/{id}/segment/add/{idseg}](#path--challenge--id--segment-add--idseg-)|[GET](#operation--challenge--id--segment-add--idseg--get)||
|[/obstacle](#path--obstacle)|[GET](#operation--obstacle-get)||
|[/obstacle/create/{name}/{action}](#path--obstacle-create--name---action-)|[GET](#operation--obstacle-create--name---action--get)||
|[/Segment](#path--Segment)|[GET](#operation--Segment-get)||
|[/Segment/add/{src}/{dst}](#path--Segment-add--src---dst-)|[GET](#operation--Segment-add--src---dst--get)||
|[/Segment/create/{src}/{dst}](#path--Segment-create--src---dst-)|[GET](#operation--Segment-create--src---dst--get)||
|[/Segment/delete](#path--Segment-delete)|[DELETE](#operation--Segment-delete-delete)||
|[/Segment/{id}/add/obstacle/{idObstacle}](#path--Segment--id--add-obstacle--idObstacle-)|[GET](#operation--Segment--id--add-obstacle--idObstacle--get)||
|[/Step](#path--Step)|[GET](#operation--Step-get)||
|[/Step/add/{name}](#path--Step-add--name-)|[GET](#operation--Step-add--name--get)||
|[/Step/delete](#path--Step-delete)|[DELETE](#operation--Step-delete-delete)||
|[/Theme](#path--Theme)|[GET](#operation--Theme-get)||
|[/Theme/create/{desc}](#path--Theme-create--desc-)|[GET](#operation--Theme-create--desc--get)||
|[/Theme/vote/{id}](#path--Theme-vote--id-)|[GET](#operation--Theme-vote--id--get)||
|[/User](#path--User)|[GET](#operation--User-get)||
|[/User/create](#path--User-create)|[POST](#operation--User-create-post)||
|[/User/create/{username}/{password}/{mail}](#path--User-create--username---password---mail-)|[GET](#operation--User-create--username---password---mail--get)||
|[/User/delete/{id}](#path--User-delete--id-)|[GET](#operation--User-delete--id--get)||
|[/User/login/{username}/{password}](#path--User-login--username---password-)|[GET](#operation--User-login--username---password--get)||
|[/User/promote/{id}](#path--User-promote--id-)|[GET](#operation--User-promote--id--get)||
|[/User/{id}](#path--User--id-)|[GET](#operation--User--id--get)||
|[/User/{id}/challenge/registered](#path--User--id--challenge-registered)|[GET](#operation--User--id--challenge-registered-get)||
|[/User/{id}/subscribe/{idChall}](#path--User--id--subscribe--idChall-)|[GET](#operation--User--id--subscribe--idChall--get)||

Paths
-----

### GET **/challenge**

 200 OK   
OK

[Object](#/definitions/Object)

### POST **/challenge/create**

|:--|:--|:--|:--|:--|
|description||query|string||
|idSegments||query|integer[]||
|maxPlayer||query|integer||
|name||query|string||
|url||query|string||

 200 OK   
OK

[Challenge](#/definitions/Challenge)

### GET **/challenge/create/{name}/{maxPlayer}/{description}/{url}**

|:--|:--|:--|:--|:--|
|description||path|string||
|maxPlayer||path|integer||
|name||path|string||
|url||path|string||

 200 OK   
OK

[Challenge](#/definitions/Challenge)

### GET **/challenge/{id}**

|:--|:--|:--|:--|:--|
|id||path|integer||

 200 OK   
OK

[Challenge](#/definitions/Challenge)

### GET **/challenge/{id}/modify/description/{description}**

|:--|:--|:--|:--|:--|
|description||path|string||
|id||path|integer||

 200 OK   
OK

[Challenge](#/definitions/Challenge)

### GET **/challenge/{id}/modify/image/{url}**

|:--|:--|:--|:--|:--|
|id||path|integer||
|url||path|string||

 200 OK   
OK

[Challenge](#/definitions/Challenge)

### POST **/challenge/{id}/modify/parameters**

* * * * *

Modification

* * * * *

|:--|:--|:--|:--|:--|
|id||path|integer||
|maxPlayer||query|integer||
|mode||query|string , x ∈ { EQUIPE , SOLO }||
|name||query|string||

 200 OK   
OK

### GET **/challenge/{id}/remove/checkpoint/{idc}**

|:--|:--|:--|:--|:--|
|id||path|integer||
|idc||path|integer||

 200 OK   
OK

### GET **/challenge/{id}/segment/add/{idseg}**

|:--|:--|:--|:--|:--|
|id||path|integer||
|idseg||path|integer||

 200 OK   
OK

### GET **/obstacle**

 200 OK   
OK

[Object](#/definitions/Object)

### GET **/obstacle/create/{name}/{action}**

|:--|:--|:--|:--|:--|
|action||path|string||
|name||path|string||

 201 Created   
Created

[Checkpoint](#/definitions/Checkpoint)

### GET **/Segment**

 200 OK   
OK

[Object](#/definitions/Object)

### GET **/Segment/add/{src}/{dst}**

|:--|:--|:--|:--|:--|
|dst||path|string||
|src||path|string||

 200 OK   
OK

[Segment](#/definitions/Segment)

### GET **/Segment/create/{src}/{dst}**

|:--|:--|:--|:--|:--|
|dst||path|integer||
|src||path|integer||

 200 OK   
OK

[Segment](#/definitions/Segment)

### DELETE **/Segment/delete**

|:--|:--|:--|:--|:--|
|id||query|integer||

 200 OK   
OK

### GET **/Segment/{id}/add/obstacle/{idObstacle}**

|:--|:--|:--|:--|:--|
|id||path|integer||
|idObstacle||path|integer||

 200 OK   
OK

[Segment](#/definitions/Segment)

### GET **/Step**

 200 OK   
OK

[Object](#/definitions/Object)

### GET **/Step/add/{name}**

|:--|:--|:--|:--|:--|
|name||path|string||

 200 OK   
OK

[Step](#/definitions/Step)

### DELETE **/Step/delete**

|:--|:--|:--|:--|:--|
|id||query|integer||

 200 OK   
OK

### GET **/Theme**

 200 OK   
OK

[Object](#/definitions/Object)

### GET **/Theme/create/{desc}**

|:--|:--|:--|:--|:--|
|desc||path|string||

 200 OK   
OK

[Theme](#/definitions/Theme)

### GET **/Theme/vote/{id}**

|:--|:--|:--|:--|:--|
|id||path|integer||

 200 OK   
OK

[Theme](#/definitions/Theme)

### GET **/User**

Ok Get all the users.

 200 OK   
OK

[Object](#/definitions/Object)

### POST **/User/create**

Create an user.

<table>
<col width="20%" />
<col width="20%" />
<col width="20%" />
<col width="20%" />
<col width="20%" />
<tbody>
<tr class="odd">
<td align="left">mail</td>
<td align="left"><p>The user mail.</p></td>
<td align="left">query</td>
<td align="left">string</td>
<td align="left"></td>
</tr>
<tr class="even">
<td align="left">password</td>
<td align="left"><p>the user password.</p></td>
<td align="left">query</td>
<td align="left">string</td>
<td align="left"></td>
</tr>
<tr class="odd">
<td align="left">username</td>
<td align="left"><p>the user username.</p></td>
<td align="left">query</td>
<td align="left">string</td>
<td align="left"></td>
</tr>
</tbody>
</table>

 201 Created   
Created

[User](#/definitions/User)

 406 Not Acceptable   
Not Acceptable

 409 Conflict   
Conflict

### GET **/User/create/{username}/{password}/{mail}**

|:--|:--|:--|:--|:--|
|mail||path|string||
|password||path|string||
|username||path|string||

 200 OK   
OK

[User](#/definitions/User)

### GET **/User/delete/{id}**

Delete the user.

|:--|:--|:--|:--|:--|
|id||path|integer||

 200 OK   
OK

### GET **/User/login/{username}/{password}**

|:--|:--|:--|:--|:--|
|password||path|string||
|username||path|string||

 200 OK   
OK

### GET **/User/promote/{id}**

Promote an User to Admin

<table>
<col width="20%" />
<col width="20%" />
<col width="20%" />
<col width="20%" />
<col width="20%" />
<tbody>
<tr class="odd">
<td align="left">id</td>
<td align="left"><p>the user id.</p></td>
<td align="left">path</td>
<td align="left">integer</td>
<td align="left"></td>
</tr>
</tbody>
</table>

 200 OK   
OK

[User](#/definitions/User)

### GET **/User/{id}**

Ok Get an user with its id.

|:--|:--|:--|:--|:--|
|id||path|integer||

 200 OK   
OK

[User](#/definitions/User)

### GET **/User/{id}/challenge/registered**

|:--|:--|:--|:--|:--|
|id||path|integer||

 200 OK   
OK

[Object](#/definitions/Object)

### GET **/User/{id}/subscribe/{idChall}**

Subscribe a player to a challenge.

<table>
<col width="20%" />
<col width="20%" />
<col width="20%" />
<col width="20%" />
<col width="20%" />
<tbody>
<tr class="odd">
<td align="left">id</td>
<td align="left"><p>of the player</p></td>
<td align="left">path</td>
<td align="left">integer</td>
<td align="left"></td>
</tr>
<tr class="even">
<td align="left">idChall</td>
<td align="left"><p>of the challenge</p></td>
<td align="left">path</td>
<td align="left">integer</td>
<td align="left"></td>
</tr>
</tbody>
</table>

 200 OK   
OK

Schema definitions
------------------

### Challenge: object

 description: string    

 id: integer    

 maxPlayer: integer    

 mode: string , x ∈ { EQUIPE , SOLO }     

 name: string    

 segments: object[]    
[Segment](#/definitions/Segment)

 url: string    

### Checkpoint: object

 action: string    

 id: integer    

 name: string    

### Object: object

### Segment: object

 dest:  [Step](#/definitions/Step)     

 id: integer    

 obstacles: object[]    
[Checkpoint](#/definitions/Checkpoint)

 source:  [Step](#/definitions/Step)     

### Step: object

 id: integer    

 name: string    

### Theme: object

 desc: string    

 id: integer    

 nbVote: integer    

### User: object

 id: integer    

 mail: string    

 password: string    

 registeredChallenge: object[]    
[Challenge](#/definitions/Challenge)

 role: string , x ∈ { ADMIN , USER }     

 username: string    


