import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		Socket socket = null; // Client와 통신하기 위한 Socket 생성
		User user = new User(); // 채팅방에 접속해 있는 Client 관리 객체
		ServerSocket server_socket = null; // Client 접속을 받기 위한 ServerSocket
		
		int count = 0; // 쓰레드 할당을 위한 정수
		Thread thread[] = new Thread[10]; // 10개까지 쓰레드를 할당, 즉 채팅방에 10명이 접속 가능하다.
		
		try {
			server_socket = new ServerSocket(4444); // 서버 포트로 소켓을 연다
			
			while(true) {
				socket = server_socket.accept(); // 통신이 종료되기 전까지 연결한다.
				
				/*
				 * receiver Class 에서 implements Runnable을 사용했기 때문에
				 * Thread 객체 안에 쓰레드를 사용하려는 객체를 넣어줘서 객체화를 할 수 있다.
				 */
				thread[count] = new Thread(new Receiver(socket,user)); // Receiver 클래스를 Thread에서 돌림
				thread[count].start(); // 쓰레드 시작
				count++;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		// Server는 말 그대로 Client들이 User로 등록 되어있다면 자유롭게 채팅을 주고 받는 공간이 된다.
		// 서버가 열리지 않았다면 Client들은 채팅을 할 수 없고, 위 코드에서는 최대 10명의 Client를 유저로 간주
		// Thread 배열이 10으로 설정되어 있으므로
	}
	

}
