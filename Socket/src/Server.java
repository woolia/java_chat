import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		ServerSocket server_socket = null;
		BufferedReader in = null;
		
		PrintWriter out = null;
		
		/* try/catch exception�� RuntimeException�� �ٸ��� ġ���� ������ ������ �� ����
		 * �׷��� try/catch exception�� ���� ������ ������ ����
		 * ��Ʈ�� �����ִ��� Ȯ���ϰ� �̹� �����ִ� ��Ʈ�̸� ���� ������ ��� �� �����ؼ� ������ ����
		 *  */
		
		try {
			server_socket = new ServerSocket(4444);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("�ش� ��Ʈ�� ���� �ֽ��ϴ�.");
		}
		
		try {
			System.out.println("������ ���Ƚ��ϴ�.");
			socket = server_socket.accept(); // accept()�� ������ �����ϰ� �̶� Client�� ������ �����
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // �Է½�Ʈ���� ����
			
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // ��� ��Ʈ���� ����
			
			String str = null;
			str = in.readLine(); // Client�κ��� ������ �о��
			
			System.out.println("Client�κ��� �� �޼��� : "+str);
			
			out.write(str); // print(str)�� ���
			out.flush(); // ���۸����� ���� ��ϵ��� �ʴ� �����͸� ��� ��Ʈ���� ��� ���
			socket.close(); // ��µ��� ���� ��Ʈ���� ��� ����ϰ� ��Ʈ���� ����
		}catch (Exception e) {
			
		}
	
		
		
	}

}
