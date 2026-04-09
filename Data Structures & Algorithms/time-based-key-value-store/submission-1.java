//even is array list we have to ffinethe nearest closest one so only we use binary serach
class Pair
{
    String value;
    int time;
    Pair(String val,int timestamp)
    {
        value=val;
        time=timestamp;
    }
}
class TimeMap 
{
    HashMap<String,ArrayList<Pair>> map;
    public TimeMap() 
    {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) 
    {
        if(!map.containsKey(key))
        {
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(value,timestamp));
    }
    public String get(String key, int timestamp)
    {
        if(!map.containsKey(key))
        return "";

        ArrayList<Pair> list = map.get(key);

        int low =0;
        int high = list.size()-1;
        String ans="";//return type is string

        while(low<=high)
        {
            int mid = (low+high)/2;
            if(list.get(mid).time == timestamp)
            return list.get(mid).value;
            else if(list.get(mid).time>timestamp)
            {
                high = mid-1;
            }
            else
            {
                ans=list.get(mid).value;
                low = mid+1;
            }
        }
        return ans;
    }
}
