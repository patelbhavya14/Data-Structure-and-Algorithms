package searching;


public class HashTable {
    private static int capacity = 10;
    private int n = 0;
    private int m;
    private int insertProbe;
    private int searchProbe = 0;
    private static int totalSearchProbes = 0;
    private static int totalInsertProbes = 0;
    private String values[];
    private static double loadFactor;

    HashTable(int capacity, double load) {
        this.m = capacity;
        this.loadFactor = load;
        values = new String[m];
    }

    public void setTotalSearchProbes(int totalSearchProbes) {
        this.totalSearchProbes = totalSearchProbes;
    }

    public int getTotalSearchProbes() {
        return totalSearchProbes;
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public int getM() {
        return m;
    }

    public void add(int key, String val) {
        values[hashValue(key)] = val;
        this.n++;
    }

    public int search(String val) {
        this.searchProbe = 0;
        int i = 0;
        int v = Integer.parseInt(val);
        int index = (v+i)%this.m;
        //System.out.println("VALUE TO BE SEARCH="+val);

        if(values[index] == null) {
            this.searchProbe++;
            return -1;
        } else {
            if(values[index].equals(val)) {
                this.searchProbe++;
                return searchProbe;
            } else {
                this.searchProbe++;
                for(i=1; i<this.m; i++) {
                    index = (v+i)%this.m;
                    this.searchProbe++;
                    if(values[index] == null){
                        return -1;
                    } else if(values[index].equals(val)) {
                        return searchProbe;
                    }
                }
            }
        }
        return -1;
    }

    public int hashValue(int key) {
        insertProbe = 0;
        int i = 0;
        int hash = (key+i)%this.m;
        insertProbe++;
        while(values[hash] != null) {
            i++;
            insertProbe++;
            hash = (key+i)%this.m;
        }
        totalInsertProbes += insertProbe;
        return hash;
    }

    public double loadFactor() {
        return (double)this.n/this.m;
    }

    public void displayHashTable() {
        System.out.print("| ");
        for(String s: values) {
            System.out.print(s+" | ");
        }
        System.out.println();
    }
}
