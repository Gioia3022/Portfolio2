public class Node {
    private String cityName;
    private boolean isIncluded = false;

    public Node(String name){
        this.cityName = name;
    }

    String getName(){return this.cityName; }
    Boolean getIsIncluded(){return this.isIncluded; }

    void setName(String n){this.cityName = n; }
    void setIncluded(boolean is){this.isIncluded = is; }
}
