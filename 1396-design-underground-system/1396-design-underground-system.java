class UndergroundSystem {
    HashMap<Integer,Passenger> passengers;
    HashMap<String,route> routeAvg;
    public UndergroundSystem() {
        passengers = new HashMap<>();
        routeAvg = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        passengers.put(id,new Passenger(id,stationName,t));
    }
    public void checkOut(int id, String stationName, int t) {
        Passenger arrived = passengers.get(id);
        passengers.remove(id);
        
        int difference = t - arrived.time;
        String key = arrived.station + "," +stationName;
        route path = routeAvg.containsKey(key)? routeAvg.get(key) : new route();
        path.updateDifference(difference);
        routeAvg.put(key,path);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return routeAvg.get(startStation+","+endStation).getAvg();
    }
}
class Passenger{
    public int id;
    public String station;
    public int time;
    Passenger(int id,String station,int time){
        this.id = id;
        this.station = station;
        this.time = time;
    }
}

class route{
    public double totalTime = 0;
    public int count = 0;
    public void updateDifference(int difference){
        totalTime += difference;
        count++;
    }
    public double getAvg(){
        return totalTime/count;
    }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */