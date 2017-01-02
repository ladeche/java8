package test.lambda;

import org.omg.CORBA.SystemException;

import test.lambda.variablecapture.IntegerMath;

public class VariableCapture implements Runnable {

	private int instanceVariable = 5;
	static IntegerMath le;

	public static void main(String args[]) throws InterruptedException {
		
		// 1) Thread 1 autonome
		VariableCapture vc = new VariableCapture();
		le = vc.test(1);
		// exécution de la lambda dans un thread (voir run)
		Thread thread = new Thread(vc);
		thread.start();
		
		// 2) le thread 1 est terminé, je lance le thread 2 en ayant redéfini la lambda 
		Thread.sleep(200);
		le = vc.test(2);
		thread = new Thread(vc);
		thread.start();
		
		// 3) le thread 2 est terminé, je lance le thread 3 en ayant redéfini la lambda
		// Mais la lambda sera redéfinie avant exécution réelle du thread 3
		Thread.sleep(200);
		le = vc.test(3);
		thread = new Thread(vc);
		thread.start();
		// 4) le thread 3 est en cours, je redéfini la lambda et lance le thread 4 
		// => les lambda des thread 3 et 4 donnent le même résultat
		Thread.sleep(50);
		le = vc.test(4);
		thread = new Thread(vc);
		thread.start();
		
		// 5)6) Idem 3) et 4) mais en changeant la variable d'instance
		Thread.sleep(200);
		vc.instanceVariable=10;
		le = vc.test(5);
		thread = new Thread(vc);
		thread.start();
		// 4) le thread 3 est en cours, je redéfini la lambda et lance le thread 4 
		// => les lambda des thread 3 et 4 donnent le même résultat
		Thread.sleep(50);
		vc.instanceVariable=20;
		le = vc.test(6);
		thread = new Thread(vc);
		thread.start();
		
		// 7)8) Idem 5) et 6) mais en changeant la variable d'instance sans redéfinir la lambda
		// => Le changement dans la variable d'instance n'a pas d'impact sur le calcul faute de redéfinition de la lambda
		Thread.sleep(200);
		vc.instanceVariable=10;
		le = vc.test(7);
		thread = new Thread(vc);
		thread.start();
		// 4) le thread 3 est en cours, je redéfini la lambda et lance le thread 4 
		// => les lambda des thread 3 et 4 donnent le même résultat
		Thread.sleep(50);
		vc.instanceVariable=20;
		thread = new Thread(vc);
		thread.start();

	}

	public IntegerMath test(int parameter) {
		int localVariable = 10; // pas final mais quand même impossible à redéfinir
		final int finalVariable = 30;
		
		// localVariable = 15; // illégal 
		// finalVariable = 10; // illégal (final)
		// parameter = 12;     // illégal
		IntegerMath testExpression = (x, y) -> {
			return x + y
					+ this.instanceVariable
					+ parameter
					+ localVariable
					+ finalVariable;
		};
		System.out.println(System.currentTimeMillis()+" --- par="+parameter+" ... instvar="+this.instanceVariable);
		return testExpression;
	}

    @Override
    public void run() {
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//String ts = ((Long) System.currentTimeMillis()).toString();
    	//Integer x = new Integer(ts.substring(ts.length()-2));
    	//Integer y = new Integer(ts.substring(ts.length()-4,ts.length()-2));
    	Integer x = 10;
    	Integer y = 20;
    	System.out.println(System.currentTimeMillis()+" --- ("+this.instanceVariable+")"+x+":"+y+"->"+le.operation(x,y));
        
    }
}
