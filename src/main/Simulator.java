package main;

import java.util.Random;

public class Simulator
{
    // class variables for use in calculations
    double avgPercent;
    double t1Percent;
    double t2Percent;
    int t1Size;
    int t2Size;
    int trials;

    // number of successes in treatments per trial
    int t1SuccessCount;
    int t2SuccessCount;

    // calculated percent given a random distributon
    double t1NewPercent;
    double t2NewPercent;


    // accululative average difference between prediction and actual recorded value
    double avgt1Diff, avgt2Diff;

    // random number generator
    Random r;

    public Simulator(double avgPercent, double t1Percent, double t2Percent, int t1Size, int t2Size, int trials)
    {
        // initializes class variables
        this.avgPercent = avgPercent;
        this.t1Percent = t1Percent;
        this.t2Percent = t2Percent;
        this.t1Size = t1Size;
        this.t2Size = t2Size;
        this.trials = trials;

        r = new Random();
    }

    public void run()
    {
        // trial loop
        for(int i = 0; i < trials; i++)
        {
            /**
             *  treatment 1 (male) loop
             *  for each test subject, generate a random number between 0 and 1,
             *  if the number is less than the average percent, call it a success and increase the count of successes
             *  otherwise, reject it
             */
            for (int j = 0; j < t1Size; j++)
            {
                double res = r.nextDouble();
                // System.out.println(res);     // output the random number to screen (for creating dotplot)
                if (res <= avgPercent)
                {
                    t1SuccessCount++;
                }
            }

            /**
             * treatment 2 (female) loop
             * same as above
             */
            for (int k = 0; k < t2Size; k++)
            {
                double res = r.nextDouble();
                // System.out.println(res);     // output the random number to screen (for creating dotplot)
                if (res <= avgPercent)
                {
                    t2SuccessCount++;
                }
            }

            // calculate new percents from simulation
            t1NewPercent = ((double)t1SuccessCount / (double)t1Size);
            t2NewPercent = ((double)t2SuccessCount / (double)t2Size);

            // add the difference between simulation and actual to the total
            avgt1Diff += (t1NewPercent - t1Percent);
            avgt2Diff += (t2NewPercent - t2Percent);


            // reset counts at end of trial for next loop
            t1SuccessCount = 0;
            t2SuccessCount = 0;
        }

        // finalize average differences by dividing by the total trials
        avgt1Diff /= (double)trials;
        avgt2Diff /= (double)trials;

        // output the values to screen
        System.out.println("male average difference between sim and trials: \t" + avgt1Diff);
        System.out.println("female average difference between sim and trials: \t" + avgt2Diff);

    }
}
