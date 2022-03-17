class Solution {
    public String minInteger(String num, int k) {
        char[] arr_ = num.toCharArray();
        int n = arr_.length;
        int[] arr  = new int[n];
        for (int i = 0;i < n; i++){arr[i] = arr_[i] - '0';}
        
        Queue<Integer>[] ref = new Queue[10];
        for (int i = 0; i < 10; i++) ref[i] = new LinkedList<Integer>(); 
        for (int i = 0; i < n; i++){
            ref[arr[i]].add(i);
        }
        StringBuilder strb = new StringBuilder(); 
        SegmentTree seg = new SegmentTree(n);
        for (int i = 0; i < n; i++){
            int currdigi = arr[i];
           
            for (int digi = 0; digi <= 9; digi++){
                if (ref[digi].size() == 0) continue;
                int aj = ref[digi].peek(); 
                int num_shifts = seg.getCountLessThan(aj);
                if (aj - num_shifts <= k){
                    k -= (aj - num_shifts);
                    seg.add(aj);
                    ref[digi].poll(); 
                    strb.append(Integer.toString(digi));
                    break;
                }
            }
        }
        return strb.toString(); 
    }
}

class SegmentTree {
        int[] nodes;
        int n;

        public SegmentTree(int max) {
            nodes = new int[4 * (max)];
            n = max;
        }

        public void add(int num) {
            addUtil(num, 0, n, 0);
        }

        private void addUtil(int num, int l, int r, int node) {
            if (num < l || num > r) {
                return;
            }
            if (l == r) {
                nodes[node]++;
                return;
            }
            int mid = (l + r) / 2;
            addUtil(num, l, mid, 2 * node + 1);
            addUtil(num, mid + 1, r, 2 * node + 2);
            nodes[node] = nodes[2 * node + 1] + nodes[2 * node + 2];
        }

        // Essentialy it tells count of numbers < num.
        public int getCountLessThan(int num) {
            return getUtil(0, num, 0, n, 0);
        }

        private int getUtil(int ql, int qr, int l, int r, int node) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && qr >= r) {
                return nodes[node];
            }

            int mid = (l + r) / 2;
            return getUtil(ql, qr, l, mid, 2 * node + 1) + getUtil(ql, qr, mid + 1, r, 2 * node + 2);
        }
    }



