public class Node {
    private String cityName;
    private boolean isIncluded = false;
    private int number;

    public Node(String name){
        this.cityName = name;
        //this.number = n;
    }

    String getName(){return this.cityName; }
    Boolean getIsIncluded(){return this.isIncluded; }
    Integer getNumber(){return this.number; }

    void setName(String n){this.cityName = n; }
    void setIncluded(boolean is){this.isIncluded = is; }
    void setNumber(int n){this.number = n; }
}
