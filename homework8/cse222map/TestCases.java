package cse222map;


public class TestCases implements Runnable {

    private String FileName;
    private int X_SIZE;
    private int Y_SIZE;

    public TestCases(String FileName, int X_SIZE, int Y_SIZE) {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
        this.Y_SIZE = Y_SIZE;
    }

    public void test() {

        System.out.println("\n\n*******************\nMap is " + this.FileName + " with X_SIZE " + this.X_SIZE
                + " and Y_SIZE " + this.Y_SIZE + "\n********************\n");
        CSE222Map Map = new CSE222Map(this.FileName, this.X_SIZE, this.Y_SIZE);
        Map.convertMapPNG(Map.getMap(), this.FileName.substring(0,this.FileName.length()-4) + ".png");
        CSE222Graph Graph = new CSE222Graph(Map);
        

    }

    @Override
    public void run() {
        test();
    }
}
