class Solution {
public:
    string reorganizeString(string s) {
        unordered_map<char, int> mp;
        priority_queue<pair<int, char>> pq;
        int sz = s.size();
        for(char ch : s)
        {
            mp[ch]++;
        }
        for(auto ch : mp)
        {
            pq.push({ch.second, ch.first});
        }
        if(pq.top().first > (sz+1)/2)
            return "";
        
        int i = 0;
        while(!pq.empty())
        {
            pair<int, char> chr = pq.top();
            pq.pop();
            for(int j = 0; j < chr.first; j++)
            {
                //cout<<chr.second;
                if(i >= sz) i = 1;
                s[i] = chr.second;
                i = i+2;
            }
        }
        return s;
    }
};