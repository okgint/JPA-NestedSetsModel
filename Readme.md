# Template Project Spring JPA Nested Sets Model (http://en.wikipedia.org/wiki/Nested_set_model) #


## Project Modules ##

Project ini terdiri dari 2 sub-project :
* JpaNestedSet : berisi library untuk nested sets model
* web : berisi @Controller , HTML, javascript dsb

## Build dan Run ##

Untuk menjalankan projectnya :

1. Siapkan database MySQL / Oracle

nama db : kingbaraja
username : root
password : 

2.Jalankan maven clean install -DskipTests di top level folder

3. Masuk ke folder web, kemudian jalankan mvn jetty:run

4. Siap dibrowse di http://localhost:8080


## Teknologi dan Library ##

### Framework dan Library ###

* Spring Framework 3
* EclipseLink 2.5.2
* Twitter Bootstrap 3
* bonecp  0.8.0
* w2ui 


### Tools ###

* Build Tool : Maven 3
* Application Server : Jetty 9