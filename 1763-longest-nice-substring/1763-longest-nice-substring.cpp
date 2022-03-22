class Solution {
public:
    string longestNiceSubstring(string s) {
        if (s.size()) {
            unordered_set<char> ss(s.begin(), s.end()); 
            for (int i = 0; i < s.size(); ++i) 
                if (!ss.count(s[i]^32)) {
                    string cand0 = longestNiceSubstring(s.substr(0, i)), cand1 = longestNiceSubstring(s.substr(i+1)); 
                    return cand0.size() >= cand1.size() ? cand0 : cand1; 
                }
        }
        return s; 
    }
};