package chapter03;

public class FinalReferenceEscapeExample {

    final int                          i;
    static FinalReferenceEscapeExample obj;

    public FinalReferenceEscapeExample() {
        i = 1; //1写final域
        obj = this; //2 this引用在此“逸出”
    }

    public static void writer() {
        new FinalReferenceEscapeExample();
    }

    public static void reader() {
        if (obj != null) { //3
            int temp = obj.i; //4
            System.out.println("Reader get i = " + temp);
        }
    }
    
    public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				super.run();
				FinalReferenceEscapeExample.writer();
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				super.run();
				FinalReferenceEscapeExample.reader();
			}
		};
    	
		t1.start();
		t2.start();
    	
	}
}
