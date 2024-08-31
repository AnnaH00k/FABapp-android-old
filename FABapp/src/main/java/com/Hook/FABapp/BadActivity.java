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

public class BadActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question, qCount, punkte;
    private Button option1, option2, option3, next;
    private List<QuestionBad> questionBadList;
    private int quesNum;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad);

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

    private void getQuestionsList() { questionBadList = new ArrayList<>();



          questionBadList.add(new QuestionBad("Von wo aus sollte die Aufsicht bei Badegewässern erfolgen?", "Aus 50m Entfernung.", "Von einem erhöhten Standplatz.", "Von der Wasseroberfläche aus.", 2));
          questionBadList.add(new QuestionBad("Bei Badegewässern muss ein Erste Hilfe Raum / Zelt von wie vielen Quadratmetern vorhanden sein?", "6m²", "7m²", "12m²", 1));
          questionBadList.add(new QuestionBad("Ab wie vielen Metern Strandlänge wird 1 Boot mit Rettungsausrüstung benötigt, dass patrouliert oder einsatzbereit am Strand liegt?", "100m", "200m", "300m", 2));
          questionBadList.add(new QuestionBad("Welches Becken kann man zum: Schwimmen, Wasserspringen, Tauchen, Synchronschwimmen, Ausbildung im Rettungsschwimmen nutzen?", "Springerbecken", "Variobecken", "Lehrschwimmbecken", 1));
          questionBadList.add(new QuestionBad("Wie viele Personen dürfen eine Sprunganlage betreten?", "Eine beliebige Anzahl von Personen.", "2 Personen.", "1 Person.", 3));
          questionBadList.add(new QuestionBad("Wie ist die Aufsicht während der Bedienung von Hubböden, bei Badebetrieb durchzuführen?", "Der Hubboden darf nur bedient werden, wenn kein Badebetrieb stattfindet.", "Im Becken dürfen sich Badegäste aufhalten, auf diese wird jedoch verstärkt geachtet.", "Das Becken muss von Badegästen geräumt sein.", 3));
          questionBadList.add(new QuestionBad("Wie groß dürfen unverdeckte Öffnungen im Boden / den Beckenwänden von Hubböden sein?", "Unverdeckte Öffnungen sind verboten.", "12mm", "8mm", 3));
          questionBadList.add(new QuestionBad("Bei Hubböden muss stets ein untenliegender Freiraum sein, der von Befugten jederzeit zugänglich sein muss. Wie groß ist dieser Freiraum mindestens?", "1,2m", "1,7m", "0,6m", 3));
          questionBadList.add(new QuestionBad("Was sollte man bei Wellenbecken idealerweise verwenden um die Böden rau zu machen?", "Sand", "Teppiche", "Strukturierte Fliesen", 3));
          questionBadList.add(new QuestionBad("Vor der Wellenaustrittsöffnung von Wellenbecken sind Gitter mit parallelen, senkrechten, abgerundeten Stäben mit max. wie viel Abstand anzuordnen?", "12cm", "8mm", "7cm", 1));
          questionBadList.add(new QuestionBad("Welche Farbe haben die Symbole von Rettungszeichen?", "Weiß", "Schwarz", "Grün", 1));
          questionBadList.add(new QuestionBad("Welche Farbe hat der Hintergrund von Rettungszeichen?", "Weiß", "Grün", "Rot", 2));
          questionBadList.add(new QuestionBad("Auf welche Sicherheitsmaßnahmen müssen Sie bei Rettungswegen achten?", "„Panikverschlüsse“", "Offene Türen", "Rutschfester Boden", 1));
          questionBadList.add(new QuestionBad("Wodurch werden stehende Wasserflächen auf dem Boden im Nassbereich verhindert?", "Regelmäßiges Trockenwischen.", "Durch Verdunsten.", "Bodengefälle & Bodenabläufe.", 3));
          questionBadList.add(new QuestionBad("Wo können Natursteinplatten, Teppichboden und keramisches Fliesenmaterial im Schwimmbad zum Einsatz kommen?", "Nassbereich", "Stiefel- oder Trockenbereich", "Saunaböden", 2));
          questionBadList.add(new QuestionBad("Wo befindet sich das Trennseil eines Kombibeckens?", "Über dem Bodenknick, auf / über der Wasseroberfläche.", "50cm vor dem Bodenknick, auf / über der Wasseroberfläche.", "1m vor dem Bodenknick, auf / über der Wasseroberfläche.", 3));
          questionBadList.add(new QuestionBad("Was trennt zur Wellenberuhigung die Schwimmbahnen ab?", "Trennseil", "Begrenzungsseile", "Trennleinen", 3));
          questionBadList.add(new QuestionBad("Wie sind die Farben von Trennleinen nach FINA?", "Weiß-gelb, die letzten 5m rot. ", "Weiß-rot, die letzten 5m rot.", "Weiß-blau, die letzten 5m rot.", 1));
          questionBadList.add(new QuestionBad("Die Handläufe bei Beckenausstiegsleitern bestehen aus zwei unterschiedlich hohen Holmen. Ein Holm = >75cm, wie viel höher muss der zweite Holm sein?", "30cm", "45cm", "20cm", 3));
          questionBadList.add(new QuestionBad("Wie groß muss die Stufentiefe bei Leitern & Treppen im Nassbereich eines Bades sein?", "1m", ">150mm", ">125mm", 2));
          questionBadList.add(new QuestionBad("Was sind die 5 Arten von Sicherheitskennzeichnungen?", "Gefahren-, Verbots-, Warn-, Rettungs- & Hinweiszeichen", "Verbots-, Gefahren-, Warn-, Rettungs- & Zusatzzeichen", "Verbots-, Warn-, Gebots-, Rettungs- & Hinweiszeichen ", 3));
          questionBadList.add(new QuestionBad("Welches Zeichen besteht aus einem runden Schild, mit roter Umrandung, einem roten Querbalken & einer schwarzen Skizze auf weißem Grund?", "Gebotszeichen", "Verbotszeichen", "Warnzeichen", 2));
          questionBadList.add(new QuestionBad("Welches Zeichen besteht aus einem dreieckigen Schild, mit schwarzer Umrandung & einer schwarzen Skizze auf gelben Grund?", "Warnzeichen", "Gebotszeichen", "Verbotszeichen", 1));
          questionBadList.add(new QuestionBad("Wodurch können sie den Hautkontakt beim Arbeiten mit saurem Reiniger vermeiden?", "Durch persönliche Schutzausrüstung.", "Allein durch vorsichtiges Arbeiten.", "Gar nicht.", 1));
          questionBadList.add(new QuestionBad("Wer muss in einem Badebetrieb die Schutzausrüstung stellen?", "Der Arbeitnehmer", "Der Badebetrieb", "Die Krankenkasse", 2));
          questionBadList.add(new QuestionBad("Welche der folgenden Ausrüstungen gehört nicht zur Schutzausrüstung?", "Gummistiefel", "Sicherheitsschuhe", "Flip-Flops", 3));
          questionBadList.add(new QuestionBad("Welche der folgenden Ausrüstungen gehört nicht zur Schutzausrüstung?", "Schutzschürze", "Schütz Schalter", "Atemschutzgeräte", 2));
          questionBadList.add(new QuestionBad("Ab wann wird ein Gehörschutz gebraucht?", "Ab 20 dB", "Ab 85 dB", "Ab 47 dB", 2));
          questionBadList.add(new QuestionBad("Welche Maßnahmen können sie ergreifen, um ihre Schutzausrüstung zu pflegen?", "In die Sonne hängen.", "Mit Ölen einschmieren.", "Abwaschen von Chemikalien mit Wasser.", 3));
          questionBadList.add(new QuestionBad("Was darf man gefahrlos mit Glastüren im Hallenbad machen?", "Sie mit Türdämpfer zufallen lassen.", "Sie verkeilen.", "Sie zuwerfen.", 1));
          questionBadList.add(new QuestionBad("Was ist eine Sicherheitsmaßnahme für Glastüren?", "Kenntlich machen der Glasfläche mit Klebefolie.", "Reinigen mit stark alkalischem Reinigungsmittel.", "Am besten die Tür offen stehen lassen.", 1));
          questionBadList.add(new QuestionBad("Warum muss neben dem Drehkreuz eine zusätzliche Öffnung vorhanden sein?", "Damit bei defektem Drehkreuz kein Zugang möglich ist.", "Damit der Eingang eine symmetrische Optik besitzt.", "Für Menschen mit Behinderung/ mit Kinderwagen.", 3));
          questionBadList.add(new QuestionBad("Welche der folgenden Voraussetzungen gilt nicht für Verkehrswege in öffentlichen Bädern?", "Verkehrswege dürfen nur durch Zapfstellen und Wärmebänke eingeengt werden.", "Keine Stolperstellen, eben & rutschhemmend ausgeführt, leicht zu reinigen.", "Durch Bodengefälle & Bodenabläufe müssen Wasseransammlungen vermieden werden.", 1));
          questionBadList.add(new QuestionBad("Dürfen sich automatisch öffnende Türen in Rettungswegen befinden?", "Ja", "Ja, solange sie der entsprechenden Richtlinie entsprechen.", "Nein", 2));
          questionBadList.add(new QuestionBad("Von wem wird die Haus- & Badeordnung erlassen?", "Vom Vertreter der Kommune, Bürgermeister.", "Vom Badleiter.", "Vom Betriebsrat.", 1));
          questionBadList.add(new QuestionBad("Wofür steht HBO?", "Hallenbad Ordnung", "Home Box Office", "Haus- & Badeordnung", 3));
          questionBadList.add(new QuestionBad("Was entspricht der HBO in einem Privatbad?", "Satzung", "Allgemeine Geschäftsbedingungen", "Allgemeine Satzung", 2));
          questionBadList.add(new QuestionBad("Was entspricht der HBO in einem öffentlich-rechtlichen Badebetrieb?", "Allgemeine Geschäftsbedingungen", "Satzung", "Allgemeine Satzung", 2));
          questionBadList.add(new QuestionBad("Warum gibt es eine HBO?", "Legt die Etikette fest.", "Um Vorschriften bezüglich der Baumaßnahmen festzulegen.", "Um die Rechte & Pflichten der Badegäste und des Badbetreibers zu regeln.", 3));
          questionBadList.add(new QuestionBad("Welche der folgenden Inhalte ist kein wesentlicher Inhalt der Haus- & Badeordnung?", "Dienstanweisungen", "Zutrittsregelungen", "Benutzungsordnung", 1));
          questionBadList.add(new QuestionBad("Welche der folgenden Inhalte ist kein wesentlicher Inhalt der Haus- & Badeordnung?", "Verhaltensregelungen", "Hygienebestimmungen", "Sicherheitsbestimmungen", 3));
          questionBadList.add(new QuestionBad("Welche der folgenden Inhalte ist kein wesentlicher Inhalt der Haus- & Badeordnung?", "Haftung des Badbetreibers", "Schwimmanweisung", "Fundsachenbehandlung", 2));
          questionBadList.add(new QuestionBad("Welche der folgenden Inhalte ist kein wesentlicher Inhalt der Haus- & Badeordnung?", "Handtuchverordnung", "Fundsachenbehandlung", "Geld- & Wertsachenaufbewahrung", 1));
          questionBadList.add(new QuestionBad("Wem darf der Zutritt zu einem Bad nicht verweigert werden?", "Personen die Volltrunken sind.", "Unfreundlichen Personen.", "Personen mit ansteckenden Erkrankungen.", 2));
          questionBadList.add(new QuestionBad("Wo muss die Haus- & Badeordnung genau aushängen?", "An beliebiger Stelle im Bad.", "Auf der Internetseite.", "Gut sichtbar im Eingangsbereich, vor dem Kauf.", 3));
          questionBadList.add(new QuestionBad("Wodurch wird die Haus-& Badeordnung vom Kunden anerkannt?", "Beim Unterschreiben.", "Beim Betreten des Schwimmbadgeländes.", "Beim Zahlen des Eintrittspreises.", 3));
          questionBadList.add(new QuestionBad("Was ist eine Dienstanweisung?", "Weisung an das Badpersonal zur korrekten Durchführung der Arbeitsinhalte.", "Weisung an den Badegast zum korrekten Verhalten im Bad.", "Weisung an den Dienstleiter, zum korrekten Ausführen der Betriebsaufsicht.", 1));
          questionBadList.add(new QuestionBad("Welche der folgenden Inhalte ist kein wesentlicher Inhalt der Dienstanweisung?", "Die Weisungsbefugnis des Personals.", "Die Bestätigung des Personals. ", "Die Zuständigkeiten des Personals.", 2));
          questionBadList.add(new QuestionBad("Welcher der folgenden Inhalte ist kein wesentlicher Inhalt der Dienstanweisung?", "Die Pflichten des Personals.", "Die erforderlichen Sicherheitsmaßnahmen.", "Das soziale Verhalten.", 3));
          questionBadList.add(new QuestionBad("Welcher der folgenden Inhalte ist kein wesentlicher Inhalt der Dienstanweisung?", "Die Einhaltung der Bestimmungen zum Arbeitsschutz.", "Vorschriften zur Arbeitsmoral.", "Technische Anweisungen.", 2));
          questionBadList.add(new QuestionBad("Welche der folgenden Inhalte muss nicht in einer Unfallmeldung angegeben sein?", "Beschreibung der Verantwortlichkeiten & Kompetenzen.", "Unfallort", "Datum & Uhrzeit des Unfalls.", 1));
          questionBadList.add(new QuestionBad("Welche der folgenden Inhalte muss nicht in einer Unfallmeldung angegeben sein?", "Name, Anschrift und Alter der Verletzten.", "Laufende Nummer.", "Zeugen / Namen des Ersthelfers.", 3));
          questionBadList.add(new QuestionBad("Welche der folgenden Inhalte gehören nicht in eine technische Dienstanweisung „Verhalten bei Feuer“?", "Personen mit besonderen Aufgaben (Führungskräfte).", "Flucht- & Rettungswege.", "Berechnung des Räumungspersonals.", 3));
          questionBadList.add(new QuestionBad("Welcher der folgenden Inhalte gehört nicht in einen Chloralarmplan?", "Schaltplan für technisches Sicherungssystem.", "Anlagenbeschreibung.", "Stoffmerkmale Chlor.", 1));
          questionBadList.add(new QuestionBad("Welcher der folgenden Inhalte gehört nicht in einen Chloralarmplan?", "Verhalten im Gefahrfall.", "Chlorgasbescheid", "Hinweise für die Feuerwehr.", 2));
          questionBadList.add(new QuestionBad("Welcher der folgenden Inhalte gehört nicht in einen Chloralarmplan?", "Erste Hilfe", "Notfallausrüstung", "Bergbehälter", 3));
          questionBadList.add(new QuestionBad("Welche der folgenden Aussagen ist korrekt?", "Unterweisungen & Dienstanweisungen haben in keiner Weise bezug zueinander.", "Unterweisungen können auch Bestandteile von Dienstanweisungen sein.", "Dienstanweisungen können auch Bestandteile von Unterweisungen sein.", 2));
          questionBadList.add(new QuestionBad("Welche der folgenden Beschreibungen, beschreibt das Dienstgeheimnis?", "Dienstliche Angelegenheiten, über die Schweigepflicht besteht.", "Die Geheimhaltung der Dienstzeiten.", "Das Geheime Motto des Bades.", 1));
          questionBadList.add(new QuestionBad("Welche der folgenden Dinge ist ein Beispiel für ein Dienstgeheimnis?", "Der Aufbewahrungsort des Geldes.", "Die Öffnungszeiten.", "Die Aufbewahrung der zu verleihenden Materialien.", 1));
          questionBadList.add(new QuestionBad("Welche der folgenden Faktoren ist nicht relevant für den Personalbedarf eines Schwimmbades?", "Art & Größe des Bades.", "Eintrittspreis", "Angebote (Wasserattraktionen).", 2));
          questionBadList.add(new QuestionBad("Welche der folgenden Faktoren ist nicht relevant für den Personalbedarf eines Schwimmbades?", "Überschaubarkeit des Bades.", "Größe des Schwimmmeisterraumes. ", "Nutzung im Parallelbetrieb zu Schulen.", 2));
          questionBadList.add(new QuestionBad("Wo finden Sie Regelungen über die Arbeits- & Pausenzeiten?", "Im Arbeitszeitgesetz.", "Im Arbeitsschutzgesetz.", "Im Arbeitssicherheitsgesetz.", 1));
          questionBadList.add(new QuestionBad("Wie nennt man einen Unterlassungsdelikt, in dem der Badbetreiber für den Schaden haften muss.", "Betrieblicher Unterlassungsdelikt.", "Organisationsverschulden.", "Betriebshaftpflicht.", 2));
          questionBadList.add(new QuestionBad("Wie nennt man eine Person, welche durch eine Fachkraft über die Risiken und Gefahren der ihr übertragenen Aufgaben unterrichtet und eingewiesen wurde?", "Fachkundige Person", "Sachverständige Person", "Unterwiesene Person ", 3));
          questionBadList.add(new QuestionBad("Welche Person ist zur Ausübung einer Tätigkeit vom Arbeitgeber berechtigt?", "Befugte Person", "Unterwiesene Person", "Sachkundige bzw. befähigte Person", 1));
          questionBadList.add(new QuestionBad("Wie nennt man eine Person, mit einer besonderen Sachkunde und einer hohen fachliche Expertise?", "Fachkundige Person", "Sachkundige Person", "Sachverständige Person", 3));
          questionBadList.add(new QuestionBad("Wie nennt man eine Person, die ihre Fachkunde durch Teilnahme an einem behördlich anerkannten Sachkundelehrgang erweitert hat?", "Fachkundige Person", "Sachkundige Person", "Sachverständige Person", 2));
          questionBadList.add(new QuestionBad("Wie nennt man den Plan, der einen Überblick über die Gliederung und Organisationseinheiten der Gemeindeverwaltung mit den dazugehörigen Aufgaben gibt? ", "Verwaltungsgliederungsplan", "Organigramm", "Gemeindeverwaltungsplan", 1));
          questionBadList.add(new QuestionBad("Welche Strafe kann es, nach §353b StGB, bei der Verletzung eines Dienstgeheimnisses geben?", "Geldstrafe", "Freiheitsstrafe", "Geld- oder Freiheitsstrafe", 3));
          questionBadList.add(new QuestionBad("Welche der folgenden Ämter ist für die Öffentlichkeitsarbeit im Bereich Sport zuständig?", "Öffentlichkeitsamt", "Sport- & Bäderamt ", "Amt für Sport & Öffentlichkeit", 2));
          questionBadList.add(new QuestionBad("Welche der folgenden Ämter ist für die Förderung von Integration und Inklusion im Sport zuständig?", "Sport- & Bäderamt", "Sozialamt", "Inklusionsamt", 1));
          questionBadList.add(new QuestionBad("Welche der folgenden Ämter ist für die Gewährleistung des Schulsports zuständig?", "Lehramt", "Schulamt", "Sport- & Bäderamt", 3));
          questionBadList.add(new QuestionBad("Wie nennt man einen meist zusätzlichen Inhalt im Rahmen der Tätigkeitsbeschreibung bei einem Arbeitsvertrag?", "Verbindliche Arbeitsbeschreibung", "Verbindliche Stellenbeschreibung", "Unverbindliche Tätigkeitsbeschreibung", 2));
          questionBadList.add(new QuestionBad("Was muss in einer Arbeitsplatzbeschreibung aufgelistet werden?", "Aufgaben, die täglich, wöchentlich, monatlich oder auch bei Bedarf ausgeführt werden. ", "Aufgaben, die täglich, wöchentlich, monatlich ausgeführt werden.", "Aufgaben, die täglich, wöchentlich ausgeführt werden.", 1));
          questionBadList.add(new QuestionBad("Welcher der folgenden Gründe ist kein Grund für einen erhöhten Personalbedarf im Schwimmbad?", "Art & Größe des Bades", "Angebote (Wasserattraktionen und Animationen)", "Preiserhöhungen", 3));
          questionBadList.add(new QuestionBad("Welcher der folgenden Gründe ist kein Grund für einen erhöhten Personalbedarf im Schwimmbad?", "Angebote des Essensautomaten.", "Überschaubarkeit des Bades und der Becken (Aufsichtsbereiche).", "Frequentierung und die Möglichkeit der Teilnutzung.", 1));
          questionBadList.add(new QuestionBad("Welches Alter ist erforderlich, um in einem öffentlichen Schwimmbad die Wasseraufsicht auszuüben?", "Mindestalter 16 Jahre", "Mindestalter 18 Jahre", "Mindestalter 17 Jahre", 2));
          questionBadList.add(new QuestionBad("Welche der folgenden Angaben wird nicht benötigt, um in einem öffentlichen Schwimmbad die Wasseraufsicht auszuüben?", "Ausbildung in erster Hilfe und HLW.", "Vertrautheit mit dem Bad (1. Hilfe Ausstattung & Betriebsabläufe).", "Mindestens das Rettungsschwimmabzeichen Gold.", 3));
          questionBadList.add(new QuestionBad("Welcher der folgenden Punkte begründet nicht, weshalb die Dienstbekleidung vom Badpersonal getragen wird?", "Garantiert ein Gemeinschaftsgefühl unter Kollegen", "Kenntlichmachung des Badpersonals", "Verleihung von Autorität", 1));
          questionBadList.add(new QuestionBad("Wer erstellt eine „Entgeltordnung“ für ein Schwimmbad?", "Der Arbeitgeber", "Der Bund und Die Gewerkschaften", "Das Sport- & Bäderamt", 2));
          questionBadList.add(new QuestionBad("Wie nennt man es, wenn der Badegast durch das Lösen der Eintrittskarte das Recht auf eine zeitlich begrenzte Nutzung aller Badeeinrichtungen hat?", "Mietvertragsrecht", "Hausrecht", "Nutzungsrecht", 3));
          questionBadList.add(new QuestionBad("Wozu zählen die folgend aufgelisteten Punkte: Hausrecht; Ordnugsrecht (SOS); Kassenrecht; Jedermanns-Recht (Recht auf Feststellung der Personalien oder sogar auf eine vorläufige Festnahme unter bestimmten Voraussetzungen)?", "Rechte des Badbetreibers ", "Rechte des Badegastes", "Rechte von Badbetreiber & Badegast", 1));
          questionBadList.add(new QuestionBad("Wozu zählen die folgend aufgelisteten Punkte: Nutzungsrecht aller Angebote & Leistungen des Bades ohne Einschränkung; Sicherheit,Ordnung, Sauberkeit(SOS); Minderung des Eintritts (Wenn nicht alle Attraktionen und Leistungen des Bades genutzt werden können und beim Vertragsabschluss nicht darauf hingewiesen wurde); Unversehrtheit der Gesundheit; Rechte des Finders: Finderlohn oder Eigentumserwerb.", "Rechte des Badbetreibers", "Rechte des Badegastes", "Rechte von Badbetreiber & Badegast", 2));
          questionBadList.add(new QuestionBad("Wozu zählen die folgend aufgelisteten Punkte: Verkehrssicherungspflicht; Aufsichtspflicht; Überwachungspflicht; Pflicht zur Leistung von erster Hilfe.", "Pflichten von Badbetreiber & Badegast", "Pflichten des Badegastes", "Pflichten des Badbetreibers", 3));
          questionBadList.add(new QuestionBad("Wozu zählen die folgend aufgelisteten Punkte: Ordnungspflicht: Pflicht alles zu unterlassen, was zum Schaden des Vertragspartners (Badbetreiber) oder anderen Badegästen führen könnte; Pflicht, dem Badpersonal Folge zu leisten.; Einhaltung der HBO; Pflicht zur Leistung von Erster Hilfe", "Pflichten des Badegastes", "Pflichten des Badbetreibers ", "Pflichten von Badbetreiber & Badegast", 1));
          questionBadList.add(new QuestionBad("Welche Voraussetzung muss nicht vorliegen, um eine vorläufige Festnahme durchführen zu können?", "Räumlicher und zeitlicher Zusammenhang", "Vorhandenes Vorstrafenregister", "Tat muss tatsächlich begangen worden sein.", 2));
          questionBadList.add(new QuestionBad("Welche Voraussetzung muss nicht vorliegen, um eine vorläufige Festnahme durchführen zu können?", "Fluchtverdacht", "Dem Festgenommenen ist der Grund bekanntzugeben.", "Gewalttätiges Verhalten", 3));
          questionBadList.add(new QuestionBad("Wie nennt man diejenige Verteidigung, welche erforderlich ist, um einen gegenwärtigen rechtswidrigen Angriff von sich oder einem anderen abzuwenden?", "Notwehr", "Notstand", "Nothilfe", 1));
          questionBadList.add(new QuestionBad("Wie nennt man den Zustand gegenwärtiger Gefahr für rechtlich geschützte Interessen einer Person, dessen Abwendung nur auf Kosten fremder Interessen möglich ist?", "Notwehr", "Notstand", "Nothilfe", 2));
          questionBadList.add(new QuestionBad("Wie nennt man die Pflicht, dem Badegast alle Bereiche & Einrichtungen so zur Verfügung zu stellen, dass er, bei Beachtung der „im Verkehr üblichen Sorgfalt“ keinen Schaden erleiden kann?", "Überwachungspflicht", "Ordnungspflicht", "Verkehrssicherungspflicht", 3));
          questionBadList.add(new QuestionBad("Was sollte vor Betriebsbeginn und bei Bedarf auch während der Betriebszeit geprüft werden?", "Die Verkehrssicherheit.", "Der Füllstand der Kaffeemaschine.", "Die Vollständigkeit der zu verleihenden Materialien.", 1));
          questionBadList.add(new QuestionBad("Von wem wird die Haushaltssatzung erlassen?", "Gemeindevertretung/ Kreistag in öffentlicher Sitzung.", "Gemeindevertretung/ Kreistag in geschlossener Sitzung.", "Gemeindevertretung/ Ratsversammlung/ Kreistag in öffentlicher Sitzung.", 3));
          questionBadList.add(new QuestionBad("Wie nennt man die Rechtsgrundlage für die Umsetzung des Haushaltsplans?", "Haushaltsvorschrift", "Haushaltssatzung", "Haushaltsplan Verordnung", 2));
          questionBadList.add(new QuestionBad("Wie nennt man den mind. jährlich stattfindenden Prozess, in einem Unternehmen, bei dem für einzelne Einheiten (Geschäftsbereiche, Abteilungen, Kostenstellen) deren zur Verfügung stehende finanzielle Mittel für das nächste Jahr geplant und genehmigt werden?", "Budgetierung", "Finanzierung", "Kostenantrag", 1));
          questionBadList.add(new QuestionBad("Welche der folgenden Aussagen beschreibt den Intrapersonenkonflikt?", "Konflikte zwischen den Personen A & B", "Konflikte innerhalb der Gruppe A", "Konflikte innerhalb der Person A ", 3));
          questionBadList.add(new QuestionBad("Welche der folgenden Aussagen beschreibt den Interpersonenkonflikt?", "Konflikte innerhalb der Person A", "Konflikte zwischen den Personen A & B ", "Konflikte innerhalb der Gruppe A", 2));
          questionBadList.add(new QuestionBad("Welche der folgenden Aussagen beschreibt den Intragruppenkonflikt?", "Konflikte innerhalb der Gruppe A", "Konflikte zwischen Gruppe A & B", "Konflikte zwischen den Personen A & B", 1));
          questionBadList.add(new QuestionBad("Welche der folgenden Aussagen beschreibt den Intergruppenkonflikt?", "Konflikte innerhalb der Gruppe A", "Konflikte zwischen Gruppe A & B", "Konflikte zwischen den Personen A & B", 2));
          questionBadList.add(new QuestionBad("Wie nennt man das inhaltliche Konfliktmerkmal, bei dem: A & B zwei verschiedene Ziele haben?", "Beziehungskonflikt", "Wahrnehmungskonflikt", "Zielkonflikt", 3));
          questionBadList.add(new QuestionBad("Wie nennt man das inhaltliche Konfliktmerkmal, bei dem: A & B die Sachlage vollkommen unterschiedlich sehen?", "Wahrnehmungskonflikt", "Zielkonflikt", "Rollenkonflikt", 1));
          questionBadList.add(new QuestionBad("Wie nennt man das inhaltliche Konfliktmerkmal, bei dem: A & B Probleme auf der Beziehungsebene haben?", "Wahrnehmungskonflikt", "Beziehungskonflikt", "Zielkonflikt", 2));
          questionBadList.add(new QuestionBad("Wie nennt man das inhaltliche Konfliktmerkmal, bei dem: A eine Aufgabe bzw. einen Verantwortungsbereich hat, aber lieber anders handeln möchte?", "Zielkonflikt", "Wahrnehmungskonflikt", "Rollenkonflikt", 3));



        //questionBadList.add(new QuestionBad("", "", "", "", 2));
     //   questionBadList.add(new QuestionBad("", "", "", "", 2));
       // questionBadList.add(new QuestionBad("", "", "", "", 2));



        Collections.shuffle(questionBadList);

        setQuestionBad();
    }

    private void setQuestionBad() {
        question.setText(questionBadList.get(0).getQuestion());
        option1.setText(questionBadList.get(0).getOptionA());
        option2.setText(questionBadList.get(0).getOptionB());
        option3.setText(questionBadList.get(0).getOptionC());

        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionBadList.size()));
        punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionBadList.size()));


        quesNum = 0;

    }


    public void launchBadInfo(View v) {
        //launch a new activity
        Intent i = new Intent(this, BadInfoActivity.class);
        startActivity(i);
    }

    public void launchResult(View v) {


        Intent intent = new Intent(BadActivity.this, ResultActivity.class);
        intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(quesNum));
        startActivity(intent);
        BadActivity.this.finish();
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

        if (selectedOption == questionBadList.get(quesNum).getCorrectAns()) {
            //Right Answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009900")));
            score++;
            punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionBadList.size()));






        }

        else if (selectedOption == 4) {
            changeQuestion();
            punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionBadList.size()));
        }

        else {
            //Wrong Answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#990000")));

            switch (questionBadList.get(quesNum).getCorrectAns()) {
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
        if (quesNum < questionBadList.size() - 1) {
            quesNum++;

            playAnim(question, 0, 0);
            playAnim(option1, 0, 1);
            playAnim(option2, 0, 2);
            playAnim(option3, 0, 3);

            qCount.setText(String.valueOf(quesNum + 1) + "/" + String.valueOf(questionBadList.size()));
        } else {
            //Go to score Activity
            Intent intent = new Intent(BadActivity.this, ResultActivity.class);
            intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(questionBadList.size()));
            startActivity(intent);
            BadActivity.this.finish();
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
                                    ((TextView) view).setText(questionBadList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button) view).setText(questionBadList.get(quesNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button) view).setText(questionBadList.get(quesNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button) view).setText(questionBadList.get(quesNum).getOptionC());
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