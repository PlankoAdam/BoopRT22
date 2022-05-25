# Riadny termín \[60b], 26.05.2022 10:00
B-OOP 2022

Vytvorte oknovú aplikáciu, ktorá umožní používateľovi kresliť čiary pomocou korytnačky (niečo na štýl programu Imagine). Aplikácia bude mať nasledovnú funkcionalitu (40 bodov):

1. Vytvorenie hlavného okna, ktoré bude obsahovať funkčné Ovládacie prvky (formou menu) a Kresliacu plochu \[10b].
2. Správny tvar korytnačky \[5b].
3. Posun korytnačky pomocou akcie v menu \[10b].
4. Posun korytnačky pomocou klávesnice \[10b].
5. Voľba farby čiary prostredníctvom [JButton](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JButton.html) \[4b].
6. Zatvorenie aplikácie cez tlačidlo na zatvorenie aplikácie poskytnuté operačným systémom \[1b].

## Podrobný popis k bodu 1:

Väčšinu plochy okna bude zaberať Kresliaca plocha. V dolnej časti okna sa budú nachádzať Ovládacie
prvky. Ovládacie prvky budú tvoriť:
1. [JCombobox](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JComboBox.html) ktorý bude slúžiť na zmenu uhlu pohybu korytnačky, pričom možné ulhy sú: {0, 5 ,10, 45, 90 , 180}, počiatočný je 45,
2. [JSlider](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JSlider.html) ktorý bude slúžiť na zmenu veľkosťi kroku korytnačky , pričom slider je nastavený od 0 po 100 s 10 krokom, 10 je počiatočný stav,
3. [JButton](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JButton.html) “Akcia”, ktorý vykoná pohyb korytnačky o vybraný uhol a krok,
4. [JLabel](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JLabel.html) ktorý ukazuje aktuálne zvolenú velkosť kroku a uhol korytnačky,
5. [JButton](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JButton.html) "Farba", ktorý vykoná zmenu farby čiary, ktorú bude najbližšie korytnačka kresliť
6. [JLabel](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JLabel.html) ktorý ukazuje aktuálne zvolenú farbu 

Každý z týchto prvkov musí zaberať šestinu celkového miesta vyhradeného pre ovládacie prvky (napr. Grid 2x3).

## Podrobný popis k bodu 2:

Naša korytnačka sa skladá z dvoch kruhov, tak ako je proporcionálne zobrazené na obrázku.

// TODO obrazok

Tak isto je dôležitá pozícia korytnačky, ktorá by sa mala nachádzat približne v strede kresliacej plochy, tj ak mám okno 700x700, s čoho ovládací panel má cca 200, tak sa korytnačka musí nachádzať cca 350x250.
Korytnačka sa musí nachádzat presne v strede miesta , ktorým kreslíme.

## Podrobný popis k bodu 3:

Stlačením tlačidla Akcia sa má vykonať posun korytnačky o zvolený uhol a krok. Svojím posunom korytnačka v danom smere nakreslí čiaru.

## Podrobný popis k bodu 4:

Korytnačka sa má vedieť pohybovať aj pomocou stlačenia kláves, presne šípiek. 
Stlačením šípky hore sa má korytnačka posunúť o zvolený krok dopredu.
Stlačením šípky dole sa má korytnačka posunúť o zvolený krok dozadu.
Stlačením šípky doľava sa má korytnačka otočíť o zvolený uhol doľava,
Stlačením šípky doprava sa má korytnačka otočiť o zvolený uhol doprava.

## Podrobný popis k bodu 5:

Spomedzi ovládacích prvkov bude Button "Farba" slúžiť na výber farby a Label na grafické znázornenie aktuálne  zvolenej farby. Program umožňuje zvoliť minimálne 3 farby v nejakom fixnom poradí (napr. červená > modrá > zelená). Tlačidlom sa aktívna farba zmení na nasledujúcu farbu v poradí. Pokiaľ sa v zozname farieb nachádzame na poslednom prvku, tak za ním nasleduje opäť prvá farba (t.j. červená > modrá > zelená > červená > ...). Práve kreslené čiary majú farbu zvolenú podľa aktuálnej farby. Farby môžu byť ľubovoľné, podmienkou ale je, aby boli viditeľné na kresliacej ploche. Po výbere farby sa zmení text Label-u podľa aktuálnej farby. Zmena farby ovplyvňuje len nové geometrické tvary, už nakreslené geometrické tvary si musia zachovať svoju farbu!

## Hodnotenie

Projekt obsahuje github pipeline, ktorá kontroluje skompilovateľnosť programu. **Pokiaľ program nie je skompilovateľný nebude hodnotený a skúška bude hodnotená 0b!**

**Pokiaľ budete počas skúšky pristihnutý pri podvádzaní, alebo bude váš kód vykazovať príliš veľkú podobnosť s kódom iných študentov, bude skúška hodnotená 0 bodmi!**

Okrem funkcionality budú hodnotené aj princípy Objektovo orientovaného programovania (20 bodov), budeme hodnotit približne rovnaké veci ako pri druhom zadaní, pre istotu tu niektoré z nich napíšeme:

* správne modifikátory prístupu,
* vhodné pomenovanie tried a metód,
* vhodné využitie dedenia a polymorfizmu
* vhodné použitie výnimiek na ošetrenie nedovoleného správania (nehádzať a nezachytávať všeobecnú triedu Exception),
* stavové premenné ako int,
* duplicitny kód,
* unused kód,
* konvencie,
* použitie keyStroke,
* nepoužitie vnorených tried (nested class),
* nepoužitie statických metód ani nekonštantných statických premenných
* celá hra nakodena v jednej triede,
* inicializacia atributov triedy pri ich vytvoreni,
* kontrola kláves bez java konštánt (VK_)
* vykreslovanie textu cez hracie pole
* keylistener prestane fungovať po použití niečoho v menu,
* Null layout

Za každy nesplnený bod vám možu byť strhnuté cca 3-4 body.

## Odovzdanie

Vypracovanie skúšky odovzdajte cez Github classroom do miesta odovzdania nato určenom. Odovzdáva sa obsah celého projektu. Na vypracovanie písomky je vyhradený čas 3 hodiny.