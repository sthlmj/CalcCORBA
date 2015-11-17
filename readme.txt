Needs to be in the working directory of the app.

BANK EXEMPLET
=============
1. Mappa java och IDL: 
idlj -fall -oldImplBase CalcInterface.idl

2. Starta namn server i bank exemplet med följande kommandon. Läs eventuell meddelande om Port ändringar som systemet ger! 
Om den inte startar, försök att starta som sudo: 
tnameserv -ORBInitialPort 1050

//Om den är uppe ska det stå: 
Initial Naming Context:
IOR:000000000000002b49444c3a6f6d672e6f72672f436f734e616d696e672f4e616d696e67436f6e746578744578743a312e300000000000010000000000000096000102000000000931302e302e312e360000038400000045afabcb0000000020000f424000000001000000000000000200000008526f6f74504f41000000000d544e616d65536572766963650000000000000008000000010000000114000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002
TransientNameServer: setting port for initial object references to: 900
Ready.

2. Starta bank server: 
java bankidl.Server -ORBInitialPort 900 BankOfEstonia
//Prompten visar tomt rad med cursor

3. Starta bank klienten: 
java bankidl.Client BankOfEstonia -ORBInitialPort 900

//Se till att det står: Connected to bank: BankOfEstonia 
//Och i prompten ska det stå: null@BankOfEstonia

4. Skriv kommandon:
help
//Tillgänglig kommandon visas


CALC EXEMPLET
=============
1. Mappa IDL och java interface med -oldImplBase som binder POA: 
idlj -fall CalcInterface.idl
idlj -fall -oldImplBase CalcInterface.idl

2. Skapa Server.java och Client.java fil.

3. Kompilera filerna, CalcServer.java och CalcClient.java utanför CalcApp mappen. CalcApp är modul som genereras från IDLJ:
javac CalcServer.java CalcApp/*.java
javac CalcClient.java CalcApp/*.java

4. Starta namn server: 
tnameserv -ORBInitialPort 1050

5. Starta CalcServer: 
java CalcServer -ORBInitialPort 1050

6. Starta CalcClient: 
java CalcClient -ORBInitialPort 1050