class Solution {
    public int compareVersion(String version1, String version2) {
        version1 = version1+".0";
        version2 = version2+".0";
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int exL = Math.abs(a.length - b.length);
        if(a.length > b.length){
            char c = '0';
            while(exL-->0){
                version2 = version2+"."+c;
            }
        }
        else {
            char c = '0';
            while(exL-->0){
                version1 = version1+"."+c;
            }
        }
    
        
        /// now two strings are equal
        a= version1.split("\\.");
        b = version2.split("\\.");
        System.out.println(a.length + " "+ b.length);
        for(int i =0;i<a.length;i++){
            int p = Integer.parseInt(a[i]);
            int q = Integer.parseInt(b[i]);
           
            if(p > q) return 1;
            if(p < q) return -1;
        }
        return 0;
    }
}