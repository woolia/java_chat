import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

	public static void main(String[] args) {
		
		Socket socket = null; // Server�� ����ϱ� ���� Client�� Socket
		BufferedReader in = null; // Server�κ��� �����͸� �о���̱� ���� �Է½�Ʈ��
		BufferedReader in2 = null; // Ű����κ��� �о���̱� ���� �Է½�Ʈ�� 
		PrintWriter out = null; // ������ �������� ���� ��� ��Ʈ��
		
		InetAddress ia = null; 
		
		try {
			ia = InetAddress.getLocalHost(); // ������ �����ϱ� ���� ���� �ּҸ� �Է�
			
			/*
			 * Ŭ���̾�Ʈ-���� ���� ��Ʈ��ũ ��� �Ҷ� �ʿ��� ���� �ΰ��� �̴�.
			 * Ŭ���̾�Ʈ�� ������ IP �ּҿ� ��Ʈ��ȣ�� �˾ƾ��Ѵ�.
			 * ���⼭�� ��ǻ�� �Ѵ�� Ŭ���̾�Ʈ-���� ����� �ϱ� ������ ia�� getLocalHost()�� ����Ͽ�
			 * Local IP Address(���� IP �ּ�)�� �ҷ���
			 * ��Ʈ��ȣ�� 4444�� �����߱� ������ 4444�� �Է��Ѵ�.
			 */
			
			socket = new Socket(ia,4444);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // BufferedReader ����
			in2 = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader2 ����
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			
			System.out.println(socket.toString());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			System.out.print("������ ���� �޼��� : ");
			String data = in2.readLine(); // Ű����κ��� �Է�
			out.println(data);
			out.flush();
			
			String data2 = in.readLine();
			System.out.println("�����κ��� �ǵ��ƿ� �޼��� : " + data2);

			socket.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
