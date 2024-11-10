// Q. 1 Write a Java Program to implement State Pattern for Gumball Machine.
// Create instance variable that holds current state from there, we just need to handle all
// actions, behaviors and state transition that can happen
public class Slip_8_1 {
    
}

/*The **State Pattern** is a behavioral design pattern that allows an object to alter its behavior when its internal state changes. The object will appear to change its class. This is particularly useful when an object has multiple behaviors, depending on its state. In this case, we can model the **Gumball Machine** with different states, such as **No Coin**, **Has Coin**, **Sold**, and **Sold Out**.

### **Problem Context**:
We will implement a **Gumball Machine** where the states change depending on the actions taken, like inserting a coin, turning the crank, or dispensing a gumball. Each state will define its own behavior for actions such as inserting a coin, turning the crank, and dispensing gumballs.

### **State Transitions**:
- **NoCoin**: No coin inserted. When a coin is inserted, it transitions to the `HasCoin` state.
- **HasCoin**: Coin inserted. When the crank is turned, it transitions to the `Sold` state.
- **Sold**: A gumball is being dispensed. Once the gumball is dispensed, it transitions back to `NoCoin`.
- **SoldOut**: No gumballs available. It can’t transition to another state until a gumball is restocked.

### **Classes**:
1. **State Interface**: Defines the actions for all states.
2. **Concrete States**: Implements the `State` interface for each of the different states (`NoCoin`, `HasCoin`, `Sold`, `SoldOut`).
3. **GumballMachine**: Maintains the current state and delegates actions to the current state's behavior.

### **Java Code Implementation**:

#### 1. **State Interface**:
```java
// State interface
public interface State {
    void insertCoin();
    void ejectCoin();
    void turnCrank();
    void dispense();
}
```

#### 2. **Concrete States**:
```java
// NoCoin state: No coin inserted.
public class NoCoinState implements State {
    private GumballMachine gumballMachine;

    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        gumballMachine.setState(gumballMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin inserted.");
    }

    @Override
    public void turnCrank() {
        System.out.println("You need to insert a coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("You need to insert a coin first.");
    }
}

// HasCoin state: Coin inserted, ready to turn crank.
public class HasCoinState implements State {
    private GumballMachine gumballMachine;

    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You already inserted a coin.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned.");
        gumballMachine.setState(gumballMachine.getNoCoinState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning the crank...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("You need to turn the crank first.");
    }
}

// Sold state: Gumball is being dispensed.
public class SoldState implements State {
    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, we're already giving you a gumball.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning again doesn't get you another gumball.");
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing a gumball...");
        gumballMachine.releaseGumball();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoCoinState());
        } else {
            System.out.println("Out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}

// SoldOut state: No gumballs left.
public class SoldOutState implements State {
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Sorry, the machine is sold out.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("You haven't inserted a coin yet.");
    }

    @Override
    public void turnCrank() {
        System.out.println("No gumballs available.");
    }

    @Override
    public void dispense() {
        System.out.println("No gumballs to dispense.");
    }
}
```

#### 3. **GumballMachine Class**:
```java
public class GumballMachine {
    private State noCoinState;
    private State hasCoinState;
    private State soldState;
    private State soldOutState;

    private State currentState;
    private int count;

    public GumballMachine(int numberOfGumballs) {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        this.count = numberOfGumballs;
        if (numberOfGumballs > 0) {
            currentState = noCoinState;
        } else {
            currentState = soldOutState;
        }
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    public void releaseGumball() {
        if (count > 0) {
            count--;
            System.out.println("A gumball comes rolling out the slot...");
        }
    }

    public int getCount() {
        return count;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public String toString() {
        return "GumballMachine [state=" + currentState + ", gumballs=" + count + "]";
    }
}
```

#### 4. **Client Code (Test Program)**:
```java
public class StatePatternTest {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(3);

        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertCoin(); // Sold out
    }
}
```

### **Explanation**:
1. **State Interface**: Defines the common methods `insertCoin()`, `ejectCoin()`, `turnCrank()`, and `dispense()` that all concrete states will implement.
2. **Concrete States**:
   - `NoCoinState`: Handles the case when no coin is inserted.
   - `HasCoinState`: Handles the case when a coin is inserted, but the crank hasn't been turned yet.
   - `SoldState`: Handles the case when a gumball is being dispensed.
   - `SoldOutState`: Handles the case when there are no gumballs left.
3. **GumballMachine**: Maintains the current state of the machine and handles state transitions.

### **Expected Output**:
```
GumballMachine [state=com.example.NoCoinState@1b6d3586, gumballs=3]
Coin inserted.
GumballMachine [state=com.example.SoldState@4554617c, gumballs=2]
Coin inserted.
GumballMachine [state=com.example.SoldState@74a14482, gumballs=1]
Coin inserted.
Sorry, the machine is sold out.
```

### **Conclusion**:
The **State Pattern** allows the `GumballMachine` to change its behavior based on its internal state. Each state defines its own actions for coin insertion, crank turning, and gumball dispensing. The machine transitions between states as actions are performed, providing a flexible and easy-to-understand solution for managing the machine's different states. */