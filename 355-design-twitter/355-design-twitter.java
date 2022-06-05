class Tweet{
    int tweetid;
    int time; 
    public Tweet(int tweetid, int time){
        this.tweetid = tweetid;
        this.time = time; 
    }
}
class User{
    int userId; 
    ArrayList<Tweet> tweets = new ArrayList<>(); 
    HashSet<Integer> following = new HashSet<>();
    public User(int userId){
        this.userId = userId;
        following.add(userId);
    }
}
class Twitter {
    int time = 0; 
    HashMap<Integer, User> userlist = new HashMap<>();
    public Twitter() {
        
    }
    public void initialise(HashMap<Integer, User> userlist, int userid){
        userlist.put(userid, new User(userid));
    }
    public void postTweet(int userId, int tweetId) {
        if (!userlist.containsKey(userId)){initialise(userlist, userId);}
        User user = userlist.get(userId);
        ArrayList<Tweet> tweets =  user.tweets;
        user.tweets.add(new Tweet(tweetId, time));
        
        if (user.tweets.size() == 11){
            ArrayList<Tweet> ll = new ArrayList<>(); 
            for (int i = 1; i < 11; i++){
                ll.add(user.tweets.get(i));
            }
            user.tweets = ll; 
        }
        time += 1;
        System.out.println(userId + " " + user.tweets);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Tweet> list = new ArrayList<>(); 
        User user = userlist.get(userId);
        if (user == null){
            initialise(userlist, userId);
            user = userlist.get(userId);
        }
        System.out.println(user.following);
        for (Integer k: user.following){
            User ff = userlist.get(k);
            if (ff == null){
                initialise(userlist, k);
            ff = userlist.get(k);
            }
            ArrayList<Tweet> ref = ff.tweets;
            for (Tweet num: ref){
                list.add(num);
            }            
        }
        Collections.sort(list, new Comparator<Tweet>(){
            public int compare(Tweet o1, Tweet o2){
                int kk = o1.time - o2.time;
                return -1*kk; 
            }
        });
        ArrayList<Integer> news = new ArrayList<>(); 
        for (int i = 0; i < Math.min(list.size(), 10); i++){
            news.add(list.get(i).tweetid);
        }
            return news; 
    }
    
    public void follow(int userId, int followeeId) {
        if (!userlist.containsKey(userId)){initialise(userlist, userId);}
        User user = userlist.get(userId);
        HashSet<Integer> people = user.following; 
        people.add(followeeId);
     }
    
    public void unfollow(int userId, int followeeId) {
     if (!userlist.containsKey(userId)){initialise(userlist, userId);}
        User user = userlist.get(userId);
        HashSet<Integer> people = user.following; 
        people.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */