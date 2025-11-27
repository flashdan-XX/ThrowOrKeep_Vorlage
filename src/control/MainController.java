package control;

import view.ViewWindow;
import Model.Card;
import Model.Stack;

public class MainController {

    private Stack<Card> stackOrigin;  //Ursprünglicher Stapel mit zufälligen Zahlen/Karten
    private Stack<Card> stackKeep;    //Stapel der Karten, der behalten wird

    public static void main(String[] args) {
        new MainController();
    }

    public MainController() {
        new ViewWindow(this);

        startProgram();
    }

    /**
     * Erstellt die zwei benötigten Stacks und füllt stackOrigin mit Karten. Die Karten haben einen zufälligen Wert zwischen 0 und 20
     * Zufallswert: Z.b.: Math.random() -> Double zwischen 0 und 1
     */
    public void startProgram() {
        //TODO: Implementiere die Methode gemäß des Kommentars
        stackOrigin = new Stack<>();
        stackKeep = new Stack<>();

        //Will das mit einer Schleife probieren

        Card card1 = new Card((int) Math.random()*21);
        Card card2 = new Card((int) Math.random()*21);
        Card card3 = new Card((int) Math.random()*21);
        Card card4 = new Card((int) Math.random()*21);
        Card card5 = new Card((int) Math.random()*21);
        Card card6 = new Card((int) Math.random()*21);
        Card card7 = new Card((int) Math.random()*21);
        Card card8 = new Card((int) Math.random()*21);

       stackOrigin.push(card1);
       stackOrigin.push(card2);
       stackOrigin.push(card3);
       stackOrigin.push(card4);
       stackOrigin.push(card5);
       stackOrigin.push(card6);
       stackOrigin.push(card7);
       stackOrigin.push(card8);

    }

    /**
     * Wert der obersten Karte von stackOrigin wird ermittelt. Falls es keine oberste Karte gibt wird -1 zurückgegeben.
     * @return Wert der obersten Karte oder -1
     */
    public int showNextCard() {
        //TODO: Implementiere die Methode gemäß des Kommentars
        if(!cardStackEmpty()) {
            return stackOrigin.top().getWert();
        }
        return -1;
    }

    /**
     * Falls stackOrigin nicht leer ist, wird die oberste Karte von stackOrigin auf stackKeep gelegt.
     * @return true, falls eine Karte auf stackKeep gelegt wird, sonst false.
     */
    public boolean keep() {
        //TODO: Implementiere die Methode gemäß des Kommentars
        if(!stackOrigin.isEmpty()) {
            stackKeep.push(stackOrigin.top());
            stackOrigin.pop();
            return true;
        }else {
            return false;
        }
    }

    /**
     * Falls stackOrigin nicht leer ist, wird die oberste Karte von stackOrigin entfernt.
     * @return true, falls eine Karte auf stackOrigin entfernt wird, sonst false.
     */
    public boolean throwCard() {
        //TODO: Implementiere die Methode gemäß des Kommentars
        if(!cardStackEmpty()) {
            stackOrigin.pop();
            return true;
        }
        return false;
    }

    /**
     * Zählt die Karten von stackKeep. Zunächst wird geprüft, ob stackKeep den Regeln entspricht (Nur Karten in aufsteigender Reihenfolge abgelegt).
     * Zählt anschließend die abgelegten Karten, falls stackKeep regelkonform ist.
     * @return Die Anzahl der abgelegten Karten, falls stackKeep regelkonform ist, sonst -1.
     */
    public int inspect() {
        //TODO: Implementiere die Methode gemäß des Kommentars
        if(keepCorrect()) {
            int count = 0;
            while (!stackKeep.isEmpty()) {
                stackKeep.pop();
                count++;
            }
            return count;
        }
        return -1;
    }

    /**
     * Prüft, ob stackKeep regelkonform ist. Dh. die Karten liegen (von oben nach unten) in absteigender Reihenfolge.
     * Tipp: Nutze einen Hilfsstack
     * @return true, falls regelkonform. Sonst false.
     */
    public boolean keepCorrect() {
        Stack<Card> help = new Stack<>();
        while (!stackKeep.isEmpty()) {
            if (!help.isEmpty()) {
                if (stackKeep.top().getWert() < help.top().getWert()) {
                    help.push(stackKeep.top());
                    stackKeep.pop();
                } else {
                    return false;
                }
            } else {
                help.push(stackKeep.top());
                stackKeep.pop();
            }
        }
        stackKeep = help;
        return true;
    }

    public boolean cardStackEmpty() {
        return stackOrigin.isEmpty();
    }

}
