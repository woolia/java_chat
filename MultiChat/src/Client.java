import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null;
		DataInputStream in = null; // DataInputStream in은 사용자가 입력하는 채팅 부분에 해당
		BufferedReader in2 = null; // BufferedReader in2는 사용자의 닉네임에 해당된다.
		DataOutputStream out = null; // DataOutputStream out은 사용자가 입력한 데이터를 출력할 때에 사용한다.
		
		try {
			InetAddress ia = null; // Local Host IP Address를 가져오기 위한 변수
			ia = InetAddress.getLocalHost(); // 현재 PC의 IP Address를 가져옴
			socket = new Socket(ia,4444); // client의 IP와 port 번호를 입력
			
			/*
			 * DataInputStream 은 입력 스트림을 받는 매개변수이며
			 * socket.getInputStream() 함수를 통해 소켓에서 전달되는 데이터 스트림을 읽어온다.
			 * BufferedReader 는 Scanner와 비슷한 개념이다.
			 * BufferedReader는 Scanner보다 빠르다는 장점이 있지만 String형으로 버퍼에 저장하기 때문에
			 * 따로 데이터를 가공해서 사용해야하는 경우가 많다.
			 */
			
			in = new DataInputStream(socket.getInputStream());
			in2 = new BufferedReader(new InputStreamReader(System.in));
			out = new DataOutputStream(socket.getOutputStream());
			
			System.out.print("닉네임을 입력해주세요 : ");
			String data = in2.readLine(); // 채팅에 사용할 닉네임을 받아온다.
			
			out.writeUTF(data); //닉네임을 UTF-8로 변경 후 출력스트림에 넣는다.
			Thread th = new Thread(new Send(out)); // 새로운 쓰레드에 out을 집어넣도록 합니다.
			th.start(); // 쓰레드 시작
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			/*
			 * 끊어지기 전까지는 계속 채팅을 입력받기 때문에
			 * 무한루프(while) 안에서 동작한다.
			 * 만일 끊고 싶으면 break에 대한 조건문을 걸면 된다.
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

// Client는 말그대로 사용자 입니다.
// 처음 닉네임을 입력하였다면, Server와 Socket을 통해 연결되는 순간
// User의 권한을 얻고 채팅을 할 수 있게 됩니다.
