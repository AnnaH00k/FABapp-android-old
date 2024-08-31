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

public class RESActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question, qCount, punkte;
    private Button option1, option2, option3, next;
    private List<QuestionRes> questionResList;
    private int quesNum;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_e_s);

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
        questionResList = new ArrayList<>();

        questionResList.add(new QuestionRes("Nennen Sie 2 Wechselzug Schwimmsportarten.", "Schmetterling, Brust", "Freistil, Rückenkraul", "Kraul, Rückenkraul", 3));
        questionResList.add(new QuestionRes("Nennen Sie 2 Gleichzug Schwimmsportarten.", "Brust, Schmetterling", "Kraul, Freistil", "Rückenkraul, Kraul", 1));
        questionResList.add(new QuestionRes("Welche der folgenden Schwimmtechniken, wird als unnatürlich angesehen?", "Kraul", "Brust", "Rückenkraul", 2));
        questionResList.add(new QuestionRes("Nennen Sie die Internationalen Wettkampfschwimmtechniken.", "Brust, Rücken, Schmetterling, Freistil", "Brust, Rücken, Schmetterling, Kraul", "Brust, Altdeutsch, Delphin, Freistil", 1));
        questionResList.add(new QuestionRes("Bei welchen Lagen wird die Rollwende verwendet?", "Bei Schmetterling & Kraul", "Bei Brust & Rückenkraul", "Bei Kraul & Rückenkraul", 3));
        questionResList.add(new QuestionRes("Bei welchen Lagen wird nur die Kippwende verwendet?", "Kraul & Brust", "Brust & Schmetterling", "Rückenkraul & Kraul", 2));
        questionResList.add(new QuestionRes("Wie wird bei der Rollwende angeschlagen?", "Mit beiden Händen gleichzeitig", "Mit mindestens einer Hand", "Mit einem beliebigen Körperteil", 3));
        questionResList.add(new QuestionRes("Wie wird bei der Kippwende (Schmetterling & Brust) angeschlagen?", "Mit beiden Händen gleichzeitig", "Mit mindestens einer Hand", "Mit einem beliebigem Körperteil", 1));
        questionResList.add(new QuestionRes("Wie wird bei der Kippwende (Rückenkraul & Kraul) angeschlagen?", "Mit beiden Händen gleichzeitig", "Mit mindestens einer Hand", "Mit einem beliebigem Körperteil", 2));
        questionResList.add(new QuestionRes("Wodurch erfolgt der Vortrieb beim Brustschwimmen?", "Armzug & Beinschlag", "Beinschlag", "Armzug", 1));
        questionResList.add(new QuestionRes("Was ist die Undulationstechnik?", "Der Brustbeinschlag, bei dem die Knie sich durchgehend berühren.", "Zusätzlicher Vortrieb durch eine Wellenbewegung im Körper, beim Brustschwimmen.", "Eine Kraultechnik, bei der man eine 90° Drehung mit dem Körper durchführt.", 2));
        questionResList.add(new QuestionRes("Zu welchem Zeitpunkt, wird beim Brustschwimmen eingeatmet?", "Während der Schwungphase, beim nach vorne schwingen der Arme.", "Am Ende der Druckphase,wenn die Unterarme sich berühren.", "Am Ende der Zugphase, wenn die Arme auf Höhe der Schultern sind.", 2));
        questionResList.add(new QuestionRes("Wie nennt man den Brustbeinschlag, bei dem die Knie hüftweit geöffnet sind?", "Schwunggrätsche", "Stoßgrätsche", "Undulationstechnik", 1));
        questionResList.add(new QuestionRes("Wie nennt man den Brustbeinschlag, bei dem die Knie weiter als Hüftbreit geöffnet sind?", "Schwunggrätsche", "Undulationstechnik", "Stoßgrätsche", 3));
        questionResList.add(new QuestionRes("Was sind Vorteile der Brustschwimmtechnik?", "Alleiniger Vortrieb durch Arme", "Keine natürliche Bewegungsform", "Gute Orientierungs- & Verständigungsmöglichkeit", 3));
        questionResList.add(new QuestionRes("Was sind Vorteile der Brustschwimmtechnik?", "Natürliche Bewegungsform", "Langsamste Schwimmart", "Längere Gleitphasen zur Entspannung (ausdauernde Leistung)", 3));
        questionResList.add(new QuestionRes("Was sind Nachteile der Brustschwimmtechnik?", "Schnellste Schwimmart", "Natürliche Bewegungsform", "Keine natürliche Bewegungsform", 3));
        questionResList.add(new QuestionRes("Was sind Nachteile der Brustschwimmtechnik?", "Einfache Koordination von Arm- & Beinbewegung", "Einfache Koordination mit der Atmung", "Schwierige Koordination von Arm- & Beinbewegung", 3));
        questionResList.add(new QuestionRes("Wie muss man beim Brustschwimmen anschlagen?", "Mit beiden Händen gleichzeitig, da es eine Gleichzug Schwimmart ist.", "Mit mind. 1 Hand, da es eine Wechselzug Schwimmart ist.", "Mit einem beliebigen Körperteil, da es eine unnatürliche Schwimmart ist.", 1));
        questionResList.add(new QuestionRes("Was bringt es, mit Blick auf die Beine, diese ausgestreckt hoch & runter zu bewegen?", "Es dient dazu, sich an Wasser im Gesicht zu gewöhnen.", "Es bringt nichts.", "Es ist eine Möglichkeit, zur Schwimmschulung des Kraulbeinschlages.", 3));
        questionResList.add(new QuestionRes("Was sind Übungsmöglichkeiten, zur Schwimmschulung des Brustbeinschlages?", "Ständige Wiederholungen.", "Trockenübungen, bei denen man an Land sitzt um den Beinschlag zu proben.", "Mit Blick auf die Beine, diese ausgestreckt hoch & runter bewegen.", 2));
        questionResList.add(new QuestionRes("Was bringt es wie ein Delphin zum Boden zu Tauchen, sich abzustoßen und von der Wasseroberfläche wieder mit dem Kopf voran abzutauchen?", "Es dient der Schwimmschulung des Delphinbeinschlages.", "Es hilft das Lungenvolumen zu vergrößern.", "Es dient dazu, den Spaß am Schwimmen nicht zu verlieren.", 1));
        questionResList.add(new QuestionRes("Welchem Zweck dient die Trockenübung, bei der man auf dem Rücken liegt & die ausgestreckten Beine auf und ab bewegt?", "Diese Trockenübung stärkt die Bauchmuskeln, ist aber nicht hilfreich für das Schwimmtraining.", "Stärkung der Rückenmuskulatur.", "Schwimmschulung des Rückenkraulbeinschlages.", 3));
        questionResList.add(new QuestionRes("Welchem Zweck dient es, beim Kraulschwimmen, mit dem Daumen am Körper bis zur Achsel entlang zu fahren?", "Es dient keinem Zweck.", "Es dient der Schwimmschulung des Kraularmzuges (hoher Ellenbogen).", "Es dient der Abwechslung im Training.", 2));
        questionResList.add(new QuestionRes("Weshalb ist es sinnvoll, zur Schwimmschulung des Brustarmzuges einen Pull Buoy zu verwenden?", "Damit man sich ganz auf den Brustarmzug fokussieren kann.", "Damit man sich ganz auf den Brustbeinschlag fokussieren kann.", "Damit man durch die bessere Wasserlage schneller ist.", 1));
        questionResList.add(new QuestionRes("Wie lässt sich die Schwimmschulung des Delphinarmzuges bei fehlender Kraft gestalten?", "Das Abwechseln der Arme, um die Technik zu üben & Kraft zu sparen.", "Stattdessen den Brustarmzug machen, um wenigstens den Beinschlag zu schaffen.", "Den Delphinarmzug weglassen, bis man mehr Kraft hat.", 1));
        questionResList.add(new QuestionRes("Was ist beim Rückenkraularmzug zu beachten?", "Mit dem kleinen Finger aus dem Wasser, mit dem Daumen wieder eintauchen.", "Mit dem Daumen aus dem Wasser, mit dem kleinen Finger wieder eintauchen.", "Der Ellenbogen ist außerhalb des Wassers an höchster Stelle.", 2));
        questionResList.add(new QuestionRes("Was lässt sich zur Koordination beim Kraulschwimmen sagen?", "Der Mensch gewöhnt sich nur schwer an die Wechselbewegungen beim Kraulschwimmen.", "Da das Kraulschwimmen eine natürliche Schwimmart ist, ist die Koordination bereits recht gut.", "Die Koordination beim Kraulschwimmen bereitet vor allem beim Beinschlag große Probleme.", 2));
        questionResList.add(new QuestionRes("Was hilft, um die Koordination beim Brustschwimmen zu verbessern?", "Da das Brustschwimmen eine natürliche Schwimmart ist, muss die Koordination nicht verbessert werden.", "Das Zählen des Verhältnisses von Armzügen zu Beinschlägen.", "Hampelmänner", 3));
        questionResList.add(new QuestionRes("Wie viele Delphinkicks werden in der Regel pro Delphinarmzug gemacht?", "3 Delphinkicks", "1 Delphinkick", "2 Delphinkicks", 3));
        questionResList.add(new QuestionRes("Welche Wendetechnik kann beim Kraulschwimmen eingesetzt werden?", "Kippwende & Rollwende", "Kippwende", "Rollwende", 1));
        questionResList.add(new QuestionRes("Nennen Sie die Startmöglichkeiten beim Kraulschwimmen.", "Greif Start, Schritt Start", "Kopfsprung, Fußsprung", "Stand Start, Hock Start", 1));
        questionResList.add(new QuestionRes("Bei welchem Start, steht man mit beiden Füßen vorne am Startblock?", "Steh Start / Stand Start", "Schritt Start/ Track Start", "Greif Start/ Grab Start", 3));
        questionResList.add(new QuestionRes("Bei welchem Start steht man in Schrittstellung, mit nur einem Fuß am Start?", "Schritt Start/ Track Start", "Steh Start / Stand Start", "Greif Start/ Grab Start", 1));
        questionResList.add(new QuestionRes("Bei der Kippwende wird mit einer Hand angeschlagen, was geschieht mit der anderen Hand?", "Die andere Hand, wird eng am Körper gehalten, um den Wasserwiederstand zu verringern.", "Die andere Hand, drückt das Wasser nach unten, um den Kipp Vorgang zu beschleunigen.", "Die andere Hand, drückt das Wasser nach oben, um den Kipp Vorgang zu beschleunigen.", 3));
        questionResList.add(new QuestionRes("Bei der Kippwende…", "…werden beide Arme über Wasser nach vorne geführt.", "…wird ein Arm über Wasser nach vorne geführt.", "…werden beide Arme unter Wasser nach vorne geführt.", 2));
        questionResList.add(new QuestionRes("Bei der Rollwende…", "...drücken beide Hände das Wasser in die Richtung der Rollrichtung.", "...drücken beide Hände das Wasser in entgegengesetzte Richtung der Rollrichtung.", "...werden die Hände nahe am Körper gehalten, um den Wasserwiederstand zu verringern.", 2));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen, ist ein Fehler beim Kraularmzug?", "Der Ellenbogen wird hoch aus dem Wasser gehoben.", "Das Wasser wird unter dem Körper nach hinten gedrückt.", "Das Wasser wird neben dem Körper nach hinten gedrückt.", 3));
        questionResList.add(new QuestionRes("Warum kann als Erstschwimmart Rückenschwimmen gelehrt werden?", "Es ist nicht als Erstschwimmart geeignet, da man nicht sieht, wo man hinschwimmt.", "-", "Da es Ideal für die Selbstrettung ist und Kinder frei atmen können", 3));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Rückenschwimmen, bei der die Arme von hinter dem Körper bis zur Schulterhöhe gebracht werden?", "Druckphase", "Schwungphase", "Zugphase", 3));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Rückenschwimmen, bei der das Wasser von der Schulterhöhe bis zur Hüfte geschoben wird?", "Schwungphase", "Zugphase", "Druckphase", 3));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Rückenschwimmen, bei der die Arme aus dem Wasser gehoben und wieder hinter den Kopf gebracht werden?", "Schwungphase", "Zugphase", "Druckphase", 1));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Brustschwimmen, bei der die Arme aus der gestreckten Gleitposition im Halbkreis bis zur Schulterhöhe gebracht werden?", "Schwungphase", "Druckphase", "Zugphase", 3));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Brustschwimmen, bei der die Arme nach vorne ausgestreckt werden", "Druckphase", "Schwungphase", "Zugphase", 2));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Brustschwimmen, bei der die Hände auf Schulterhöhe & vor der Brust zusammen gebracht werden?", "Schwungphase", "Zugphase", "Druckphase", 3));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Kraulschwimmen, bei welcher der Arm von ganz vorne auf Schulterhöhe gebracht wird?", "Druckphase", "Zugphase", "Schwungphase", 2));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Kraulschwimmen, bei welcher der Arm von Schulterhöhe zur Hüfte gebracht wird?", "Druckphase", "Schwungphase", "Zugphase", 1));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Kraulschwimmen, bei welcher der Arm  mit dem Ellenbogen zuerst aus dem Wasser gehoben und nach vorne gebracht wird?", "Schwungphase", "Druckphase", "Zugphase", 2));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Delphinschwimmen, bei der beide Arme gleichzeitig auserhalb des Wassers nach vorne gebracht werden?", "Zugphase", "Schwungphase", "Druckphase", 2));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Delphinschwimmen, bei der die Arme von der Brust nach hinten aus dem Wasser gebracht werden?", "Zugphase", "Schwungphase", "Druckphase", 3));
        questionResList.add(new QuestionRes("Wie nennt man die Phase,beim Delphinschwimmen, bei der beide Arme Schlüssellochförmig bis vor die Brust gebracht werden?", "Druckphase", "Zugphase", "Schwungphase", 2));
        questionResList.add(new QuestionRes("Bei welchem Beinschlag kommt die Bewegung aus dem Knie, anstatt aus der Hüfte?", "Kraul Beinschlag", "Bei keinem Beinschlag", "Rückenkraul Beinschlag", 2));
        questionResList.add(new QuestionRes("Wie nennt man die 3 Phasen eines korrekt durchgeführten Sprunges vom Sprungbrett?", "Vorberreitungsphase, Flugphase, Eintauchphase", "Angang, Flugphase, Eintauchphase", "Vorberreitungsphase, Durchführungsphase, Endphase", 3));
        questionResList.add(new QuestionRes("Welche der folgenden Beschreibungen trifft auf den gestreckten Kopfsprung zu?", "Die Beine & der Körper bleiben bei der Drehung zum kopfwärts Eintauchen gestreckt.", "Die Knie werden bei der Drehung zum kopfwärts Eintauchen unter dem Bauch angehockt.", "Beine bleiben gestreckt, Hände berühren die Füße, Beine werden nach oben gestreckt & es wird nahe am Brett eingetaucht.", 1));
        questionResList.add(new QuestionRes("Die Beine bleiben gestreckt und der Springer berührt mit den Händen die Füße, die Beine streckt er darauf nach oben und er taucht nahe am Brett wieder ins Wasser ein.", "Gestreckter Kopfsprung", "Gehechteter Kopfsprung", "Gehockter Kopfsprung", 2));
        questionResList.add(new QuestionRes("Die Knie werden bei der Drehung zum kopfwärts Eintauchen unter dem Bauch angezogen.", "Gestreckter Kopfsprung", "Gehechteter Kopfsprung", "Gehockter Kopfsprung", 3));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen ist beim Tauchen von besonders großer Bedeutung?", "Nicht mit Schnupfen oder beschädigtem Trommelfell tauchen.", "Nur mit Schwimmbrille tauchen.", "Beim Tauchen nicht ausatmen.", 1));
        questionResList.add(new QuestionRes("Was geschieht beim Druckausgleich?", "Die Luft wird vom Nasen Rachenraum, durch die Ohrtrompete, ins Mittelohr gedrückt.", "Die  überschüssige Luft wird  von der Ohrtrompete (Eustachische Röhre) aus dem Mittelohr gedrückt.", "Die Luft wird von der Ohrtrompete ins Mittelohr gedrückt.", 2));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen beschreibt den Tauchzug?", "Die Arme werden kreisförmig nach hinten zum Oberschenkel geführt.", "Die Arme werden schlüssellochförmig nach hinten zur Hüfte geführt.", "Die Arme werden halbkreisförmig bis zum Bauch geführt", 2));
        questionResList.add(new QuestionRes("Welcher Druck herrscht in 10m Wassertiefe?", "2 bar", "1 bar", "10 bar", 1));
        questionResList.add(new QuestionRes("Aus welchen Gründen muss der Rettungsschwimmer das kopfwärts Tauchen beherrschen?", "Weil es beim Rettungsschwimmabzeichen Silber gefordert wird.", "Um es Badegästen erklären zu können.", "Zum Antauchen an verunglückte Personen.", 3));
        questionResList.add(new QuestionRes("Aus welchen Gründen muss der Rettungsschwimmer das Fußwärts Tauchen beherrschen?", "Bei unbekannten Gewässern", "Weil es beim Rettungsschwimmabzeichen Silber gefordert ist.", "Um es Badegästen erklären zu können.", 2));
        questionResList.add(new QuestionRes("Was bedeutet Ertrinken?", "Wenn eine Person aufgrund von Wasser in der Lunge einen Sauerstoffmangel erleidet.", "Wenn eine Person unter Wasser stirbt.", "Wenn eine Person duch Wasser in der Lunge stirbt.", 3));
        questionResList.add(new QuestionRes("Was bedeutet beinahe ertrinken?", "Eine Person geht unter, kann aber noch gerettet werden und überlebt die folgenden 24h.", "Eine Person geht unter, kann aber noch gerettet werden.", "Eine Person geht unter, kann aber noch gerettet werden und überlebt die folgenden 2h.", 1));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen beschreibt das sogenannte Schwimmbad-Blackout?", "Atemreiz, der durch einen niedrigen O2 Wert ausgelöst wird. Durch Hyperventilieren nach hinten verschoben, Bewusstlos ohne Atemreiz.", "Geschieht, wenn tauchende Menschen sich zu lange unter Wasser aufhalten & wegen Sauerstoffmangel bewusstlos werden.", "Atemreiz, der durch einen erhöhten CO2 Wert ausgelöst wird, Durch Hyperventilieren nach hinten verschoben, Bewusstlos ohne Atemreiz.", 3));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen ist eine Baderegel?", "Nur vom Beckenrand ins Becken springen!", "Nicht vom Beckenrand springen!", "Nur bei den Leitern vom Beckenrand springen!", 2));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen ist eine Baderegel?", "Nicht um Hilfe rufen wenn du keine Hilfe brauchst!", "Scherzhaft um Hilfe rufen ist erlaubt!", "Das Hilfe rufen zur Überprüfung der Reaktion von Schwimmeistern ist erlaubt!", 1));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen ist eine Baderegel?", "Nur mit leerem Magen ins Wasser gehen!", "Nicht mit vollem oder leeren Magen ins Wasser gehen!", "Nur mit vollem Magen ins Wasser gehen!", 2));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen ist eine Baderegel?", "Bei Donner schwimmen ist in Ordnung!", "Nur wenn die Blitze über der Wasserfläche sind muss man aus dem Wasser!", "Bei Gewitter aus dem Wasser gehen!", 3));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen ist eine Baderegel?", "Müll darf überall hin außer ins Wasser!", "Müll wird in den Spinden entsorgt!", "Das Wasser & den Strand nicht verunreinigen!", 3));
        questionResList.add(new QuestionRes("Was bedeutet der Begriff Freistilschwimmen?", "Ein anderes Wort für Kraul schwimmen.", "Es darf jede Wettkampf Stilart geschwommen werden, beim Lagenschwimmen nur Kraul.", "Es darf alles geschwommen werden, außer bei den Lagen dort nur Kraul.", 2));
        questionResList.add(new QuestionRes("Nennen Sie die International gültige Reihenfolge der Stilarten beim Lagenschwimmen.", "Rückenkraul, Brust, Schmetterling, Freistil", "Schmetterling, Brust, Rückenkraul, Freistil", "Schmetterling, Rückenkraul, Brust, Freistil", 3));
        questionResList.add(new QuestionRes("Nennen Sie die International gültige Reihenfolge der Stilarten bei der Lagenstaffel", "Schmetterling, Rückenkraul, Brust, Freistil", "Rückenkraul, Brust, Schmetterling, Freistil", "Rückenkraul, Freistil, Schmetterling, Brust", 2));
        questionResList.add(new QuestionRes("Was ist der Unterschied beim Startkommando für Rücken und dem der anderen Lagen?", "Beim Rückenstart erfolgt kein langer Pfiff.", "Beim Rückenstart erfolgt ein zusätzlicher langer Pfiff.", "Beim Rückenstart erfolgt ein langer Pfiff anstelle des Satzes: Auf die Plätze!", 3));
        questionResList.add(new QuestionRes("Wie lange wird beim Intervalltraining Pause gemacht?", "Bis der Puls Wert von 90 wieder erreicht ist. ", "Bis der Puls Wert von 120 wieder erreicht ist. ", "Bis der Puls Wert von 60 wieder erreicht ist.", 2));
        questionResList.add(new QuestionRes("Was bedeutet Intervalltraining?", "Der Wechsel von Belastung & Erholung.", "Langanhaltendes Training (Ausdauer).", "Training ohne Pausen (hohe Belastung).", 1));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen trifft auf das extensive Intervalltraining zu?", "Reizintensität von 80-90% verantwortlich für kurze Belastungsdauer mit längeren aktiven Pausen.", "Reizintensität von 95-100% verantwortlich für kürzeste Belastungsdauer mit Pausen von 5min. oder länger.", "Reizintensität von 50-70% ermöglicht lange Belastungsdauer mit vielen kurzen, passiven Pausen.", 3));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen trifft auf das intensive Intervalltraining zu?", "Reizintensität von 50-70% ermöglicht lange Belastungsdauer mit vielen kurzen passiven Pausen.", "Reizintensität von 95-100% verantwortlich für kürzeste Belastungsdauer mit Pausen von 5min. oder länger.", "Reizintensität von 80-90% verantwortlich für kurze Belastungsdauer mit längeren aktiven Pausen.", 3));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen trifft auf das Widerholungstraining zu?", "Reizintensität von 50-70% ermöglicht lange Belastungsdauer mit vielen kurzen passiven Pausen.", "Reizintensität von 95-100% verantwortlich für kürzeste Belastungsdauer mit Pausen von 5min. oder länger.", "Reizintensität von 80-90% verantwortlich für kurze Belastungsdauer mit längeren aktiven Pausen.", 2));
        questionResList.add(new QuestionRes("Welche der folgenden Übungen zählen zur „Konditionsgymnastik im Wasser“?", "Jogging am Ort mit Tempowechsel (Mobilisierung des Kreislaufes).", "Kraul Schwimmen.", "Das Liegen auf der Wasseroberfläche.", 1));
        questionResList.add(new QuestionRes("Wie nennt man das Prinzip, bei dem Übungen dem Schwierigkeitsgrad nach aneinandergereiht werden?", "Prinzip der Systematik", "Prinzip der Anschaulichkeit", "Prinzip der Bewusstheit", 1));
        questionResList.add(new QuestionRes("Unter welche Kategorie fallen die 4 Wiederstände: Frontalwiederstand, Reibungswiederstand, Wirbelwiederstand & Wellenwiederstand?", "Wasserwiederstände", "Schwimmwiederstände", "Ohmscher Wiederstand", 1));
        questionResList.add(new QuestionRes("Welcher Wiederstand wirkt auf die Flächen, die bei der Vorwärtsbewegung dem Wasser entgegenstehen?", "Reibungswiedertand", "Frontalwiederstand", "Wellenwiederstand", 2));
        questionResList.add(new QuestionRes("Welcher der folgenden Dinge führt nicht zu einem erhöhten Reibungswiederstand?", "Lose (flatternde) Schwimmbekleidung", "Starke Körperbehaarung", "Glatt rasierter Körper", 3));
        questionResList.add(new QuestionRes("Wo ist der Wirbelwiederstand zu beobachten?", "Hinter dem sich durch das Wasser bewegenden Körper.", "Vor dem sich durch das Wasser bewegenden Körper.", "Um den sich durch das Wasser bewegenden Körper.", 1));
        questionResList.add(new QuestionRes("Welche Maßnahme kann ergriffen werden, um den Wellenwiederstand zu verringern?", "Langsameres Schwimmen.", "Wellenbrechende Überlaufrinnen & Schwimmleinen.", "Der Wellenwiederstand kann nur mit Kraft überwunden werden.", 2));
        questionResList.add(new QuestionRes("Welche Veränderungen bewirkt der Hydrostatische Druck  auf die Atmung?", "Die Einatmung wird schwächer.", "Die Ausatmung wird erschwert.", "Die Atemmuskulatur wird gestärkt.", 3));
        questionResList.add(new QuestionRes("Wie wird die allgemeine Kondition verbessert?", "Lang anhaltende Belastungen (= lange Reizdauer).", "Anstrengende Belastungen (=hohe Reizintensität).", "Kurze Schwimm- oder auch Laufstrecken (= geringer Reizumfang).", 1));
        questionResList.add(new QuestionRes("Was  ist die Grundlage der Sportarten, bei denen es auf langzeitige Leistung ankommt?", "Kondition", "Ausdauer", "Kraft", 2));
        questionResList.add(new QuestionRes("Welche physischen bzw. motorischen Eigenschaften müssen bei der Kondition gegeben sein?", "Kraft, Beweglichkeit, Schnelligkeit, Wissen", "Ausdauer, Kraft, Beweglichkeit, Durchhaltevermögen", "Ausdauer, Kraft, Beweglichkeit, Technik, Schnelligkeit", 3));
        questionResList.add(new QuestionRes("Was deutet objektiv auf die Ermüdung des Sportlers hin?", "Puls- & Atemfrequenz in Ruhe erhöht.", "Abnehmende Aufmerksamkeit.", "Gähnen.", 1));
        questionResList.add(new QuestionRes("Was wird  bei der aeroben Energiegewinnung benötigt?", "Fette", "Kohlenhydrate", "Sauerstoff", 3));
        questionResList.add(new QuestionRes("Was wird bei der anaeroben Energiegewinnung benötigt?", "Kohlenhydrate", "Sauerstoff", "Fette", 1));
        questionResList.add(new QuestionRes("Bei welcher Form des Trainings entsteht Laktat (Milchsäure)?", "Aerob", "Anaerob", "Bei keinem", 2));
        questionResList.add(new QuestionRes("Bei welcher der folgenden Trainingsarten bleibt die Muskelspannung gleich?", "Dynamisches Krafttraining", "Statisches Krafttraining ", "Keine Trainingsart", 2));
        questionResList.add(new QuestionRes("Bei welcher der folgenden Trainingsarten kann die Muskelspannung variieren?", "Statisches Krafttraining", "Keine Trainingsart", "Dynamisches Krafttraining", 3));
        questionResList.add(new QuestionRes("Welche der folgenden Aussagen ist falsch?", "Wegen des Auftriebs im Wasser werden die Muskeln, Knochen & Gelenke weniger belastet.", "Die Muskeln und Gelenke werden beim Schwimmen besonders stark belastet.", "Zunahme der Sauerstoffaufnahme durch volle Ausnutzung der Atemorgane beim Schwimmen.", 2));
        questionResList.add(new QuestionRes("Welche der folgenden Fragen beschreibt die Methodik?", "„Wie gehe ich vor?“", "„Was mache ich mit meiner Gruppe?“", "„Was ist mein Ziel?“", 1));
        questionResList.add(new QuestionRes("Welche der folgenden Fragen beschreibt die Didaktik?", "„Was mache ich mit meiner Gruppe?“", "Wie gehe ich vor?", "„Was ist mein Ziel?“", 1));
        questionResList.add(new QuestionRes("Welches Prinzip ist kein Teil der methodischen Übungsreihe?", "Prinzip vom Bekannten zum Unbekannten.", "Prinzip vom Leichten zum Schweren.", "Prinzip der Entropie.", 2));



      //  questionResList.add(new QuestionRes("", "", "", "", 2));
      //  questionResList.add(new QuestionRes("", "", "", "", 2));
      //  questionResList.add(new QuestionRes("", "", "", "", 2));
      //  questionResList.add(new QuestionRes("", "", "", "", 2));
      //  questionResList.add(new QuestionRes("", "", "", "", 2));



        Collections.shuffle(questionResList);

        setQuestionRes();
    }

    private void setQuestionRes() {
        question.setText(questionResList.get(0).getQuestion());
        option1.setText(questionResList.get(0).getOptionA());
        option2.setText(questionResList.get(0).getOptionB());
        option3.setText(questionResList.get(0).getOptionC());

        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionResList.size()));
        punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionResList.size()));


        quesNum = 0;

    }


    public void launchResInfo(View v) {
        //launch a new activity
        Intent i = new Intent(this, ResInfoActivity.class);
        startActivity(i);
    }

    public void launchResult(View v) {


        Intent intent = new Intent(RESActivity.this, ResultActivity.class);
        intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(quesNum));
        startActivity(intent);
        RESActivity.this.finish();
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

        if (selectedOption == questionResList.get(quesNum).getCorrectAns()) {
            //Right Answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009900")));
            score++;
            punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionResList.size()));






        }

        else if (selectedOption == 4) {
            changeQuestion();
            punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionResList.size()));
        }

        else {
            //Wrong Answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#990000")));

            switch (questionResList.get(quesNum).getCorrectAns()) {
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
        if (quesNum < questionResList.size() - 1) {
            quesNum++;

            playAnim(question, 0, 0);
            playAnim(option1, 0, 1);
            playAnim(option2, 0, 2);
            playAnim(option3, 0, 3);

            qCount.setText(String.valueOf(quesNum + 1) + "/" + String.valueOf(questionResList.size()));
        } else {
            //Go to score Activity
            Intent intent = new Intent(RESActivity.this, ResultActivity.class);
            intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(questionResList.size()));
            startActivity(intent);
            RESActivity.this.finish();
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
                                    ((TextView) view).setText(questionResList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button) view).setText(questionResList.get(quesNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button) view).setText(questionResList.get(quesNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button) view).setText(questionResList.get(quesNum).getOptionC());
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
































