# Java Study Guide

Este repositorio contiene ejemplos y explicaciones sobre varios conceptos de Java que son esenciales para tu examen. Aquí encontrarás información sobre estructuras de datos, vectores, ArrayList, manejo de objetos en colecciones, manejo de ficheros de texto y objetos, conceptos de herencia y polimorfismo, y cómo devolver información en cadenas.

## Estructuras de Datos

### Arrays

Un array es una colección de elementos del mismo tipo, con un tamaño fijo. Se inicializa y utiliza de la siguiente manera:

```java
int[] numbers = new int[5];
numbers[0] = 10;
```
### ArrayList
Un ArrayList permite almacenar una cantidad variable de elementos y puede crecer dinámicamente.


```java

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("World");
        
        System.out.println("ArrayList: " + arrayList);
    }
}
```
### Vectores
Un Vector es similar a un ArrayList, pero está sincronizado, lo que lo hace seguro para el acceso concurrente.

```java

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        
        System.out.println("Vector: " + vector);
    }
}
```
### Vectores de Objetos
Puedes almacenar objetos en un Vector de la misma manera que almacenamos tipos primitivos:

```java

import java.util.Vector;

class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

public class VectorOfObjects {
    public static void main(String[] args) {
        Vector<Person> people = new Vector<>();
        people.add(new Person("Alice"));
        people.add(new Person("Bob"));
        
        System.out.println("Vector of people: " + people);
    }
}
```
### Meter Objetos en ArrayList
De manera similar a los Vectores, puedes almacenar objetos en un ArrayList:

```java

import java.util.ArrayList;

class Animal {
    String type;
    
    Animal(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return type;
    }
}

public class ArrayListOfObjects {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog"));
        animals.add(new Animal("Cat"));
        
        System.out.println("ArrayList of animals: " + animals);
    }
}
```
### Ficheros de Texto y Objetos
Leer y Escribir en Ficheros de Texto
```java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileExample {
    public static void main(String[] args) {
        // Escribir en un fichero
        try (FileWriter writer = new FileWriter("example.txt")) {
            writer.write("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Leer de un fichero
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
### Leer y Escribir Objetos en Ficheros
```java

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    
    Person(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

public class ObjectFileExample {
    public static void main(String[] args) {
        // Escribir objeto a fichero
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            oos.writeObject(new Person("Alice"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Leer objeto de fichero
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```
### Conceptos de Herencia y Polimorfismo
## Herencia
Permite crear nuevas clases basadas en clases existentes.

```java

class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound(); // Imprime "Bark"
    }
}
```
## Polimorfismo
Permite usar una referencia de clase base para referirse a objetos de clase derivada.

```java

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound(); // Imprime "Bark"
    }
}
```
### Devolver Información en Cadenas
Para devolver información en cadenas, puedes usar el método toString().

```java

class Car {
    String model;
    
    Car(String model) {
        this.model = model;
    }
    
    @Override
    public String toString() {
        return "Car model: " + model;
    }
}

public class ToStringExample {
    public static void main(String[] args) {
        Car car = new Car("Tesla");
        System.out.println(car);
    }
}