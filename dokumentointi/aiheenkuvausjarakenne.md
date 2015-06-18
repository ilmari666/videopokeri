Yksinkertainen videopokeri
==========================

#Kuvaus ja pelikierroksen kulku
Yksinkertainen 'videopokeri' perustuen 'Pokeri'-klassikkopeliin. Pelaaja panostaa 1-5 markkaa jonka jälkeen hänelle jaetaan viisi korttia. Tämän jälkeen pelaaja voi valita kuinka monta korttia hän haluaa pitää (0-5) ja loput kortit vaihdetaan. Lopuksi pelaajan saama käsi tarkastetaan. 

Pelaaja voi pelin aikana lisätä itselleen lisää rahaa.

#Kayttajat
-Pelaaja syöttää rahaa, valitsee pidettävät kortit 
-Pelin ylläpitäjä voi vaihtaa pelin kiekkoja ja palkitsemislogiikkaa editoimalla JSON-tiedostoja

#Toteutus ja rakenne
Pelin toteutus jakautuu kolmeen eri pääosa-alueeseen.
Visuaaliseen rajapintaan, pää-/pelikierroslogiikkaan sekä voitontarkastukseen.
Paketeissa nämä on rajattu päälogiikkaan (videopokeri), loogisiin oliohin (videopokeri.logic),  voitontarkastukseen (videopokeri.math),
pelaajaan (videopokeri.player) sekä rahaan (videopokeri.money).
Pelin voittoluokat määritellään ulkoisessa tiedostossa

Pääpelilogiikka pitää huolen siitä että pelin tilat etenevät järjestyksessä, sekä siitä että pelaajan syötteisiin reagoidaan tai jätetään reagoimatta näiden tilojen mukaan.

Voitontarkistusluokka math.PokerMath hallinnoi sääntöjä jotka se lataa apuriluokkansa MathLoaderin kautta. Pelin tärkein osa eli pelaajan korttien kohdistaminen mahdollisiin voittoihin tapahtuu Match-luokassa joka vertaa dynaamisesti määriteltyjä voittoyhdistelmiä pelaajan käteen.

Pelaajapaketti sisältää pelaajan (Player) ja tämän lomakkoinstanssin (wallet);

Tämän lisäksi on bet-luokka jonka bethandler hallinnoi sitä panostason vaihtoon joko pelaajan aloitteesta tai rahavarojen riittämättömyyden liittyen.

Pelin voittokädet määritellään JSON-formaatissa ja parsitaan käyttäen Googlen GSON-kirjasto.
