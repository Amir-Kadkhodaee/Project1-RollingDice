import java.util.Random;

public class Roll {

    private int numberOfSides;
private int currentValue;

private Random rand;

public Roll(int numberOfSides) {
    this.numberOfSides = numberOfSides;
    this.rand = new Random();
    this.currentValue = 1; 
}
public int getNumberOfSides() {
    return numberOfSides;

}
public int getCurrentValue() {
    return currentValue;
}
public void roll() {
    this.currentValue = rand.nextInt(numberOfSides) + 1;

}
}


// Tärningen ska ha två instansvariabler som beskriver själva tärningen: nuvarande värde och antal sidor (tärningens högsta möjliga värde(100)). Klassen ska dessutom ha en privat variabel för en slumpgenerator av typen Random.

//Antalet sidor ska anges i klassens konstruktor, vara av typen int och ha en gettermetod. Det nuvarande värdet ska vara av typen int, ha en gettermetod och ändras när metoden roll() anropas.

//Slumpgeneratorn används av metoden roll(). Klassen Random importeras från java.util.Random.

//Skapa metoden public void roll(). Den ska använda slumpgeneratorn för att ändra tärningens nuvarande värde till ett heltal från 1 till antalet sidor. Tips: Random har metoden nextInt(int maxValue), som ger ett heltal från 0 till maxValue - 1. Anpassa därför resultatet till tärningens värden.