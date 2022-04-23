public class Codec {
    static int counter =0; 
    HashMap<Integer, String> hash = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (hash2.containsKey(longUrl)) return Integer.toString(hash2.get(longUrl));
        counter += 1; 
        hash.put(counter, longUrl);
        hash2.put(longUrl, counter);
        return Integer.toString(counter);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hash.get(Integer.parseInt(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));