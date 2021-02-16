# Fagsystem
Eksempel av fagsystem. Denne applikasjonen bruker in memory H2 database og flyway skripter for å lage tabell.
Alle konfigurasjoner ligger på application.properties  
  
Endpoint for å opprette kunde:
http://localhost:8090/fagsystem/customers
  
Endpoint for å opprette avtale:
http://localhost:8090/fagsystem/agreements
  
Endpoint for å oppdater status:
http://localhost:8090/fagsystem/agreements/{agreementId}
  
Da applikasjonen kjører kan du sjekke ut h2 database på:
http://localhost:8090/h2-console