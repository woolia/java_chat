import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

/*
 * extends Thread, implements Runnable �� ������ ������ ���� ����Ѵ�.
 * extends Thread�� Thread�� ��ӹް� ��üȭ�� �ڿ� ��ü��.start() �� ���� ����Ѵ�.
 * implements Runnable�� Thread ��ü �ȿ� �����带 ����Ϸ��� ��ü�� �־��༭ ��üȭ�� �� ����Ѵ�.
 * extends Thread�� implements Runnable �� ����ϴ�.
 * ������ implements Runnable �� ����ϸ� ���� ����� �����ϴ�.
 */

public class Send implements Runnable {

	DataOutputStream out;
	/*
	 * DataOutputStream �� �ڹ��� �⺻ ������ Ÿ�Ժ��� ����ϴ� ������ �޼ҵ尡 �����Ѵ�.
	 * ���� ���, double �����͸� ����Ϸ��� writeDouble(double v), char �����͸� ����Ϸ��� writeChar(int v)�� �̿��Ѵ�.
	 * ���ڿ��� ����Ҷ��� writeUTF(String str)�� ����Ѵ�.
	 * DataOutputStream�� ����ϸ� ���̳ʸ� ���·� �Էµȴ�.
	 */
	/*
	 *  �� DataInputStream
	 *  DataOutputStream�� �̿��ؼ� txt ���Ͽ� ���̳ʸ� ���·� �Է��ߴ� �ڹ� �⺻ ������ Ÿ�� �����͸� DataInputStream �� �̿��ؼ� �ٽ� �о�� �� �ִ�.
	 *  ���� ���, double �����͸� �������� readDouble(), char �����͸� ���� ���� readChar() �� ����Ѵ�.
	 *  ���ڿ��� ���� ���� readUTF() �� ����Ѵ�. 
	 */
	
	BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
	// Send Ŭ���������� in2 �� ä�� ������ �޾ƿ��� ������ �Ѵ�.
	// BufferedReader �� InputStreamReader ������ https://st-lab.tistory.com/41 ���⼭ Ȯ�� ����
	// �迵�� �״� ���̴�...
	
	public Send(DataOutputStream out) {
		this.out = out;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String msg = in2.readLine(); // �޼����� �޾ƿ�
				out.writeUTF(msg); // msg �� ���
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

// Send Ŭ������ ������ ���� �г��Ӱ� �޼��� ���� ������ �����ϴ� ������ �Ѵ�.
// Thread�� ���� �����ϱ� ������ Runnable �̶�� �����ڸ� ����
