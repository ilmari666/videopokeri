Yksinkertainen videopokeri

Yksinkertainen 'videopokeri' perustuen 'Pokeri'-klassikkopeliin. Pelaaja panostaa 1-5 markkaa jonka jälkeen hänelle jaetaan viisi korttia. Tämän jälkeen pelaaja voi valita kuinka monta korttia hän haluaa pitää (0-5) ja loput kortit vaihdetaan. Lopuksi pelaajan saama käsi tarkastetaan ja mahdollisesti maksetaan pelaajan saama voitto.

Pelaaja voi pelin aikana lisätä itselleen lisää kolikoita.

Pelin toteutus jakautuu kolmeen eri pääosa-alueeseen.
Visuaaliseen rajapintaan, pää-/pelikierroslogiikkaan sekä voitontarkastukseen.

Pelin voittoluokat määritellään ulkoisessa tiedostossa

Pääpeli
Pelikierros
Voitontarkistus
Kortti
Korttipakka

Peliä ohjaavia nappeja varten implementoidaan yksinkertainen tilakone joka pitää huolen nappien aktiivisuudesta pelin eri vaiheissa.

Pelin voittokädet määritellään JSON-formaatissa ja parsitaan käyttäen Googlen GSON-kirjasto.