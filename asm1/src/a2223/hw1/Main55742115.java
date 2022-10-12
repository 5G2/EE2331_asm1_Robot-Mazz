package a2223.hw1;

public class Main55742115 { 
    public static void main(String[] args) { 
    	int sum =0;

    	for(int i =0;i<1000000;i++) {
    		boolean finished = false;
    		Robot r1 = new Robot();
        	Maze m1 = new Maze();
        	m1.set1();
        	int nextStep = 2;
        	
        	while(!finished) {
        		int ran1 = (int)(Math.random() * 4);
        		
        		switch(r1.getState()){
        		case 1:
        			if(ran1==0||ran1==1)
        				nextStep=1;
        			if(ran1==2)
        				nextStep=3;
        			if(ran1==3)
        				nextStep=4;
        			break;
        		case 2:
        			if(ran1==0||ran1==1)
        				nextStep=2;
        			if(ran1==2)
        				nextStep=3;
        			if(ran1==3)
        				nextStep=4;
        			break;
        		case 3:
        			if(ran1==0||ran1==1)
        				nextStep=3;
        			if(ran1==2)
        				nextStep=1;
        			if(ran1==3)
        				nextStep=2;
        			break;
        		case 4:
        			if(ran1==0||ran1==1)
        				nextStep=4;
        			if(ran1==2)
        				nextStep=1;
        			if(ran1==3)
        				nextStep=2;
        			break;
        		}
        		switch(nextStep){
        		case 1:
        			if(m1.checkAvaliableMove(r1.getCurrentPositionX()-1, r1.getCurrentPositionY())) {
        	        	r1.moveLeft();
        	        	r1.setState(1);
        			}
        			break;
        		case 2:
        			if(m1.checkAvaliableMove(r1.getCurrentPositionX()+1, r1.getCurrentPositionY())) {
        	        	r1.moveRight();
        	        	r1.setState(2);
        	    	}
        			break;
        		case 3:
        			if(m1.checkAvaliableMove(r1.getCurrentPositionX(), r1.getCurrentPositionY()+1)) {
        	        	r1.moveDown();
        	        	r1.setState(3);
        	    	}
        			break;
        		case 4:
        			if(m1.checkAvaliableMove(r1.getCurrentPositionX(), r1.getCurrentPositionY()-1)) {
        	        	r1.moveUp();
        	        	r1.setState(4);
        	    		}
        			break;
        		}
        		m1.setWalked(r1.getCurrentPositionX(),r1.getCurrentPositionY());
        		if(m1.checkLose(r1.getCurrentPositionX(), r1.getCurrentPositionY())) {
        			finished = true;
        		}
        		if(m1.checkWin(r1.getCurrentPositionX(), r1.getCurrentPositionY())) {
        			finished = true;
        			sum++;
        }}}

    	
    	System.out.println("The Monte Carlo simulation result of one million runs:");
    	System.out.println("No. of successful escape: " + sum);
    	System.out.printf("Success Rate P: %.3f"  ,(double)sum/1000000);

    	
    }  
   private static class Robot { 
	   private int currentPositionX=0;
	   private int currentPositionY=0;
	   private int state=1;
	   
	   
	   public int getCurrentPositionX() {
		   return currentPositionX;
	   }
	   public int getCurrentPositionY() {
		   return currentPositionY;
	   }
	   
	   public void moveLeft() {
		   this.currentPositionX--;
	   }
	   public void moveRight() {
		   this.currentPositionX++;
	   }
	   public void moveUp() {
		   this.currentPositionY--;
	   }
	   public void moveDown() {
		   this.currentPositionY++;
	   }
	   public int getState() {
		   return state;
	   }
	   public void setState(int state) {
		   this.state= state ;
	   }
} 

   private static class Maze { 
	   private final int[][] size = new int [7][7];
	   public void set1() {
		   this.size[0][0]=1;
	   }
	   public boolean checkAvaliableMove(int xPosition,int yPosition) {
		   if(xPosition>6||xPosition<0||yPosition>6||yPosition<0||size[xPosition][yPosition]==1) {
			   return false;
		   }
		   return true;
	   }
	   public void setWalked(int x, int y) {
		   size[x][y]=1;	  
	   }
	   
	   public boolean checkWin(int x, int y) {
		   if (x==6&&y==6) {
			   return true;
		   }
		   return false;
	   }
	   public boolean checkLose(int x, int y) {
		   if ((x==0||size[x-1][y]==1)&&(x==6||size[x+1][y]==1)&&(y==0||size[x][y-1]==1)&&(y==6||size[x][y+1]==1)) {
			   return true;
		   }
		   return false;
	   }
	   
   } 
} 