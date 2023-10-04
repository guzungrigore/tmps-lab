# Topic: *Creational Design Patterns*

---

## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__

## Some Theory:
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation.
They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the
specifics of object creation. Creational design patterns address common problems encountered in object creation, such as
how to create objects with different initialization parameters, how to create objects based on certain conditions, or how
to ensure that only a single instance of an object is created. There are several creational design patterns that have their 
own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using
creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

#### Some examples of this kind of design patterns are:

* Singleton
* Builder
* Prototype
* Object Pooling
* Factory Method
* Abstract Factory

---

## Implementation

#### Introduction

I decided to implement Singleton, Builder, Prototype and Factory design principles.
I made some changes in my bank system and added those principles.

#### Snippets from your files:

* Singleton Principle:

```java
public class SingletonTransaction extends CardTransaction {
    private static SingletonTransaction instance;

    private SingletonTransaction(){
        // Private constructor to prevent instantiation
    }

    public static SingletonTransaction getInstance() {
        if (instance == null) {
            instance = new SingletonTransaction();
        }
        return instance;
    }

    @Override
    public void transaction(Card fromCard, Card toCard, double amount) {
        super.transaction(fromCard, toCard, amount);
    }
}
```
* Prototype Principle:

```java
public class CardPrototype {
    private static Card originalCard;

    public static void setOriginalCard(Card card) {
        originalCard = card;
    }

    public static Card cloneCard() {
        try {
            return (Card) originalCard.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
```
* Builder Principle:

```java
public class CardBuilder {
    private Card card;

    public CardBuilder(CardType type) {
        if (type == CardType.DEBIT) {
            card = new DebitCard();

        } else if (type == CardType.CREDIT) {
            card = new CreditCard(1000, 2.5);

        }
    }

    public CardBuilder setBalance(double balance) {
        card.deposit(balance);
        return this;
    }

    public Card build() {
        return card;
    }
}
```
* Factory Principle:

```java
public interface Bank {
    Card createCard();
}

public class DebitBank implements Bank{
    @Override
    public Card createCard() {
        return new DebitCard();
    }
}

public class CreditBank implements Bank{
    @Override
    public Card createCard() {
        return new CreditCard(1000, 0.1);
    }
}
```

## Conclusion

I've successfully applied four creational design patterns in my code. This practical approach has deepened my understanding
of these design patterns and how they can be effectively utilized in software development. Overall, it's been a rewarding
experience that enhances my grasp of creational design patterns.