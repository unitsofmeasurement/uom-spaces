#Welcome to Units of Measurement Quantifier
Quantifier is a demonstration Web App for Quantified Self with Agorava. It allows you to connect to various fitness portals and see your activities or post update.

##Running
Quantifier comes with a Jetty configuration, so you can lauch the webapp directly from maven. All you have to do is enter the command

`mvn -Prun`

and wait that maven download all its needed stuff (can be long the first time)
When Jetty is launch just point your browser to
`http://localhost:8080`
and enjoy.


##Building
You can build Quantifier with the command

`mvn clean install`

It'll produce the war `uom-quantifier.war` in target Folder. 

##Deploy
Right now Quantifier was tested with JBoss 7.1.1 and WildFly 8.x. We are in the process of testing validating it with others servers

##Issues
Please report your issues to
`https://github.com/unitsofmeasurement/uom-spaces/issues` (label `qs`)