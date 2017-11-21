package main;

public class Runner
{
    /**
     * main method, gets run on start of program
     */
    public static void main(String[] args)
    {
        // creates a new simulation with the following parameters and calls the run method.
        // Average percent difference of population: 10.23%
        // Percent difference of T1 (male): 23.61%
        // Percent difference of T2 (female): 0.96%
        // Size of T1: 9 (males)
        // Size of T2: 13 (females)
        // Number of trials: 50 million

        new Simulator(0.1023, 0.2361, 0.0096, 9, 13, 50000000).run();
    }

}
