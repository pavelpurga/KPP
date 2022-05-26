package lab.kpp;



public class DataClass {
    private final String words;
    private final char symbol;
    public DataClass(String words,char symbol){
        this.words = words;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getWords() {
        return words;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass()!=o.getClass()) return false;
        DataClass dataClass = (DataClass) o;
        return ((this.words.equals(((DataClass) o).words) && this.symbol == ((DataClass) o).symbol));
    }
    @Override
    public int hashCode(){
        int res = 1;
        res = 31*res + words.hashCode();
        res = 31*res + (int) Double.doubleToLongBits(symbol);
        return res;
    }
}