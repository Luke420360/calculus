Hallo! 
In diesem Projekt "Calculus" möchte ich alle relevanten Themen
aus den Mathe Modulen implementieren. In diesem Sinne ist vor allem der Weg das Ziel.

Module: Lineare Algebra, Analysis, Stochastik.

Ziel ist eine App mit bedienbarer UI, welches die Themen der Vorlesungen gut visualisiert.

Anfang AST(Abstract Syntax Tree):
Aus Modellierung: Termbäume (bzw. Kantorowitsch-Bäume) [Graphen komplett 113]

Ein Knoten beschreibt eine Konstante eine Variable oder Operatoren.

Klassenimplementierung: Expression -> Fundament
    Expression ist irgendwas, was ein Knoten im Baum sein kann.
    Also baut diese Klasse das Fundament für alles andere.
    ./calculus/app/src/main/java/calculus/ast

    Methoden evaluate -> Polymorphie, damit jeder Ausdruck ausgewertet werden kann
    toString -> Zum debuggen

Klassemimplementierung: NumberLiteral
    Erstes "Kind" von Expression -> Hier landen Konstanten (Nicer rhyme)
    Überschreibt die Methoden aus Expression z.B evaluate gibt einfach den 
    Final Value aus dem Objekt zurück, da es ja keinen unterschied macht was 
    x ist wenn es eine Konstante ist.

Klassemimplementierung: Variable
    Erklärt sich denke ich von selbst, aber hier viel auf das wir die Klassen
    auch als final definieren können (Holt anscheinend sogar performance raus :O)
