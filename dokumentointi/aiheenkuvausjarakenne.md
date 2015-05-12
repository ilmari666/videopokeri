Yksinkertainen videopokeri
==========================

#Kuvaus ja pelikierroksen kulku
Yksinkertainen 'videopokeri' perustuen 'Pokeri'-klassikkopeliin. Pelaaja panostaa 1-5 markkaa jonka jälkeen hänelle jaetaan viisi korttia. Tämän jälkeen pelaaja voi valita kuinka monta korttia hän haluaa pitää (0-5) ja loput kortit vaihdetaan. Lopuksi pelaajan saama käsi tarkastetaan. Pelaajan voittoessa hänen on mahdollista tuplata (Pieni/Iso, seitsemän = talo voittaa) hänen voittonsa 200mk asti.

Pelaaja voi pelin aikana lisätä itselleen lisää kolikoita.

Pelin toteutus jakautuu kolmeen eri pääosa-alueeseen.
Visuaaliseen rajapintaan, pää-/pelikierroslogiikkaan sekä voitontarkastukseen.

Pelin voittoluokat määritellään ulkoisessa tiedostossa

-Pääpeli
-Tuplauspeli
-Pelikierros
-Voitontarkistus
-Kortti
-Korttipakka

Peliä ohjaavia nappeja varten implementoidaan yksinkertainen tilakone joka pitää huolen nappien aktiivisuudesta pelin eri vaiheissa.

Pelin voittokädet määritellään JSON-formaatissa ja parsitaan käyttäen Googlen GSON-kirjasto.

Pelin toteutusta monimutkaistetaan tallentamalla esimerkiksi tuplauksen jakohistoria ja näyttämällä tätä pelaajalle.

#Kayttajat
-Pelaaja syöttää rahaa, valitsee pidettävät kortit sekä tekee päätöksen tuplauksesta tai voittojen pitämisestä.
-Pelin ylläpitäjä voi vaihtaa pelin kiekkoja ja palkitsemislogiikkaa editoimalla JSON-tiedostoja