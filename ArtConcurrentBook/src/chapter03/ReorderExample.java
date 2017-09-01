package chapter03;

class ReorderExample {
    int     a    = 0;
    boolean flag = false;

    public void writer() {
        a = 1; //1
        flag = true; //2
    }

    public void reader() {
        if (flag) { //3
            int i = a * a; //4
            System.out.println(i);
            //s¡­¡­
        }
    }
    
    public static void main(String[] args) {
		
    	final ReorderExample reorderExample = new ReorderExample();
    	
    	Thread writeThread = new Thread(){
    		@Override
    		public void run() {
    			super.run();
    			reorderExample.writer();
    		}
    	};
    	Thread readThread = new Thread(){
    		@Override
    		public void run() {
    			super.run();
    			reorderExample.reader();
    		}
    	};
    	
    	writeThread.start();
    	readThread.start();
    	
	}
    
}
