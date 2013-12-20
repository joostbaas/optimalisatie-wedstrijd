optimalisatie-wedstrijd
=======================

Doel
----
Implementeer een algoritme dat het onderstaand optimalisatieprobleem voor de regressietest voor de controlemeldingen zo goed mogelijk oplost.

Probleem
--------
We hebben een regressietest die controleert of alle meldingen nog correct gegenereerd worden. De input voor deze test is een set van dossiers met bladen. Selecteer een set van dossiers die alle meldingen triggeren en minimaliseer daarbij de som van het aantal bladen in de dossiers.

Input
-----
Van elk dossier is bekend welke set meldingen getriggerd wordt en hoeveel bladen er in het dossier zitten. Hiervan wordt een testset ter beschikking gesteld, in de vorm van een tekstbestand.

Output
------
Het programma logt elke minuut wat de op dat moment de beste oplossing is die tot dan toe gevonden is, wat het aantal bladen in de set is, en welke set het betreft. Zie onderstaand voorbeeld.
```
60,3301,Zl,Ah,Rtd,Gn,...
120,2688,Ah,Rtd,Gn,Tl,...
180,2105,Rtd,Gn,Tl,Vl,...
```

Score
-----
De score voor een inzending wordt bepaald door de kwaliteit te wegen van de oplossingen die op verschillende momenten na de start van het algoritme beschikbaar komen. Is op zo’n moment nog geen oplossing beschikbaar die alle meldingen dekt, dan wordt voor die oplossing 0 punten gerekend. tverwerking staat voor de verwerkingstijd van de geselecteerde set dossiers.

|Moment|    Score|	Weging|
|------|---------|--------|
|1 minuut|	1800/tverwerking|	5|
|5 minuten|	1800/tverwerking|	20|
|30 minuten|	1800/tverwerking|	50|
|2 uur|	1800/tverwerking|	20|
|24 uur|	1800/tverwerking|	5|

Overige bepalingen
------------------
*	De inzendingen moeten op maandag 13 januari om 9:00 uur ingediend zijn bij Rob Winkes.
*	Je mag zelf kiezen of je je oplossing in java schrijft of iets anders, maar als je java kiest hoef je alleen het algoritme zelf te schrijven, en wordt het verwerken van input en output voor je afgehandeld. De interface waar je aan moet voldoen wordt beschikbaar gesteld (maar die kan nog wel licht wijzigen, tot maximaal een dag voor de deadline).
*	De logregels moeten wel kloppen, en worden gecontroleerd. Als het opgegeven aantal bladen in de swods niet overeenkomt met het werkelijke aantal geldt voor die regel een score van 0.
*	Alle programma’s worden gedraaid op dezelfde machine, het is nog niet bekend welke.
*	De werkelijke input zal anders zijn dan de testset, maar zal uiteraard wel dezelfde structuur hebben.  De testset heeft 100 regels (dossiers) en 74 kolommen (meldingen), de werkelijke input heeft 600 regels en 105 kolommen.
*	Wanneer een inzending niet voldoet aan alle bepalingen, wordt het programma uitgesloten van deelname.

