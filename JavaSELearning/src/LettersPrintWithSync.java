public class LettersPrintWithSync implements Runnable {

    private StringBuffer letterObject = new StringBuffer("A");

    public static void main(String[] args) {
        LettersPrintWithSync theJob = new LettersPrintWithSync();
        Thread threadA = new Thread(theJob);
        Thread threadB = new Thread(theJob);
        Thread threadC = new Thread(theJob);
        threadA.start();
        threadB.start();
        threadC.start();
    }

    @Override
    public void run() {
        synchronized (letterObject) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(letterObject);
            }
            char theLetter = letterObject.charAt(0);
            theLetter++;
            letterObject.insert(0, theLetter);
        }
    }
}
