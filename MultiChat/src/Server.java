import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		Socket socket = null; // Client�� ����ϱ� ���� Socket ����
		User user = new User(); // ä�ù濡 ������ �ִ� Client ���� ��ü
		ServerSocket server_socket = null; // Client ������ �ޱ� ���� ServerSocket
		
		int count = 0; // ������ �Ҵ��� ���� ����
		Thread thread[] = new Thread[10]; // 10������ �����带 �Ҵ�, �� ä�ù濡 10���� ���� �����ϴ�.
		
		try {
			server_socket = new ServerSocket(4444); // ���� ��Ʈ�� ������ ����
			
			while(true) {
				socket = server_socket.accept(); // ����� ����Ǳ� ������ �����Ѵ�.
				
				/*
				 * receiver Class ���� implements Runnable�� ����߱� ������
				 * Thread ��ü �ȿ� �����带 ����Ϸ��� ��ü�� �־��༭ ��üȭ�� �� �� �ִ�.
				 */
				thread[count] = new Thread(new Receiver(socket,user)); // Receiver Ŭ������ Thread���� ����
				thread[count].start(); // ������ ����
				count++;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		// Server�� �� �״�� Client���� User�� ��� �Ǿ��ִٸ� �����Ӱ� ä���� �ְ� �޴� ������ �ȴ�.
		// ������ ������ �ʾҴٸ� Client���� ä���� �� �� ����, �� �ڵ忡���� �ִ� 10���� Client�� ������ ����
		// Thread �迭�� 10���� �����Ǿ� �����Ƿ�
	}
	

}
