import java.time.LocalDateTime;
import java.util.Random;

/*
 * Problem set: Animal Shelter
 * An animal shelter, which holds only dogs and cats, operates on a strictly 
 * "first in, first out" basis. People must adopt either the "oldest" 
 * (based on arrival time) of all animals at the shelter, or they can 
 * select whether they would prefer a dog or a cat (and will receive the oldest
 * animal of that type).
 * Create the data structures to maintain this system and implement operations 
 * such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
 * You may use the built-in LinkedList data structure.
 */

public class AnimalShelter {
	public static abstract class Animal {
		public LocalDateTime arrivalDate;
		public String name;
		
		public Animal(String name) {
			this.name = name;
			arrivalDate = LocalDateTime.now();
		}
		
	}

	public static class Dog extends Animal {
		public Dog(String name) {
			super(name);
		}
	}
	
	public static class Cat extends Animal {
		public Cat(String name) {
			super(name);
		}
	}
	
	
	private static class AnimalAdoptionShelter {
		private MyQueue<Dog> queueOfDogs = new MyQueue<Dog>();
		private MyQueue<Cat> queueOfCats = new MyQueue<Cat>();
		private static Random r = new Random();
		
		public void enqueue(Animal animal) {
			if (animal instanceof Cat) {
				queueOfCats.add((Cat) animal);
			} else if (animal instanceof Dog) {
				queueOfDogs.add((Dog) animal);
			}
		}
		
		private Cat peekCat() {
			return queueOfCats.peek();
		}
		
		public Dog peekDog() {
			return queueOfDogs.peek();
		}
		
		public Animal dequeueAny() {
			Cat oldestCat;
			try {
				oldestCat = peekCat();
			} catch (Exception e) {
				oldestCat = null;
			}
			
			Dog oldestDog;
			try {
				oldestDog = peekDog();
			} catch (Exception e) {
				oldestDog = null;
			}
			
			if (oldestDog == null && oldestCat == null) {
				System.out.println("No more cats or dogs in the shelter");
			}
			
			if (oldestDog == null) {
				return oldestCat;
			} else if (oldestCat == null) {
				return oldestDog;
			}
			
			// if both are available then compare dates
			if (oldestCat.arrivalDate.compareTo(oldestDog.arrivalDate) < 0) {
				return dequeueCat();
			}
			return dequeueDog();
		}
		
		public Cat dequeueCat() {
			return queueOfCats.remove();
		}
		
		public Dog dequeueDog() {
			return queueOfDogs.remove();
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalAdoptionShelter a = new AnimalAdoptionShelter();
		a.enqueue(new Cat("Felix"));
		try {
			Thread.sleep(50);
		} catch (Exception e) {}
		a.enqueue(new Dog("Tony"));
		try {
			Thread.sleep(50);
		} catch (Exception e) {}
		a.enqueue(new Cat("Icy"));
		try {
			Thread.sleep(50);
		} catch (Exception e) {}
		a.enqueue(new Cat("Tomo"));
		try {
			Thread.sleep(50);
		} catch (Exception e) {}
		a.enqueue(new Cat("Akira"));
		try {
			Thread.sleep(50);
		} catch (Exception e) {}
		a.enqueue(new Dog("Shadow"));
		
		System.out.println(a.dequeueAny().name); // should be felix
		System.out.println(a.dequeueCat().name); // should be Icy
		System.out.println(a.dequeueAny().name); // should be Tony
		System.out.println(a.dequeueDog().name); // should be Shadow
		System.out.println(a.dequeueAny().name); // should be Tomo

	}

}
