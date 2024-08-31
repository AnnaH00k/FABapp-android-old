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

public class WirtActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question, qCount, punkte;
    private Button option1, option2, option3, next;
    private List<QuestionWirt> questionWirtList;
    private int quesNum;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wirt);

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
        questionWirtList = new ArrayList<>();



        questionWirtList.add(new QuestionWirt("Wie nennt man alle abstrakt generellen Vereinbarungen, die das menschliche Verhalten regeln?", "Verträge", "Rechtsvorschriften", "Schutzgesetze", 2));
        questionWirtList.add(new QuestionWirt("Wo sind Schadensersatzpflicht, Fundrecht und Vertragsrecht zu finden?", "Bürgerliches Gesetzbuch (BGB)", "Strafgesetzbuch (StGB)", "Arbeitsschutzgesetze", 1));
        questionWirtList.add(new QuestionWirt("Wo sind Unterlassung, Körperverletzung und Diebstahl zu finden?", "Bürgerliches Gesetzbuch (BGB)", "Strafgesetzbuch (StGB)", "Arbeitsschutzgesetze", 2));
        questionWirtList.add(new QuestionWirt("Wo sind Arbeitszeitgesetze, Bundesurlaubsgesetz und Jugendarbeitsschutzgesetz zu finden?", "Arbeitsschutzgesetze", "Bürgerliches Gesetzbuch (BGB)", "Infektionsschutzgesetz (ifSG)", 1));
        questionWirtList.add(new QuestionWirt("Wo ist § 37 „Beschaffenheit von Wasser für den menschlichen Gebrauch sowie von Wasser zum Schwimmen oder Baden in Becken oder Teichen“ zu finden?", "Bürgerliches Gesetzbuch (BGB)", "Arbeitsschutzgesetze", "Infektionsschutzgesetz (ifSG)", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man die Fähigkeit, Rechtsgeschäfte und Verträge voll rechtsgültig abzuschließen?", "Vertragsfähigkeit", "Rechtsfähigkeit", "Geschäftsfähigkeit", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man es, wenn Rechtsgeschäfte nicht abgeschlossen werden dürfen und ungültig sind?", "Volle Geschäftsfähigkeit", "Beschränkte Geschäftsfähigkeit", "Geschäftsunfähigkeit", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man es, wenn Rechtsgeschäfte schwebend unwirksam sind und ein gesetzlicher Vertreter zustimmen muss?", "Geschäftsunfähigkeit", "Volle Geschäftsfähigkeit", "Beschränkte Geschäftsfähigkeit", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man es, wenn Rechtsgeschäfte voll gültig sind?", "Geschäftsunfähigkeit", "Beschränkte Geschäftsfähigkeit", "Volle Geschäftsfähigkeit", 3));
        questionWirtList.add(new QuestionWirt("Wer ist geschäftsunfähig?", "Personen von 0-6 Jahren & dauerhaft Geistesbeschränkte.", "Personen von 7 – 17 Jahren.", "Personen ab 18 Jahren.", 1));
        questionWirtList.add(new QuestionWirt("Wer ist beschränkt geschäftsfähig?", "Personen von 7 – 17 Jahren.", "Personen von 0-6 Jahren & dauerhaft Geistesbeschränkte.", "Personen ab 18 Jahren.", 1));
        questionWirtList.add(new QuestionWirt("Wer ist voll geschäftsfähig?", "Personen von 0-6 Jahren & dauerhaft Geistesbeschränkte.", "Personen ab 18 Jahren. ", "Personen von 7 – 17 Jahren.", 2));
        questionWirtList.add(new QuestionWirt("Welche Ausnahme gibt es bei Geschäftsunfähigkeit ein Geschäft abzuschließen?", "Als Bote.", "Bei hoher Zurechnungsfähigkeit.", "Mittragen einer Geschäftslizenz.", 1));
        questionWirtList.add(new QuestionWirt("Welcher der folgenden Punkte ist eine Ausnahme für beschränkt Geschäftsfähige?", "Geschäftlicher Vorteil", "Rechtliches Unvorteil", "Rechtlicher Vorteil", 3));
        questionWirtList.add(new QuestionWirt("Welcher der folgenden Punkte ist eine Ausnahme für beschränkt Geschäftsfähige?", "Große Geldsummen", "Taschengeld", "Nachgewiesene Zurechnungsfähigkeit", 2));
        questionWirtList.add(new QuestionWirt("Welcher der folgenden Punkte ist eine Ausnahme für beschränkt Geschäftsfähige?", "Große Geldsummen", "Arbeits- Vorteil", "Erlaubtes Arbeitsverhältnis", 3));
        questionWirtList.add(new QuestionWirt("Zu welcher Art von Rechtsgeschäften zählen Kündigung, Testament, Anfechtung?", "Mehrseitige Rechtsgeschäfte", "Zweiseitige Rechtsgeschäfte", "Einseitige Rechtsgeschäfte", 3));
        questionWirtList.add(new QuestionWirt("Wie werden Verträge noch genannt?", "Zweiseitige Rechtsgeschäfte", "Einseitige Rechtsgeschäfte", "Mehrseitige Rechtsgeschäfte", 1));
        questionWirtList.add(new QuestionWirt("Zu welcher Art von Rechtsgeschäften zählen Arbeitsvertrag, Schenkungsvertrag, Kaufvertrag?", "Einseitige Rechtsgeschäfte", "Mehrseitige Rechtsgeschäfte", "Zweiseitige Rechtsgeschäfte", 3));
        questionWirtList.add(new QuestionWirt("Wie muss ein Berufsausbildungsvertrag abgeschlossen werden?", "öffentliche Beglaubigung", "In Schriftform", "Notarielle Beurkundung", 2));
        questionWirtList.add(new QuestionWirt("Wie muss ein Antrag auf Eintragung ins Vereinsregister abgeschlossen werden?", "In Schriftform", "Notarielle Beurkundung", "Öffentliche Beglaubigung", 3));
        questionWirtList.add(new QuestionWirt("Wie muss ein Grundstückskauf abgeschlossen werden?", "In Schriftform", "Notarielle Beurkundung", "Öffentliche Beglaubigung", 2));
        questionWirtList.add(new QuestionWirt("Geschäfte, die durch widerrechtliche Drohung zustande gekommen sind, sind…", "…anfechtbar", " …nichtig", "…gültig", 1));
        questionWirtList.add(new QuestionWirt("Geschäfte, die durch arglistige Täuschung herbeigeführt wurden, sind…", "…anfechtbar", "…nichtig", "…gültig", 1));
        questionWirtList.add(new QuestionWirt("Geschäfte, denen ein Irrtum oder falsche Übermittlung zugrunde liegt, sind…", "…nichtig", "…anfechtbar", "…gültig", 2));
        questionWirtList.add(new QuestionWirt("Gesetze, die gegen ein gesetzliches Verbot verstoßen, sind…", "…gültig", "…anfechtbar", "…nichtig", 3));
        questionWirtList.add(new QuestionWirt("Geschäfte, die gegen die guten Sitten verstoßen, sind…", "…anfechtbar", "…nichtig", "…gültig", 2));
        questionWirtList.add(new QuestionWirt("Gesetze, die mit Geschäftsunfähigkeiten abgeschlossen werden, sind…", "…anfechtbar", "…nichtig", "…gültig", 2));
        questionWirtList.add(new QuestionWirt("Geschäfte, die als Scherz gedacht sind, sind…", "…anfechtbar", "…gültig", "…nichtig", 3));
        questionWirtList.add(new QuestionWirt("Geschäfte, die zum Schein abgeschlossen wurden, sind…", "…nichtig", "…anfechtbar", "…gültig", 1));
        questionWirtList.add(new QuestionWirt("Geschäfte, bei denen die gesetzlich vorgeschriebene Form nicht beachtet wurde, sind…", "…nichtig", "…anfechtbar", "…gültig", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man vorformulierte Vertragsklauseln, die für alle Kaufverträge gelten, welche der betreffende Kaufmann abschließt?", "Satzung", "Haus- und Badeordnung", "Allgemeine Geschäftsbedingungen", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man es, wenn Rechte und Pflichten, auch aus einem Vertrag übernommen werden können", "Rechtsfähigkeit", "Geschäftsfähigkeit", "Deliktsfähigkeit", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man die Fähigkeit Rechtsgeschäfte und Verträge voll rechtsgültig abzuschließen?", "Rechtsfähigkeit", "Geschäftsfähigkeit", "Deliktsfähigkeit", 2));
        questionWirtList.add(new QuestionWirt("Welches Recht regelt, unter welchen Umständen der Schädiger für den von ihm angerichteten Schaden haftet?", "Deliktrecht", "Geschäftsrecht", "Strafrecht", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man Personenvereinigungen und Vermögensmassen, die von der Verleihung bis zum Entzug rechtsfähig sind?", "Rechts Vereinigungen", "Gesellschaftspersonen", "Juristische Personen", 3));
        questionWirtList.add(new QuestionWirt("Wozu zählen: Städte, Kommunen, Land NRW, BRD?", "Juristische Personen des privaten Rechts", "Juristische Personen des öffentlichen Rechts", "Juristische Personen allgemein", 2));
        questionWirtList.add(new QuestionWirt("Wozu zählen: GmbH, AG, eingetragene Vereine?", "Juristische Personen des öffentlichen Rechts", "Juristische Personen des privaten Rechts", "Juristische Personen allgemein", 2));
        questionWirtList.add(new QuestionWirt("Wie nennt man Vorschriften, welche sich an eine öffentliche Verwaltung wenden und ausschließlich für diese Verwaltung Gültigkeit haben? ", "Verwaltungssatzungen", "Verwaltungsrichtlinien", "Verwaltungsvorschriften", 3));
        questionWirtList.add(new QuestionWirt("Wozu zählen: Erlasse, Satzungen, Dienstanweisungen, technische Dienstanweisungen und Richtlinien?", "Zu den Verwaltungsvorschriften", "Zu den Betriebsvorschriften", "Zu den Arbeitsanweisungen", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man eine rechtsverbindliche Weisung vom Badbetreiber an das Badepersonal zwecks konkreter Durchführung der Arbeitsinhalte?", "Betriebsvorschrift", "Betriebsweisung", "Dienstanweisung", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man eine Innerbetriebliche Weisung des Arbeitgebers, wie das Personal die technischen Anlagen zu bedienen hat?", "Anlagenanweisung", "Technische Dienstanweisung", "Technische Betriebsvorschrift", 2));
        questionWirtList.add(new QuestionWirt("Wie nennt man einen Vertrag in dem einheitliche Arbeitsbedingungen für die Arbeitnehmer ganzer Wirtschaftszweige einer Region festgelegt werden?", "Tarifvertrag", "Arbeitnehmervertrag", "Wirtschaftsvertrag", 1));
        questionWirtList.add(new QuestionWirt("Tarifverträge werden von Tarifpartnern abgeschlossen. Wie nennt man die Tarifpartner auf der Arbeitnehmerseite?", "Gesellschaften", "Gewerkschaften", "Arbeitnehmerverbände", 2));
        questionWirtList.add(new QuestionWirt("Tarifverträge werden von Tarifpartnern abgeschlossen. Wie nennt man die Tarifpartner auf der Unternehmerseite?", "Gewerkschaften", "Gesellschaften", "Arbeitgeberverbände", 3));
        questionWirtList.add(new QuestionWirt("Die Tarifpartner sind unabhängig vom Staat und haben das Recht, selbstständig Tarifverträge auszuhandeln und abzuschließen. Wie nennt man dies?", "Staatsunabhängige Tarife", "Tariffreiheit", "Tarifautonomie", 3));
        questionWirtList.add(new QuestionWirt("Für wen gelten die ausgehandelten Tarifverträge?", "Arbeitnehmer & Arbeitgeber, die den Tarifvertragsparteien angehören.", "Arbeitgeber, die den Tarifvertragsparteien angehören.", "Allen Arbeitnehmern & Arbeitgebern.", 1));
        questionWirtList.add(new QuestionWirt("Das Bundesministerium für Arbeit und Soziales kann was mit Tarifverträgen machen, wenn ein Antrag der Tarifparteien vorliegt?", "Nichts", "Tarifverträge für allgemein verbindlich erklären.", "Tarifverträge autonom machen.", 2));
        questionWirtList.add(new QuestionWirt("Wie nennt man die Art von Tarifverträgen, welche die Gehaltshöhe / die Höhe der einzelnen Lohn oder Gehaltsgruppen enthält und deren Laufzeit normalerweise ein Jahr beträgt?", "Mantel- oder Rahmentarifvertrag", "Lohn- und Gehaltsrahmentarifvertrag", "Lohn- und Gehaltstarifvertrag", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man die Art von Tarifverträgen, die Inhalte wie: Arbeitszeit, Urlaub, Kündigung, Arbeitsbedingungen, Mehrarbeit usw. enthalten?", "Lohn- und Gehaltstarifvertrag", "Mantel- oder Rahmentarifvertrag", "Lohn- und Gehaltsrahmentarifvertrag", 2));
        questionWirtList.add(new QuestionWirt("Wie nennt man die Art von Tarifverträgen, die Bereiche der Entlohnung regeln, die länger unverändert bleiben?", "Lohn- und Gehaltsrahmentarifvertrag", "Mantel- oder Rahmentarifvertrag", "Lohn- und Gehaltstarifvertrag", 1));
        questionWirtList.add(new QuestionWirt("Welcher der folgenden Punkte ist keine Aufgabe der Gewerkschaften?", "Beratung von Arbeitnehmern in Arbeitsrechtsangelegenheiten.", "Verbesserung von Arbeitnehmerbedingungen.", "Verklagen von Arbeitnehmern.", 3));
        questionWirtList.add(new QuestionWirt("Welcher der folgenden Punkte ist keine Aufgabe der Gewerkschaften?", "Verhandeln von Tarifverträgen.", "Aufrufen zum Streik, um Forderungen zu unterstreichen.", "Verhindern von Streiks.", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man das Kampfmittel der Arbeitnehmer, um ihre Interessen durchzuführen?", "Streik", "Aussperrung", "Urabstimmung", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man das Kampfmittel der Arbeitgeber, um ihre Interessen durchzuführen?", "Streik", "Aussperrung", "Urabstimmung", 2));
        questionWirtList.add(new QuestionWirt("Wie nennt man einen Streik, bei dem die Arbeit nur für kurze Zeit unterbrochen wird, um die Streikbereitschaft zu zeigen?", "Schwerpunktstreik", "Sympathiestreik", "Warnstreik", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man einen Streik, der die gesamte Wirtschaft lahmlegt, weil sich alle Arbeitnehmer daran beteiligen und im Allgemeinen politisch begründet ist?", "Schwerpunktstreik", "Generalstreik", "Sympathiestreik", 2));
        questionWirtList.add(new QuestionWirt("Wie nennt man einen Streik, der normalerweise nur die wichtigsten Betriebe eines Wirtschaftszweiges betrifft, um Streikgeld zu sparen?", "Schwerpunktstreik", "Generalstreik", "Sympathiestreik", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man einen Streik, bei dem die Arbeitnehmer aus anderen Wirtschaftszweigen indirekt unterstützt werden sollen?", "Sympathiestreik", "Generalstreik", "Schwerpunktstreik", 1));
        questionWirtList.add(new QuestionWirt("Auf wie viele Jahre wird der Betriebsrat gewählt?", "2 Jahre.", "4 Jahre.", "Eine unbestimmte Zeit.", 2));
        questionWirtList.add(new QuestionWirt("Wer achtet darauf, dass die Bestimmungen, die zugunsten der Arbeitnehmer gelten auch eingehalten werden?", "Die Auszubildendenvertretung", "Der Betriebsrat", "Der Aufsichtsrat", 2));
        questionWirtList.add(new QuestionWirt("Wer nimmt die Beschwerden von Arbeitnehmern entgegen und verhandelt mit dem Arbeitgeber darüber, sofern die Beschwerden berechtigt sind?", "Der Arbeitnehmerbeauftragte", "Der Betriebsrat", "Der Aufsichtsrat", 2));
        questionWirtList.add(new QuestionWirt("Wer hilft schutzbedürftigen Arbeitnehmern wie Schwerbehinderten, ausländischen Arbeitnehmern oder Jugendlichen bei der Eingliederung in den Betrieb?", "Die Auszubildendenvertretung", "Der Betriebsrat", "Der Aufsichtsrat", 2));
        questionWirtList.add(new QuestionWirt("Bei welcher Art der Kündigung endet das Arbeitsverhältnis, nach einer Kündigungsfrist von 4 Wochen zum 15. Eines Monats oder zum Monatsende?", "Ordentliche (gesetzliche) Kündigung", "Außerordentliche (fristlose) Kündigung", "Allgemeine Kündigung", 1));
        questionWirtList.add(new QuestionWirt("Bei welcher Art der Kündigung endet das Arbeitsverhältnis nur aus wichtigem Grund z.B. Diebstahl?", "Ordentliche (gesetzliche) Kündigung", "Außerordentliche (fristlose) Kündigung", "Allgemeine Kündigung", 2));
        questionWirtList.add(new QuestionWirt("Wann sind befristete Arbeitsverträge zulässig?", "Immer", "Wenn Beschäftigte unter 18 sind.", "Wenn ein besonderer sachlicher Grund vorliegt", 3));
        questionWirtList.add(new QuestionWirt("Was haben diese 3 Ausnahmen gemeinsam? \\n 1.Bei Neueinstellung. \\n 2. Wenn Beschäftigte das 58. Lebensjahr vollendet haben. \\n 3. Wenn Existenzgründer in den ersten 4 Jahren Arbeitsverträge abschließen.", "Es können befristete Arbeitsverträge abgeschlossen werden.", "Gar nichts.", "Wird ein Bonus gezahlt.", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man die Entlohnung nach Arbeitszeit?", "Leistungslohn", "Zeitlohn", "Beteiligungslohn", 2));
        questionWirtList.add(new QuestionWirt("Wozu zählen Prämien und Akkordlohn?", "Zeitlohn", "Beteiligungslohn", "Leistungslohn", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man die Erfolgsbeteiligung durch Gewinnbeteiligung (Auszahlung) und Kapitalbeteiligung (z.B. Aktien)?", "Zeitlohn", "Beteiligungslohn", "Leistungslohn", 2));
        questionWirtList.add(new QuestionWirt("Wo sind die Urlaubsansprüche geregelt?", "Im Bundesurlaubsgesetz", "Im Arbeitszeitgesetz", "In der Urlaubsverordnung", 1));
        questionWirtList.add(new QuestionWirt("Ab welcher Beschäftigungsdauer besteht ein Anspruch auf Urlaub?", "4 Wochen", "6 Monate", "Ab Vertragsunterschreibung", 2));
        questionWirtList.add(new QuestionWirt("Wer bestimmt den Zeitpunkt des Urlaubs?", "Bundesministerium", "Arbeitnehmer", "Arbeitgeber", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man das Arbeitsentgelt, dass während des Urlaubs eines Arbeitnehmers weiterbezahlt wird, obwohl er in dieser Zeit keine Arbeitsleistung erbringt?", "Urlaubsentgelt", "Urlaubsabgeltung", "Urlaubsgeld", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man ein zusätzliches Entgelt, des Arbeitgebers an seinen Arbeitnehmer?", "Urlaubsabgeltung", "Urlaubsgeld", "Urlaubsentgelt", 2));
        questionWirtList.add(new QuestionWirt("Wie nennt man es, wenn wegen Beendigung des Arbeitsverhältnisses der gesetzlich zustehende Urlaub ganz oder teilweise nicht gewährt werden kann und damit ausgezahlt werden muss?", "Urlaubsentgelt", "Urlaubsgeld", "Urlaubsabgeltung", 3));
        questionWirtList.add(new QuestionWirt("Wie nennt man das Bundesgesetz zum Schutze von Kindern und Jugendlichen in der Öffentlichkeit und im Bereich der Medien?", "Jugendschutzgesetz", "Jugendarbeitsschutzgesetz", "Bundes Sozialgesetz", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man das Gesetz zum Schutz von arbeitenden Kindern und Jugendlichen?", "Jugendschutzgesetz", "Jugendarbeitsschutzgesetz", "Bundes Sozialgesetz", 2));
        questionWirtList.add(new QuestionWirt("Kinderarbeit ist verboten. Ab wie vielen Jahren gilt man nach dem Jugendarbeitsschutzgesetz nicht mehr als Kind?", "Ab 13 Jahren", "Ab 18 Jahren", "Ab 15 Jahren", 3));
        questionWirtList.add(new QuestionWirt("Wofür sind Berufsgenossenschaften, Gewerbeaufsichtsämter, Betriebsräte und Fachkräfte für Arbeitssicherheit verantwortlich?", "Überwachung der Schutzvorschriften.", "Das Verbreiten guter Stimmung.", "Sicherheitsausgaben", 1));
        questionWirtList.add(new QuestionWirt("Wann stehen einem jugendlichen Arbeitnehmer 30 min. Pause zu?", "Arbeitszeit > 6Std.", "Arbeitszeit von 4 ein halb bis 6 Std.", "Arbeitszeit zwischen 2 - 4 Std.", 2));
        questionWirtList.add(new QuestionWirt("Wann stehen einem jugendlichen Arbeitnehmer 60 min. Pause zu?", "Arbeitszeit von 4 ein halb bis 6 Std.", "Arbeitszeit ab 8 Std.", "Arbeitszeit > 6Std. ", 3));
        questionWirtList.add(new QuestionWirt("Wie viele Stunden Ruhezeit müssen gemäß Jugendarbeitsschutzgesetz zwischen zwei Arbeitstagen liegen?", "12 Stunden", "11 Stunden", "13 Stunden", 1));
        questionWirtList.add(new QuestionWirt("Dürfen jugendliche Arbeitnehmer Akkord, Fließband und gefährliche Arbeiten ausführen?", "Ja", "Nein", "Nur wenn sie zusatzversichert sind.", 2));
        questionWirtList.add(new QuestionWirt("In den letzten 3 Monaten des 1 Arbeitsjahres muss eine Nachuntersuchung durchgeführt werden, wenn…", "… das 20 Lebensjahr nicht vollendet ist.", "… bei Einstellung Minderjährigkeit vorlag.", "… das 18 Lebensjahr nicht vollendet ist. ", 3));
        questionWirtList.add(new QuestionWirt("Dürfen Jugendliche ohne Erstuntersuchung vor Beschäftigungsaufnahme beschäftigt werden?", "Nein", "Ja", "Nur in Schwimmbädern.", 1));
        questionWirtList.add(new QuestionWirt("Wie nennt man das Gesetz, mit dem der Staat den besonderen Schutzanspruch von Müttern versucht zu berücksichtigen?", "Elternschutzgesetz", "Mutterschutzgesetz", "Mutterstaatsschutzgesetz", 2));
        questionWirtList.add(new QuestionWirt("Mit welchen der folgenden Aufgaben dürfen werdende Mütter betraut werden?", "Akkord- & Fließbandarbeiten", "Schwere / gefährliche Arbeiten", "Verwaltungsarbeiten", 3));
        questionWirtList.add(new QuestionWirt("Wie viele Wochen vor der Entbindung kann die werdende Mutter mit der Arbeit aufhöhren?", "6 Wochen", "8 Wochen", "13 Wochen", 1));
        questionWirtList.add(new QuestionWirt("Wie viele Wochen nach der Entbindung darf eine Mutter nicht beschäftigt werden?", "6 Wochen", "8 Wochen", "13 Wochen", 2));
        questionWirtList.add(new QuestionWirt("Bei welchem Kündigungsgrund muss der Arbeitgeber vor einer Kündigung abmahnen?", "Bei betrieblichen Erfordernissen.", "Bei gutem Verhalten.", "Bei Fehlverhalten.", 3));
        questionWirtList.add(new QuestionWirt("Wer ist für Kündigungsstreitigkeiten zuständig?", "Arbeitsgericht", "Bundesministerium", "Arbeitsministerium", 1));
        questionWirtList.add(new QuestionWirt("Welche Form schreibt der Gesetzgeber für eine Kündigung vor?", "Mündlich", "Schriftlich", "Formfrei", 2));
        questionWirtList.add(new QuestionWirt("Wer muss vor jeder Kündigung angehört werden, damit eine Kündigung wirksam wird?", "Serviceleitung", "Betriebsleiter", "Betriebsrat", 3));
        questionWirtList.add(new QuestionWirt("Wie viele wahlberechtigte Arbeitnehmer muss ein Betrieb haben, damit ein Betriebsrat gewählt werden kann?", "Mind. 5", "Mind. 2", "Mind. 20", 1));
        questionWirtList.add(new QuestionWirt("Ab wie vielen Jahren ist ein Arbeitnehmer dazu berechtigt einen Betriebsrat zu wählen?", "Ab 16 Jahren.", "Ab 18 Jahren.", "Nach 6 Monaten Beschäftigungszeit.", 2));
        questionWirtList.add(new QuestionWirt("Wer darf als Betriebsrat gewählt werden?", "Arbeitnehmer ab 16, die mind. 2 Jahren angestellt sind.", "Jeder", "Arbeitnehmer ab 18, die mind. 6 Monate angestellt sind. ", 3));
        questionWirtList.add(new QuestionWirt("Ab wie vielen Arbeitnehmern unter 18 Jahren kann in einem Betrieb eine Jugend- und Auszubildendenvertretung gewählt werden?", "Mind. 5 Arbeitnehmer", "Mind. 2 Arbeitnehmer", "Mind. 4 Arbeitnehmer", 1));
        questionWirtList.add(new QuestionWirt("Wer ist berechtigt Personen für die Jugend- und Auszubildendenvertretung zu wählen?", "Alle Auszubildenden", "Alle unter 25 Jahren", "Alle unter 21 Jahren", 2));
        questionWirtList.add(new QuestionWirt("Wer darf als Jugend- und Auszubildendenvertretung gewählt werden?", "Nur ein Auszubildender", "Jeder", "Alle unter 25 Jahren ", 3));




       // questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));
      //  questionWirtList.add(new QuestionWirt("", "", "", "", 2));




        Collections.shuffle(questionWirtList);

        setQuestionBad();
    }

    private void setQuestionBad() {
        question.setText(questionWirtList.get(0).getQuestion());
        option1.setText(questionWirtList.get(0).getOptionA());
        option2.setText(questionWirtList.get(0).getOptionB());
        option3.setText(questionWirtList.get(0).getOptionC());

        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionWirtList.size()));
        punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionWirtList.size()));


        quesNum = 0;

    }


    public void launchWirtInfo(View v) {
        //launch a new activity
        Intent i = new Intent(this, WirtInfoActivity.class);
        startActivity(i);
    }

    public void launchResult(View v) {


        Intent intent = new Intent(WirtActivity.this, ResultActivity.class);
        intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(quesNum));
        startActivity(intent);
        WirtActivity.this.finish();
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

        if (selectedOption == questionWirtList.get(quesNum).getCorrectAns()) {
            //Right Answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009900")));
            score++;
            punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionWirtList.size()));






        }

        else if (selectedOption == 4) {
            changeQuestion();
            punkte.setText(String.valueOf(score) + "/" + String.valueOf(questionWirtList.size()));
        }

        else {
            //Wrong Answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#990000")));

            switch (questionWirtList.get(quesNum).getCorrectAns()) {
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
        if (quesNum < questionWirtList.size() - 1) {
            quesNum++;

            playAnim(question, 0, 0);
            playAnim(option1, 0, 1);
            playAnim(option2, 0, 2);
            playAnim(option3, 0, 3);

            qCount.setText(String.valueOf(quesNum + 1) + "/" + String.valueOf(questionWirtList.size()));
        } else {
            //Go to score Activity
            Intent intent = new Intent(WirtActivity.this, ResultActivity.class);
            intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(questionWirtList.size()));
            startActivity(intent);
            WirtActivity.this.finish();
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
                                    ((TextView) view).setText(questionWirtList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button) view).setText(questionWirtList.get(quesNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button) view).setText(questionWirtList.get(quesNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button) view).setText(questionWirtList.get(quesNum).getOptionC());
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