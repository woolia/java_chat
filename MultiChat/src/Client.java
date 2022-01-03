import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null;
		DataInputStream in = null; // DataInputStream in�� ����ڰ� �Է��ϴ� ä�� �κп� �ش�
		BufferedReader in2 = null; // BufferedReader in2�� ������� �г��ӿ� �ش�ȴ�.
		DataOutputStream out = null; // DataOutputStream out�� ����ڰ� �Է��� �����͸� ����� ���� ����Ѵ�.
		
		try {
			InetAddress ia = null; // Local Host IP Address�� �������� ���� ����
			ia = InetAddress.getLocalHost(); // ���� PC�� IP Address�� ������
			socket = new Socket(ia,4444); // client�� IP�� port ��ȣ�� �Է�
			
			/*
			 * DataInputStream �� �Է� ��Ʈ���� �޴� �Ű������̸�
			 * socket.getInputStream() �Լ��� ���� ���Ͽ��� ���޵Ǵ� ������ ��Ʈ���� �о�´�.
			 * BufferedReader �� Scanner�� ����� �����̴�.
			 * BufferedReader�� Scanner���� �����ٴ� ������ ������ String������ ���ۿ� �����ϱ� ������
			 * ���� �����͸� �����ؼ� ����ؾ��ϴ� ��찡 ����.
			 */
			
			in = new DataInputStream(socket.getInputStream());
			in2 = new BufferedReader(new InputStreamReader(System.in));
			out = new DataOutputStream(socket.getOutputStream());
			
			System.out.print("�г����� �Է����ּ��� : ");
			String data = in2.readLine(); // ä�ÿ� ����� �г����� �޾ƿ´�.
			
			out.writeUTF(data); //�г����� UTF-8�� ���� �� ��½�Ʈ���� �ִ´�.
			Thread th = new Thread(new Send(out)); // ���ο� �����忡 out�� ����ֵ��� �մϴ�.
			th.start(); // ������ ����
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			/*
			 * �������� �������� ��� ä���� �Է¹ޱ� ������
			 * ���ѷ���(while) �ȿ��� �����Ѵ�.
			 * ���� ���� ������ break�� ���� ���ǹ��� �ɸ� �ȴ�.
			 */
			while(true) {
				String str2 = in.readUTF();
				System.out.println(str2);
				if(str2.equals("quit"))
					break;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

// Client�� ���״�� ����� �Դϴ�.
// ó�� �г����� �Է��Ͽ��ٸ�, Server�� Socket�� ���� ����Ǵ� ����
// User�� ������ ��� ä���� �� �� �ְ� �˴ϴ�.
