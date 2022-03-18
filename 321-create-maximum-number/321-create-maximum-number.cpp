class Solution {
	public:


	   vector<int> maxNumber(vector<int> &nums1, vector<int> &nums2, int k)
		{
			vector<int> ans;
			for (int i = 0; i <=k; i++)
			{
				int j = k - i;
				
				if(i>nums1.size()||j>nums2.size()) continue;

				vector<int> n1 = calculateNGEType(nums1, i);
				vector<int> n2 = calculateNGEType(nums2, j);
                // cout << "Yayy"; 
                for (auto i = n1.begin(); i != n1.end(); ++i)cout << *i << " ";
                cout << endl; 
                for (auto i = n2.begin(); i != n2.end(); ++i)cout << *i << " ";
				vector<int> t = merge(n1, n2,k);
				if(t>ans)ans=t;

			}

			return ans;
		}


		bool greater(vector<int> n1, vector<int> n2,int i,int j){
			int ns1 = n1.size();
			int ns2 = n2.size();
			while (i < ns1 || j < ns2)
			{
				if (i >= ns1)
					return false;
				else if (j >= ns2)
					return true;
				else if (n1[i] > n2[j])
					return true;
				else if (n1[i] < n2[j])
					return false;
				else
				{
					i++,j++;
				}
			}
			return true;
		}

		vector<int> merge(vector<int> n1, vector<int> n2,int k)
		{
			int ns1 = n1.size();
			int ns2 = n2.size();
			int i = 0, j = 0, l = 0;
			vector<int> ans;
			while ((i < ns1 || j < ns2)&&k>0 )
			{
				if (i >= ns1)
					ans.push_back(n2[j++]);
				else if (j >= ns2)
					ans.push_back(n1[i++]);
				else if (n1[i] > n2[j])
					ans.push_back(n1[i++]);
				else if (n1[i] < n2[j])
					ans.push_back(n2[j++]);
				else 
				{
					if(greater(n1,n2,i,j))
						ans.push_back(n1[i++]);
					else
						ans.push_back(n2[j++]);
				}
				k--;
			}
			return ans;
		}

		vector<int> calculateNGEType(vector<int> &nums1, int k)
		{
			int removal = nums1.size() - k;
			vector<int> n1;

			for (int i = 0; i < nums1.size(); i++)
			{
				while (n1.size() > 0 && removal > 0 && n1.back() < nums1[i])
				{
					removal--;
					n1.pop_back();
				}
				n1.push_back(nums1[i]);
			}

			return n1;
		}


	};