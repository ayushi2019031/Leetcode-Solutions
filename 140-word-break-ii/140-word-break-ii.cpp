class Solution {
public:
    vector<string> ans;
    void solve(string s , string ansf, vector<string>&words)
    {
        if(s.length()==0)
        {
            ansf.pop_back();
            ans.push_back(ansf);
            return;
        }
        for(int i =0 ; i<s.length();i++)
        {
            string c = s.substr(0,i+1);
            string left = s.substr(i+1);
            if(find(words.begin(),words.end(),c)!= words.end())
            {
                solve(left , ansf + c + " " , words);
            }
        }
    }
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        solve(s,"",wordDict);
        return ans;
    }
};