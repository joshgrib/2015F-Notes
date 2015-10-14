/**A simulation of queues at a airport
 * CS284 - Data Structures
 * Homework 3
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 */

/*  NOTES
    Use setters in constructors so I can add data validation later if I want to
    When a new passenger comes, they should go in the shortest of their type of line
    PROBLEM - on mode 1, FF are never served first
        New passenger, added to an FF line!
        New passenger, added to an FF line!
        New passenger, added to an FF line!
        New passenger, added to an FF line!
        New passenger, added to a normal line!
        Served passenger 4, FF:false
        New passenger, added to a normal line!
        Served passenger 0, FF:true
        Served passenger 5, FF:false
        ...

*/
import java.util.*;
import java.time.*;
public class hw3{
    /**Class to represent the server*/
    public static class Server{
        /**The minumum time to process a passenger*/
        private long minProcTime;
        /**The maximum time to process a passenger*/
        private long maxProcTime;
        /**If the sevre is idle or not*/
        private boolean isIdle;
        /**What policy they are using
         * 1 - Altrnate FF and normal
         * 2 - Serve whoever has waited the longest
         * 3 - Serve all FF before normal passengers
         */
        private int mode;
        /**Track the last passenger served, equal to the FF status of the passenger*/
        private boolean lastServedFF = true;

        /**Constructor*/
        public Server(int m){
            if(m<1 || m>3)
                throw new IllegalArgumentException("Not an available mode");
            this.mode = m;
            System.out.println("New sever created on mode: " + m);
            setIsIdle(true);
        }

        /**Getter for isIdle
         * @return      The server idle status
         */
        public boolean isIdle(){
            return this.isIdle;
        }

        /**Setter for isIdle
         * @param       The value to be set as the server idle status
         */
        public void setIsIdle(boolean tempVal){
            this.isIdle = tempVal;
        }

        /**Serve the appropriate passenger using the policy
         * @param norm  The normal passenger line
         * @param ff    The frequent flyer line
         */
        public Passenger serve(Line[] norm, Line[] ff){
            Line toServe;
            switch(this.mode){
                case 1:
                //alternate
                //toServe = ff[0];
                if( this.lastServedFF || ((ff[0].size() == 0) && (norm[0].size() > 0)) ){
                    toServe = norm[0];
                    for(int i=0; i<norm.length; i++){
                        if(norm[i].look() != null && toServe.look() != null){
                            if(norm[i].look().passID < toServe.look().passID)
                                toServe = norm[i];
                        }
                    }
                }
                else if( !this.lastServedFF || ((ff[0].size() > 0) && (norm[0].size() == 0)) ){
                    toServe = ff[0];
                    for(int j=0; j<ff.length; j++){
                        if(ff[j].look() != null && toServe.look() != null){
                            if(ff[j].look().passID < toServe.look().passID)
                                toServe = ff[j];
                        }
                    }
                }else{
                    //this should never happen but it needs to be here
                    System.out.println("The thing that was never supposed to happen happened. Check Server.serve() under case 1.");
                    toServe = null;
                }
                break;

                case 2:
                //longest wait
                toServe = norm[0];
                for(int i=0; i<norm.length; i++){
                    if(norm[i].look() != null && toServe.look() != null){
                        if(norm[i].look().passID < toServe.look().passID)
                            toServe = norm[i];
                    }
                }
                for(int j=0; j<ff.length; j++){
                    if(ff[j].look() != null && toServe.look() != null){
                        if(ff[j].look().passID < toServe.look().passID)
                            toServe = ff[j];
                    }
                }
                break;

                case 3:
                //all ff first
                toServe = norm[0];
                for(int i=0; i<norm.length; i++){
                    if(norm[i].look() != null && toServe.look() != null){
                        if(norm[i].look().passID < toServe.look().passID)
                            toServe = norm[i];
                    }
                }
                for(int j=0; j<ff.length; j++){
                    if(ff[j].look() != null)
                        toServe = ff[j];
                }
                break;

                default:
                System.out.println("Sorry for some reason that mode isn't available");
                toServe = null;
                break;
            }
            if(toServe.look() != null)
                this.lastServedFF = toServe.look().isFreqFlyer();
            //System.out.println(this.lastServedFF);
            return toServe.serve();
        }
    }


    /**Class to represent a passenger*/
    public static class Passenger{
        /**A unique identifier for each passenger*/
        private int passID = 0;
        /**The time the passenger gets in line*/
        private long arrivalTime = 0;
        /**The time it takes to process the passenger*/
        private long procTime = 0;
        /**If a passenger is a frequent flyer or not*/
        private boolean isFreqFlyer = false;

        /**Constructor
         * @param newID         The new passenger ID
         * @param arrival       The arrival time of the passenger
         * @param proc          The processing time of the passenger
         * @param isFF          If the passenger is a frequent flyer
         */
        public Passenger(int newID, long arrival, long proc, boolean isFF){
            //System.out.println("New passenger created");
            setPassID(newID);
            setArrivalTime(arrival);
            setProcTime(proc);
            setIsFreqFlyer(isFF);
        }

        /**Getter for passID
         * @return      The passenger ID
         */
        public int passID(){
            return this.passID;
        }

        /**Getter for arrivalTime
         * @return      The passenger arrival time
         */
        public long arrivalTime(){
            return this.arrivalTime;
        }

        /**Getter for procTime
         * @return      The passenger processing time
         */
        public long procTime(){
            return this.procTime;
        }

        /**Getter for isFreqFlyer
         * @return      The passenger's frequent flyer status
         */
        public boolean isFreqFlyer(){
            return this.isFreqFlyer;
        }

        /**Setter for passID
         * @param tempVal   The value to be set as the passenger ID
         */
        public void setPassID(int tempVal){
            this.passID = tempVal;
        }

        /**Setter for arrivalTime
         * @param tempVal   The value to be set as the passenger arrival time
         */
        public void setArrivalTime(long tempVal){
            this.arrivalTime = tempVal;
        }

        /**Setter for procTime
         * @param tempVal   The value to be set as the passenger processing time
         */
        public void setProcTime(long tempVal){
            this.procTime = tempVal;
        }

        /**Setter for freqFlyer
         * @param tempVal   The value to be set as the passenger frequent flyer status
         */
        public void setIsFreqFlyer(boolean tempVal){
            this.isFreqFlyer = tempVal;
        }
    }


    /**Class to represent a line at the airport*/
    public static class Line{
        /**The queue, a Queue of objects of type Passenger*/
        private Queue<Passenger> queue;

        /**Constructor*/
        public Line(){
            //System.out.println("New line created");
            this.queue = new LinkedList<Passenger>();
        }

        /**Method to add a passenger to the end of the line
         * @param p     The passenger, of type Passenger, to add to the line
         */
        public void add(Passenger p){
            queue.offer(p);
        }

        /**Method to serve the next passenger in the line
         * @return      The passenger in the front of the line, removing them from the line
         */
        public Passenger serve(){
            return queue.poll();
        }

        /**Method to see the next passenger in the line
         * @return      The passenger in the front of the line, keeping them in the line
         */
        public Passenger look(){
            return queue.peek();
        }

        /**Method to get the size of the line
         * @return      The size of the line
         */
        public int size(){
            return queue.size();
        }
    }


    /**Class to run the simulation*/
    public static class Sim{
        /**The minimum processing time for a passenger*/
        private long minProcTime;
        /**The maximum processing time for a passenger*/
        private long maxProcTime;
        /**The duration of the simulation*/
        private long duration;
        /**An array to hold the servers*/
        private Server[] server;
        /**An array to hold the normal lines*/
        private Line[] normalLine;
        /**An array to hold the frequent flyer lines*/
        private Line[] freqFlyerLine;
        /**The count of passengers*/
        private int pCount = 0;
        /**A clock for timekeeping
         * @deprecated
         */
        private Clock clock;
        /**The start time of the simulation*/
        private long startTime;
        /**Random object for random numbers, with seed based on time*/
        private Random rand = new Random(System.currentTimeMillis());
        /**Integer of seconds between arrivals*/
        private long sba;
        /**To scale the simulation speed*/
        private long ts;

        /**Constructor
         * @param servers           The amount of servers for the simulation
         * @param minProcT          The minimum processing time for a customer
         * @param maxProcT          The maximum processing time for a customer
         * @param simDuration       The duration of the simulation
         * @param normalLines       The amount of lines for normal passengers
         * @param freqFlyerLines    The amount of lines for frequent flyers
         * @param mode              The policy the servers are using
         */
        public Sim(
            int servers,
            long minProcT,
            long maxProcT,
            long simDuration,
            int normalLines,
            int freqFlyerLines,
            int mode,
            long secsBetweenArrivals,
            long timescale){

            this.minProcTime = minProcT;
            this.maxProcTime = maxProcT;
            this.duration = simDuration;

            server = new Server[servers];
            for(int i=0; i<servers; i++){
                server[i] = new Server(mode);
            }

            normalLine = new Line[normalLines];
            for(int j=0; j<normalLines; j++){
                normalLine[j] = new Line();
            }

            freqFlyerLine = new Line[freqFlyerLines];
            for(int k=0; k<freqFlyerLines; k++){
                freqFlyerLine[k] = new Line();
            }

            this.sba = secsBetweenArrivals;
            this.ts = timescale;

            startTime = System.currentTimeMillis();

            System.out.println("Simulation created with:");
            System.out.println("    Minimum processing time:       " + minProcT);
            System.out.println("    Maximum processing time:       " + maxProcT);
            System.out.println("    Duration time:                 " + simDuration);
            System.out.println("    Servers:                       " + servers);
            System.out.println("    Normal passenger lines:        " + normalLines);
            System.out.println("    Frequent flyer lines:          " + freqFlyerLines);
            System.out.println("    Start time:                    " + startTime);
            System.out.println("    Mean seconds between arrivals: " + secsBetweenArrivals);
        }

        /**Gets the next passender ID
         * @return The next PID as an ints
         */
        private int getPID(){
            int val = pCount;
            pCount += 1;
            return val;
        }

        /**Gets the current elapsed time since the start of the simulation
         * @return The elapsed time in nanoseconds
         */
        private long getTime(){
            return (System.currentTimeMillis()-startTime);
        }

        /**Determines the processing time of a passenger
         * @return Processing time as a long
         */
        private long getProcTime(){
            long diff = maxProcTime - minProcTime;
            double ans = minProcTime + (diff * Math.random());
            return (long)ans;
        }

        /**Determines in a passenger is a frequent flyer or not
         * @return A random true or false as a boolean
         */
        private boolean getFF(){
            if((rand.nextInt()%2) != 0){
                return true;
            }
            return false;
        }

        /**Creates a new arrival and puts them in the shortest approriate line*/
        public void newArrival(){
            Passenger p = new Passenger(getPID(),getTime(),getProcTime(),getFF());
            if(p.isFreqFlyer){
                Line shortest = freqFlyerLine[0];
                for(int i=0; i<freqFlyerLine.length; i++){
                    if(freqFlyerLine[i].size() < shortest.size()){
                        shortest = freqFlyerLine[i];
                    }
                }
                shortest.add(p);
                System.out.println("New passenger added to an FF line!");
            }
            else {
                Line shortest = normalLine[0];
                for(int j=0; j<normalLine.length; j++){
                    if(normalLine[j].size() < shortest.size()){
                        shortest = normalLine[j];
                    }
                }
                shortest.add(p);
                System.out.println("New passenger added to a normal line!");
            }
        }

        /*Prints some stats on the simulation*/
        public void status(){
            System.out.println("---Status---");
            for(int i=0; i<normalLine.length; i++){
                System.out.println("Normal line " + i + " size: " + normalLine[i].size());
            }
            for(int j=0; j<freqFlyerLine.length; j++){
                System.out.println("FF line " + j + " size:     " + freqFlyerLine[j].size());
            }
        }

        /**Method to get a random int with a poisson distribution - Credit to Donald Knuth
         * @param mean      The mean of the distribution
         */
        private static int getPoissonRandom(double mean) {
            Random r = new Random();
            double L = Math.exp(-mean);
            int k = 0;
            double p = 1.0;
            do {
                p = p * r.nextDouble();
                k++;
            } while (p > L);
            return k - 1;
        }

        /**Method to run the simulation*/
        public void run(){
            System.out.println("---STARTING SIMULATION---");
            long nextArrival;
            long lastArrival = getTime();
            while(getTime() < duration){
                nextArrival = lastArrival + (long)getPoissonRandom(this.sba);
                for(int s=0; s<server.length; s++){
                    if(server[s].isIdle()){
                        Passenger served = server[s].serve(normalLine, freqFlyerLine);
                        if(served != null){
                            //System.out.println(System.currentTimeMillis());
                            long start = System.currentTimeMillis();
                            while((served.procTime + start) > System.currentTimeMillis()){
                                //System.out.println("processing");
                            }
                            System.out.println("Served passenger " + served.passID + ", FF:" + served.isFreqFlyer());// + " who had a proctime of " + served.procTime);
                            System.out.println("Last served FF?: " + server[s].lastServedFF);
                            //System.out.println(System.currentTimeMillis());
                            //System.out.println("---------------------------------------------");
                        }
                    }
                }
                if( getTime() > nextArrival ){
                    newArrival();
                    lastArrival = nextArrival;
                }
                //status();
            }
            System.out.println("----ENDING SIMULATION----");
        }
    }


    /**Main method - used for testing*/
    public static void main(String[] args) {
        /*
            Passenger josh = new Passenger(0, 2000, 4000, true);
            System.out.println(josh.passID);
            System.out.println(josh.arrivalTime);
            System.out.println(josh.procTime);
            System.out.println(josh.isFreqFlyer);
            Server bob = new Server();
            System.out.println(bob.isIdle);
            Line myLine = new Line();
            myLine.add(josh);
            System.out.println(myLine.size());
            System.out.println(myLine.look().passID);
            System.out.println(myLine.serve().passID);
            System.out.println(myLine.size());
        */
        System.out.println("---");

        long TIMESCALE = 960; //run at 480x speed - 1 hour = 7.5 seconds
        long SECONDS = 1000/TIMESCALE;//1 billion nanoseconds in a second
        long MINUTES = 60 * SECONDS;
        long HOURS = 60 * MINUTES;

        int SERVERS = 1;
        long MIN_PROC_TIME = 1 * MINUTES;
        long MAX_PROC_TIME = 5 * MINUTES;
        long SIM_DURATION = 1 * HOURS;
        int NORMAL_LINES = 1;
        int FREQ_FLYER_LINES = 1;
        int MODE = 1; //1 for alternate, 2 for longest, 3 for all FF first
        long SECS_BETWEEN_ARRIVALS = 3 * MINUTES;
        Sim mySim = new Sim(SERVERS, MIN_PROC_TIME, MAX_PROC_TIME, SIM_DURATION, NORMAL_LINES, FREQ_FLYER_LINES, MODE, SECS_BETWEEN_ARRIVALS, TIMESCALE);

        mySim.status();
        mySim.run();
        mySim.status();
    }
}
/* TERMINAL OUTPUT
---

---
*/
