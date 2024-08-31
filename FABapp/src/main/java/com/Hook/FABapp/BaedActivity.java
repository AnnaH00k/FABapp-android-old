package com.Hook.FABapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BaedActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question, qCount, punkte;
    private Button option1, option2, option3, next;
    private List<QuestionBaed> questionBaedList;
    private int quesNum;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baed);

        question = findViewById(R.id.textView2);
        qCount = findViewById(R.id.Frage);
        punkte = findViewById(R.id.Punkte);


        option1 = findViewById(R.id.button9);
        option2 = findViewById(R.id.button10);
        option3 = findViewById(R.id.button11);
        next = findViewById(R.id.weiter);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        next.setOnClickListener(this);

        getQuestionsList();

        score = 0;
    }

    private void getQuestionsList() {
        questionBaedList = new ArrayList<>();



        questionBaedList.add(new QuestionBaed("Welche Ladung haben die Elementarteilchen Protonen?", "Negativ", "Positiv", "Neutral", 2));
        questionBaedList.add(new QuestionBaed("Welche Ladung haben die Elementarteilchen Neutronen?", "Neutral", "Positiv", "Negativ", 1));
        questionBaedList.add(new QuestionBaed("Welche Ladung haben die Elementarteilchen Elektronen?", "Positiv", "Negativ", "Neutral", 2));
        questionBaedList.add(new QuestionBaed("Atome bestehen aus einem Atomkern & einer Atomhülle, welche Elementarteilchen befinden sich im Atomkern?", "Protonen & Neutronen", "Elektronen", "Neutronen", 1));
        questionBaedList.add(new QuestionBaed("Atome bestehen aus einem Atomkern & einer Atomhülle, welche Elementarteilchen befinden sich in der Atomhülle?", "Protonen", "Neutronen", "Elektronen", 3));
        questionBaedList.add(new QuestionBaed("Wie nennt man Verbindungen aus zwei oder mehr Atomen, die nach außen hin elektrisch neutral sind?", "Neutronen", "Atomverbände", "Moleküle", 3));
        questionBaedList.add(new QuestionBaed("Welche Atommasse haben Elektronen?", "0,005u", "1u", "0,0005u", 3));
        questionBaedList.add(new QuestionBaed("Welche Atommasse haben Protonen?", "0,0005u", "0,005u", "1u", 3));
        questionBaedList.add(new QuestionBaed("Welche Atommasse haben Neutronen?", "0,0005u", "0,005u", "1u", 3));
        questionBaedList.add(new QuestionBaed("Wie setzt sich die Masse eines Atoms fast ausschließlich zusammen?", "Aus den Protonen & Neutronen im Atomkern.", "Aus den Elektronen & Neutronen im Atomkern.", "Aus den Elektronen in der Atomhülle.", 1));
        questionBaedList.add(new QuestionBaed("Welche Elementarteilchen sind für chemische Reaktionen von Bedeutung?", "Elektronen", "Protonen", "Neutronen", 1));
        questionBaedList.add(new QuestionBaed("Wie viele Elektronen müssen auf der Außenschale sein, damit das Atom einen Edelgaszustand hat?", "8 Elektronen", "2 Elektronen auf der 1. Schale / 8 Elektronen", "16 Elektronen", 2));
        questionBaedList.add(new QuestionBaed("Im Periodensystem der Elemente sind Perioden…", "Waagerechte Reihen", "Senkrechte Spalten", "Diagonale Reihen", 1));
        questionBaedList.add(new QuestionBaed("Im Periodensystem der Elemente sind Gruppen…", "Waagerechte Reihen", "Diagonale Reihen", "Senkrechte Spalten", 3));
        questionBaedList.add(new QuestionBaed("Die Nummer der Periode im Periodensystem gibt…", "… die Anzahl der Elektronen auf der äußersten Schale an.", "…die Anzahl der Elektronenschalen an. ", "…die Anzahl der Protonen an.", 2));
        questionBaedList.add(new QuestionBaed("Die Nummer der Hauptgruppe im Periodensystem gibt…", "…die Anzahl der Elektronenschalen an.", "…die Anzahl der Protonen an.", "… die Anzahl der Elektronen auf der äußersten Schale an.", 3));
        questionBaedList.add(new QuestionBaed("Welche Elemente befinden sich in der 7. Hauptgruppe des Periodensystems?", "Chalkogene oder Erzbildner", "Alkalimetalle", "Halogene oder Salzbildner", 3));
        questionBaedList.add(new QuestionBaed("Welches der folgenden Elemente gehört nicht zu den Halogenen?", "Helium", "Chlor", "Astat", 1));
        questionBaedList.add(new QuestionBaed("Welches der folgenden Elemente gehört nicht zu den Halogenen?", "Brom", "Iod", "Selen", 3));
        questionBaedList.add(new QuestionBaed("Welches der folgenden Elemente gehört zu den Halogenen?", "Bor", "Fluor", "Stickstoff", 2));
        questionBaedList.add(new QuestionBaed("Wo finden Sie Chlor im Periodensystem?", "III Hauptgruppe; 7. Periode", "VI Hauptgruppe; 2. Periode", "VII Hauptgruppe; 3. Periode", 3));
        questionBaedList.add(new QuestionBaed("Was bedeutet das chemische Symbol H?", "Helium", "Wasserstoff", "Sauerstoff", 2));
        questionBaedList.add(new QuestionBaed("Was ist das chemische Symbol für Chlor?", "Cl", "C", "Cr", 1));
        questionBaedList.add(new QuestionBaed("Was bedeutet das chemische Symbol N?", "Stickstoff", "Natrium", "Neon", 1));
        questionBaedList.add(new QuestionBaed("Was bedeutet das chemische Symbol Ca?", "Kalium", "Calcium", "Cäsium", 2));
        questionBaedList.add(new QuestionBaed("Was ist das chemische Symbol für Fluor?", "Fl", "Fu", "F", 3));
        questionBaedList.add(new QuestionBaed("Was bedeutet das chemische Symbol Br?", "Beryllium", "Brom", "Bor", 2));
        questionBaedList.add(new QuestionBaed("Was bedeutet das chemische Symbol Fe?", "Fermium", "Eisen", "Francium", 2));
        questionBaedList.add(new QuestionBaed("Was bedeutet das chemische Symbol Cu ?", "Curium", "Calcium", "Kupfer", 3));
        questionBaedList.add(new QuestionBaed("Wie nennt man ein positiv geladenes Ion?", "Kation", "Anion", "Dissoziation", 1));
        questionBaedList.add(new QuestionBaed("Wie nennt man ein negativ geladenes Ion?", "Anion", "Kation", "Ausion", 1));
        questionBaedList.add(new QuestionBaed("Welcher der folgend genannten Punkte gibt im Periodensystem Auskunft über die Anzahl der Elektronen auf der äußersten Schale?", "Die Nummer der Periode", "Die Ordnungszahl", "Die Nummer der Hauptgruppe", 3));
        questionBaedList.add(new QuestionBaed("Wie nennt man die Bindung, die bei Reaktionen von Metallatomen mit Nichtmetallatomen entsteht?", "Ionenbindung", "Kovalente Bindung", "Metallbindung", 1));
        questionBaedList.add(new QuestionBaed("Wie nennt man den Zerfall eines Stoffes in frei bewegliche Ionen?", "Elektrolyse", "Dissoziation", "Hydratation", 2));
        questionBaedList.add(new QuestionBaed("Wie nennt man den Vorgang der Ionenanziehung durch die Pole und deren Entladung zu neutralen Atomen, indem Elektronen an der Anode abgegeben & an der Kathode aufgenommen werden?", "Elektrolyse", "Dissoziation", "Hydratation", 1));
        questionBaedList.add(new QuestionBaed("Was ist eine andere Bezeichnung für Natriumchlorid?", "Backpulver", "Essig", "Kochsalz", 3));
        questionBaedList.add(new QuestionBaed("In was dissoziiert NaCl?", "in die frei beweglichen Ionen Na^- & Cl^+.", "in die frei beweglichen Ionen Na^+ & Cl^-.", "NaCl dissoziiert nicht.", 2));
        questionBaedList.add(new QuestionBaed("Was ist mol?", "Die Ladungseinheit eines Stoffes.", "Die Einheit der „Stoffmenge“.", "Die Einheit des „Stoffgemenges“.", 2));
        questionBaedList.add(new QuestionBaed("Was gibt an, wie viel Mol eines Stoffes in einem Liter Lösung enthalten ist?", "Molmasse", "mol", "Molarität", 3));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Eigenschaften ist keine typische Eigenschaft von Säuren?", "Heben den pH-Wert", "Senken den pH-Wert", "Wirken auf der Haut ätzend", 1));
        questionBaedList.add(new QuestionBaed("Im Schwimmbadbereich werden Säuren bei der Reinigung verwendet. Welche Art von Verschmutzung entfernen Sie?", "Organische Verschmutzungen", "Alle Verschmutzungen", "Anorganische Verschmutzungen", 3));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat die Salzsäure im Schwimmbad?", "Flockung", "pH-Korrektur, löst Verkalkungen", "pH-Korrektur, in Akkus enthalten", 2));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat die Schwefelsäure?", "pH-Korrektur, in Akkus enthalten ", "pH-Korrektur, löst Verkalkungen ", "Flockung", 1));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat die Unterchlorige Säure?", "Saure Reinigungsmittel", "Beckenwasserdesinfektion", "pH-Korrektur", 2));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsbereiche hat die Kohlensäure?", "Saure Reinigungsmittel", "Beckenwasserdesinfektion", "pH-Korrektur", 3));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat die Phosphorsäure?", "pH-Korrektur", "Beckenwasserdesinfektion", "Saure Reinigungsmittel", 3));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Säuren fördert das Algenwachstum und sollte nicht ins Beckenwasser gelangen?", "Phosphorsäure", "Unterchlorige Säure", "Schwefelsäure", 1));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Maßnahmen ist keine Sicherheitsmaßnahme beim Umgang mit Säuren oder Laugen?", "Schutzkleidung tragen", "Arbeitsschuhe mit Stahlkappe tragen", "Schutzbrille Aufsetzen", 2));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Maßnahmen ist keine Sicherheitsmaßnahme beim Umgang mit Säuren oder Laugen?", "Beim Verdünnen erst das Wasser, dann die Säure / Lauge.", "Angaben des Herstellers beachten.", "Beim Verdünnen erst die Säure / Lauge, dann das Wasser.", 3));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Maßnahmen ist keine Sicherheitsmaßnahme beim Umgang mit Säuren oder Laugen?", "Niemals in Getränkeflaschen abfüllen.", "Nicht in Kunststoffflaschen füllen.", "Beim Verdünnen / Umfüllen Trichter, Pumpe verwenden.", 2));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Eigenschaften ist keine typische Eigenschaft von Laugen?", "Senken den pH-Wert.", "Heben den pH-Wert.", "Färben Indikatoren.", 1));
        questionBaedList.add(new QuestionBaed("Im Schwimmbadbereich werden Laugen bei der Reinigung verwendet. Welche Art von Verschmutzung entfernen Sie?", "Anorganische Verschmutzungen", "Alle Verschmutzungen", "Organische Verschmutzungen", 3));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat die Natronlauge im Schwimmbad?", "pH-Korrektur, bei kalkarmem Wasser.", "Dichtigkeitsprüfung von Chlorflaschen.", "pH-Korrektur.", 3));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat Kalkwasser im Schwimmbad?", "pH-Korrektur, bei kalkarmem Wasser. ", "pH-Korrektur.", "Dichtigkeitsprüfung von Chlorflaschen.", 1));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat Ammoniakwasser im Schwimmbad?", "pH-Korrektur. ", "Dichtigkeitsprüfung von Chlorflaschen.", "pH-Korrektur, bei kalkarmem Wasser. ", 2));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat Aluminiumhydroxid im Schwimmbad?", "Dichtigkeitsprüfung von Chlorflaschen.", "pH-Korrektur.", "Flockung.", 3));
        questionBaedList.add(new QuestionBaed("Welche Anwendungsgebiete hat Eisenhydroxid im Schwimmbad?", "pH-Korrektur.", "Flockung.", "Dichtigkeitsprüfung von Chlorflaschen.", 2));
        questionBaedList.add(new QuestionBaed("Was sollten sie tun, wenn ihre Haut mit Säure / Lauge in Berührung gekommen ist?", "Mit viel Wasser spülen. ", "Mit Wasser und Seife spülen.", "Mit trockenem Tuch abwischen.", 1));
        questionBaedList.add(new QuestionBaed("Was entsteht, wenn sich Chlorwasserstoffgas in Wasser löst?", "Salzsäure", "Unterchlorige Säure", "Kohlensäure", 1));
        questionBaedList.add(new QuestionBaed("HCl", "Schwefelsäure", "Salzsäure", "Unterchlorige Säure", 2));
        questionBaedList.add(new QuestionBaed("H2 SO4", "Schwefelsäure", "Salzsäure", "Unterchlorige Säure", 1));
        questionBaedList.add(new QuestionBaed("HClO", "Salzsäure", "Unterchlorige Säure ", "Schwefelsäure", 2));
        questionBaedList.add(new QuestionBaed("Wie reagiert Ammoniakwasser mit Cl2?", "Es entstehen Ammoniakhydroxichloriddämpfe.", "Es reagiert nicht.", "Es entstehen weiße Amoniumchloriddämpfe. ", 3));
        questionBaedList.add(new QuestionBaed("Was entsteht bei der Reaktion von Nichtmetalloxiden mit Wasser?", "Säuren", "Basen", "Hypochloride", 1));
        questionBaedList.add(new QuestionBaed("Was besteht aus positiven Metallionen und negativen Hydroxid-Ionen?", "Säuren", "Laugen", "Unedle Metalle", 2));
        questionBaedList.add(new QuestionBaed("Was gibt der pH-Wert an?", "Hypochloridionenkonzentation", "Hydroxidionenkonzentration", "Wasserstoffionenkonzentration", 3));
        questionBaedList.add(new QuestionBaed("Was ist der negativ dekadische Logarithmus der Wasserstoffionenkonzentration in wässriger Lösung?", "pH-Wert", "Mol Masse", "Dissoziativ wert", 1));
        questionBaedList.add(new QuestionBaed("Von wo bis wo reicht die pH-Wert Skala?", "1 - 12", "0 – 14", "1 - 14", 2));
        questionBaedList.add(new QuestionBaed("Wann ist eine Lösung pH- neutral?", "pH-Wert= 6,2 -7,6", "pH-Wert = 6 -8", "pH-Wert = 7", 3));
        questionBaedList.add(new QuestionBaed("Welchen pH-Wert hat die Haut?", "5,5", "7", "6,2", 1));
        questionBaedList.add(new QuestionBaed("Was kann ein Falscher pH-Wert bewirken?", "gar nichts", "aussetzende Flockung", "Färbung des Wassers", 2));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Aussagen trifft zu, wenn der pH-Wert bei 4 liegt?", "Neutrale Lösung", "Alkalische Lösung", "Saure Lösung", 3));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Aussagen trifft zu, wenn der pH-Wert bei 7 liegt?", "Neutrale Lösung", "Saure Lösung", "Alkalische Lösung", 1));
        questionBaedList.add(new QuestionBaed("Welche der folgenden Aussagen trifft zu, wenn der pH-Wert bei 12 liegt?", "Saure Lösung", "Alkalische Lösung", "Neutrale Lösung", 2));
        questionBaedList.add(new QuestionBaed("Was entsteht, wenn man eine Säure mit einer Base mischt?", "Wasser & Metall", "Ein giftiges Gas", "Wasser & Salz", 3));
        questionBaedList.add(new QuestionBaed("Was entsteht, wenn Säuren mit unedlen Metallen reagieren?", "Wasserstoff & ein Salz", "Salz & Wasser", "Metall Ionen & Gas", 1));
        questionBaedList.add(new QuestionBaed("Was heißt: H2 CO3", "Phosphorsäure", "Kohlensäure", "Schwefelsäure", 2));
        questionBaedList.add(new QuestionBaed("Wie heißen die Salze der Kohlensäure?", "Phosphate", "Chloride", "Carbonate", 3));
        questionBaedList.add(new QuestionBaed("Was heißt: H3 PO4", "Phosphorsäure", "Kohlensäure", "Schwefelsäure", 1));
        questionBaedList.add(new QuestionBaed("Wie heißen die Salze der Phosphorsäure?", "Carbonate", "Phosphate", "Chloride", 2));
        questionBaedList.add(new QuestionBaed("Wie heißen die Salze der Salzsäure?", "Sulfate", "Hypochlorite", "Chloride", 3));
        questionBaedList.add(new QuestionBaed("Wie heißen die Salze der Schwefelsäure?", "Sulfate", "Chloride", "Hypochlorite", 1));
        questionBaedList.add(new QuestionBaed("Wie heißen die Salze der unterchlorigen Säure?", "Sulfate", "Hypochlorite", "Chloride", 2));
        questionBaedList.add(new QuestionBaed("Wie heißen die Salze der schwefeligen Säure?", "Sulfate", "Nitrate", "Sulfite", 3));
        questionBaedList.add(new QuestionBaed("Was ist die chemische Formel von Wasser?", "H2O", "HO2", "O2H", 1));
        questionBaedList.add(new QuestionBaed("Was reichert sich im Regenwasser an, wenn es durch tiefere Erdschichten sickert?", "Öl", "Salze / Mineralien", "Dreck", 2));
        questionBaedList.add(new QuestionBaed("Welches Wasser lässt sich aus Grundwasser, Quellwasser, Oberflächenwasser oder Uferfiltrat gewinnen?", "Regenwasser", "Schwallwasser", "Trinkwasser", 3));
        questionBaedList.add(new QuestionBaed("Welches Wasser entsteht auf undurchlässigen Erdschichten und gelangt durch Quellen wieder an die Oberfläche?", "Grundwasser", "Oberflächenwasser", "Reinwasser", 1));
        questionBaedList.add(new QuestionBaed("Wie nennt man Niederschlagswasser (Regen, Schnee), Flusswasser, Seewasser oder Wasser aus Trinkwassertalsperren?", "Oberflächenwasser", "Grundwasser", "Reinwasser", 2));
        questionBaedList.add(new QuestionBaed("/n /n /n Welche DIN fordert folgende Eigenschaften für Trinkwasser: Darf keine gesundheitsschädigenden Stoffe enthalten.  Coli-Bakterien dürfen in 100ml nicht nachweisbar sein. Gehalt gelöster Stoffe sollte sich in Grenzen halten.  Der Nitrat-Ionen-Gehalt darf 50 mg/l nicht überschreiten.  Die Temperatur: 5°C…15°C, max. 25°C.  Trinkwasser soll nicht zu hart/ aggressiv sein. Es muss klar, farb- & geruchslos sein. Guter Geschmack.", "DIN 1807", "DIN 1993", "DIN 2000", 3));
        questionBaedList.add(new QuestionBaed("Welcher Paragraph des Bundesseuchengesetzes besagt: „Schwimm- oder Badebeckenwasser in öffentlichen Bädern oder Gewerbebetrieben muss so beschaffen sein, dass durch seinen Gebrauch eine Schädigung der menschlichen Gesundheit durch Krankheitserreger nicht zu befürchten ist.“", "§ 11", "§ 12", "§ 24", 1));
        questionBaedList.add(new QuestionBaed("Worauf deuten Coli-Bakterien hin?", "Überschuss an Harnstoffen", "Fäkale Verunreinigungen", "Warme Wassertemperatur", 2));
        questionBaedList.add(new QuestionBaed("Was kann durch Pseudonomas aeroginosa hervorgerufen werden?", "Magen Darm Probleme", "Eine schwere Lungenentzündung", "Eine Ohren-, Augen- und Rachenerkrankung ", 3));
        questionBaedList.add(new QuestionBaed("Was kann durch Legionella pneumophila hervorgerufen werden?", "Eine schwere Lungenentzündung ", "Eine Ohren-, Augen- und Rachenerkrankung", "Magen Darm Probleme", 1));
        questionBaedList.add(new QuestionBaed("Wann hat Wasser seine größte Dichte?", "-2°C", "4°C", "0°C", 2));
        questionBaedList.add(new QuestionBaed("Wie nennt man das Wasser zur Erst- & Nachfüllung?", "Reinwasser", "Filtrat", "Füllwasser", 3));
        questionBaedList.add(new QuestionBaed("Wie nennt man das Wasser, dass der Aufbereitung zugeführt wird?", "Reinwasser", "Filtrat", "Rohwasser", 3));
        questionBaedList.add(new QuestionBaed("Wie nennt man das aufbereitete Wasser nach Einmischen des Desinfektionsmittels?", "Reinwasser", "Rohwasser", "Filtrat", 1));
        questionBaedList.add(new QuestionBaed("Wie nennt man das Aufbereitete Wasser vor Einmischung des Desinfektionsmittels?", "Rohwasser", "Filtrat", "Reinwasser", 2));
        questionBaedList.add(new QuestionBaed("Wie nennt man das Wasser, dass durch das Körpervolumen der Badegäste über die Rinne verdrängt wird?", "Schwallwasser", "Überlaufwasser", "Verdrängungswasser", 3));
        questionBaedList.add(new QuestionBaed("Was ist die durchschnittliche Menge an Verdrängungswasser pro Person?", "65 l /Pers", "90 l/Pers", "75 l/Pers", 3));
        questionBaedList.add(new QuestionBaed("Wie nennt man das Wasser, dass durch Störung des Wasserspiegels in die Rinne strömt?", "Überlaufwasser", "Verdrängungswasser", "Schwallwasser", 3));



       // questionBaedList.add(new QuestionBaed("", "", "", "", 2));
       // questionBaedList.add(new QuestionBaed("", "", "", "", 2));
       // questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));
      //  questionBaedList.add(new QuestionBaed("", "", "", "", 2));






        Collections.shuffle(questionBaedList);

        setQuestionBaed();
    }

    private void setQuestionBaed() {
        question.setText(questionBaedList.get(0).getQuestion());
        option1.setText(questionBaedList.get(0).getOptionA());
        option2.setText(questionBaedList.get(0).getOptionB());
        option3.setText(questionBaedList.get(0).getOptionC());

        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionBaedList.size()));
        punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionBaedList.size()));


        quesNum = 0;

    }


    public void launchBaedInfo(View v) {
        //launch a new activity
        Intent i = new Intent(this, BaedInfoActivity.class);
        startActivity(i);
    }

    public void launchResult(View v) {


        Intent intent = new Intent(BaedActivity.this, ResultActivity.class);
        intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(quesNum));
        startActivity(intent);
        BaedActivity.this.finish();
    }

    public void next(View v) {
        changeQuestion();
    }



    @Override
    public void onClick(View v) {

        int selectedOption = 0;

        switch (v.getId()) {
            case R.id.button9:
                selectedOption = 1;
                break;

            case R.id.button10:
                selectedOption = 2;
                break;

            case R.id.button11:
                selectedOption = 3;
                break;

            case R.id.weiter:
                selectedOption = 4;
                break;

            default:
        }

        checkAnswer(selectedOption, v);

    }


    private void checkAnswer(int selectedOption, View view) {

        if (selectedOption == questionBaedList.get(quesNum).getCorrectAns()) {
            //Right Answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009900")));
            score++;
            punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionBaedList.size()));






        }

        else if (selectedOption == 4) {
            changeQuestion();
            punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionBaedList.size()));
        }

        else {
            //Wrong Answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#990000")));

            switch (questionBaedList.get(quesNum).getCorrectAns()) {
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009900")));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009900")));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009900")));
                    break;
            }
        }



    }



    private void changeQuestion() {
        if (quesNum < questionBaedList.size() - 1) {
            quesNum++;

            playAnim(question, 0, 0);
            playAnim(option1, 0, 1);
            playAnim(option2, 0, 2);
            playAnim(option3, 0, 3);

            qCount.setText(String.valueOf(quesNum + 1) + "/" + String.valueOf(questionBaedList.size()));
        } else {
            //Go to score Activity
            Intent intent = new Intent(BaedActivity.this, ResultActivity.class);
            intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(questionBaedList.size()));
            startActivity(intent);
            BaedActivity.this.finish();
        }

    }

    private void playAnim(View view, final int value, int viewNum) {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(300)
                .setStartDelay(0).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (value == 0) {
                            switch (viewNum) {
                                case 0:
                                    ((TextView) view).setText(questionBaedList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button) view).setText(questionBaedList.get(quesNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button) view).setText(questionBaedList.get(quesNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button) view).setText(questionBaedList.get(quesNum).getOptionC());
                                    break;
                            }

                            if(viewNum != 0)
                                ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#b0e0e6")));

                            playAnim(view, 1, viewNum);
                        }

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }
}