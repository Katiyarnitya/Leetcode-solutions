class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long MOD = 1000000007L;

        ArrayList<Integer> hAl = new ArrayList<>();
        ArrayList<Integer> vAl = new ArrayList<>();

        for (int h : hFences) hAl.add(h);
        for (int v : vFences) vAl.add(v);

        hAl.add(1);
        hAl.add(m);
        vAl.add(1);
        vAl.add(n);
        Collections.sort(hAl);
        Collections.sort(vAl);

        HashSet<Integer> setV = new HashSet<>();
        HashSet<Integer> setH = new HashSet<>();

        for(int i=0;i<hAl.size();i++){
            for(int j=i+1;j<hAl.size();j++){
                setH.add(hAl.get(j)-hAl.get(i));
            }
        }
        for(int i=0;i<vAl.size();i++){
            for(int j=i+1;j<vAl.size();j++){
                setV.add(vAl.get(j)-vAl.get(i));
            }
        }

 long maxSide = 0;
        for (int d : setH) {
            if (setV.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        if (maxSide == 0) return -1;

        return (int)((maxSide * maxSide) % MOD);
    }
}